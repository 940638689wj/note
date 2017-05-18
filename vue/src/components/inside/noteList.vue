<template>
  <div class="noteList">
    <div class="user">
      您好，{{user.userName}}
      <button class="btn btn-default" @click="logout">退出</button>
    </div>

    <div class="btn-group btn-group-justified" role="group">
      <!-- 列表按钮 -->
      <template v-for="(btn,index) in btnList">
        <div class="btn-group" role="group">
          <button type="button" class="btn btn-default" :class="{active: type == index}" @click="type = index">
            {{btn}}
          </button>
        </div>
      </template>
    </div>

    <!-- 列表 -->
    <div class="container">
      <div class="list-group">
        <template v-for="(noteType,index) in noteTypeList">
          <a class="list-group-item" @click="changeShow(index)">
            <h4 class="list-group-item-heading">
              <i :class="{'glyphicon': true,
              'glyphicon-menu-right': !noteListShow[index],
              'glyphicon-menu-down': noteListShow[index]}"></i>
              {{noteType.typeName}}
            </h4>
          </a>
          <a class="list-group-item" :style="{display: noteListShow[index] ? 'block' : 'none','border-top': '1px solid #e8e8e8', 'background-color': noteId == note.noteId ? '#cccccc' : ''}" v-for="note in noteType.noteList" @click="changeNoteId(note.noteId)">
              <h5>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                {{note.noteTitle.length < 15 ? note.noteTitle : note.noteTitle.substring(0,15) + '...'}}
                <i class="glyphicon glyphicon-share-alt recovery" v-show="type == 2" @click="recovery(note.noteId)"></i>
              </h5>
          </a>
        </template>
        <addNoteType></addNoteType>
      </div>
    </div>

  </div>
</template>

<script>
import Vue from 'vue'
import router from '@/router'

import addNoteType from './components/addNoteType'

export default {
  name: 'noteList',
  data () {
    return {
      btnList: ['所有笔记', '收藏笔记', '回收站'],
      // 笔记列表信息
      noteTypeList: [],
      // 笔记伸缩标识
      noteListShow: [],
      // 用户信息
      user: {},
      // 选中的列表类型 0：全部 1：收藏 2：回收站
      type: 0,
      // 笔记列表查询参数
      params: {
        statusCd: 1,
        isCollect: null
      }
    }
  },
  components: {
    addNoteType
  },
  computed: {
    // 笔记id
    noteId () {
      return parseInt(this.$store.state.noteId) > 0 ? this.$store.state.noteId : null
    },
    refreshList () {
      return this.$store.state.refreshList
    }
  },
  watch: {
    // 更新笔记
    refreshList () {
      this.loadList()
    },
    type (val) {
      if (val === 0) {
        this.params.statusCd = 1
        this.params.isCollect = null
      } else if (val === 1) {
        this.params.statusCd = 1
        this.params.isCollect = 1
      } else if (val === 2) {
        this.params.statusCd = 0
        this.params.isCollect = null
      }
      this.loadList()
    }
  },
  methods: {
    // 登出
    logout () {
      this.$confirm('确认退出？', '退出').then(
        () => {
          this.$http.post('/login/logout').then(
          res => {
            if (res.body.result) {
              router.push({name: 'Login'})
            }
          }
          )
        }
        )
    },
    // 选择笔记分类
    changeShow (index) {
      this.$store.commit('setNoteId', -1)
      // 设置全局的类型id
      if (this.noteListShow[index]) {
        this.$store.commit('setNoteTypeId', -1)
      } else {
        this.$store.commit('setNoteTypeId', this.noteTypeList[index].typeId)
      }
      // 保持下拉只展开一个
      // Vue.set(this.noteListShow, index, !this.noteListShow[index])
      for (var i = this.noteListShow.length - 1; i >= 0; i--) {
        if (i === index) {
          Vue.set(this.noteListShow, i, !this.noteListShow[index])
        } else {
          Vue.set(this.noteListShow, i, false)
        }
      }
    },
    // 选中笔记
    changeNoteId (noteId) {
      this.$store.commit('setNoteId', noteId)
    },
    recovery (noteId) {
      this.$confirm('确认恢复该笔记？恢复后将进入默认列表', '恢复').then(
        () => {
          this.$http.post('/note/saveNote', {
            noteId: noteId,
            noteTypeId: this.noteTypeList[0].typeId,
            statusCd: 1
          }, {
            emulateJSON: true
          }).then(
          res => {
            this.$message.success('恢复成功')
            this.loadList()
          }
          )
        }
        )
    },
    // 获取笔记列表
    loadList () {
      this.$http.get('/noteType/findList', {
        params: this.params,
        emulateJSON: true
      }).then(
        res => {
          this.noteTypeList = res.body.data
          this.$store.commit('setNoteTypeId', this.noteTypeList[0].typeId)
          for (var i = this.noteTypeList.length - 1; i >= 0; i--) {
            if (i === this.noteTypeList.length - 1) {
              this.noteListShow.push(true)
            } else {
              this.noteListShow.push(false)
            }
          }
        }
        )
    }
  },
  created () {
    // 获取用户信息
    this.$http.get('/user/getUser').then(
      res => {
        this.user = res.body.data
      }
      )
    // 获取笔记列表
    this.loadList()
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
.noteList {
  float: left;
  width: 300px;
  height: 100%;
  background-color: #eaeaea;
  font-family: 'Arial', sans-serif;
  font-weight: 400;

  // 用户信息
  .user {
    font-weight: bold;
    font-size: 15px;
    padding: 12px;

    .btn {
      float: right;
      margin-top: -5px;
    }
  }

  // 笔记列表
  .container {
    max-height: calc(100%);
    overflow: auto;
    width: 100%;
    padding: 0;
    margin-top: 30px;

    .list-group-item {
      border: 0;
      border-radius: 0;

      .list-group-item-heading {
        font-weight: 300;
        font-size: 15px;
      }

    }

    .recovery {
      float: right;
    }

    .recovery:hover {
      cursor: pointer;
    }

  }

}

</style>
