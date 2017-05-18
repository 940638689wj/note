<template>
  <div class="toolbar">
    <p>笔记</p>
    <i class="glyphicon glyphicon-plus" @click="addNote"></i>
    <i class="glyphicon glyphicon-star" :class="{starred: isCollect}" @click="changeCollenct"></i>
    <i class="glyphicon glyphicon-remove" @click="delNote"></i>
    <el-tooltip class="item" effect="dark" content="11" placement="right" :disabled="noteId < 0">
      <div slot="content">
        <p>修改类型</p>
        <select class="form-control" v-model="changeNoteTyeId">
          <option v-for="noteType in noteTypeList" :value="noteType.typeId">{{noteType.typeName}}</option>
        </select>
        <button class="btn btn-default" @click="changeNoteType">修改</button>
      </div>
      <i class="glyphicon glyphicon-move"></i>
    </el-tooltip>
    <br><br><br>
    <p>类型</p>
    <i class="glyphicon glyphicon-plus" @click="addNoteType"></i>
    <i class="glyphicon glyphicon-remove" @click="delNoteType"></i>
  </div>
</template>

<script>

export default {
  name: 'toolbar',
  data () {
    return {
      isCollect: false,
      changeTypeDisabled: true,
      changeNoteTyeId: -1,
      noteTypeList: [] // 笔记类型列表
    }
  },
  components: {
  },
  computed: {
    // 笔记id
    noteId () {
      return parseInt(this.$store.state.noteId)
    },
    noteTypeId () {
      return parseInt(this.$store.state.noteTypeId)
    }
  },
  watch: {
    noteId () {
      this.refreshNote()
    }
  },
  methods: {
    // 点击增加笔记
    addNote () {
      this.$store.commit('setNoteId', -1)
      this.isCollect = false
    },
    // 修改收藏状态
    changeCollenct () {
      if (this.noteId <= 0) return
      this.$http.post('/note/saveNote', {
        noteId: this.noteId,
        isCollect: this.isCollect ? 0 : 1
      }, {
        emulateJSON: true
      }).then(
      res => {
        this.$message.success((this.isCollect ? '已取消' : '已') + '收藏')
        this.refreshNote()
      }
      )
    },
    // 删除笔记
    delNote () {
      if (this.noteId <= 0) return
      this.$confirm('确认删除？', '删除').then(
        () => {
          this.$http.post('/note/saveNote', {
            noteId: this.noteId,
            statusCd: 0
          }, {
            emulateJSON: true
          }).then(
          res => {
            this.$message.success('删除成功')
            this.$store.commit('setRefreshList')
          }
          )
        }
        )
    },
    // 获取笔记信息
    refreshNote () {
      this.$http.get('/note/getNote', {
        params: {
          noteId: this.noteId
        },
        emulateJSON: true
      }).then(
      res => {
        res.body.data.isCollect === 1 ? this.isCollect = true : this.isCollect = false
      }
      )
    },
    // 增加笔记类型
    addNoteType () {
      this.$store.commit('setShowAddType', true)
    },
    // 删除笔记类型
    delNoteType () {
      if (this.noteTypeId > 0) {
        this.$confirm('确认删除类型？该操作会删除该类型下所有笔记', '删除').then(
          () => {
            this.$http.post('/noteType/delete', {
              noteTypeId: this.noteTypeId
            }, {
              emulateJSON: true
            }).then(
            res => {
              this.$message.success('删除成功')
              this.$store.commit('setRefreshList')
            }
            )
          }
          )
      }
    },
    // 修改笔记类型
    changeNoteType () {
      this.$confirm('确认修改该笔记类型？', '修改').then(
        () => {
          this.$http.post('/note/saveNote', {
            noteId: this.noteId,
            noteTypeId: this.changeNoteTyeId
          }, {
            emulateJSON: true
          }).then(
            res => {
              this.$message.success('修改成功')
              this.$store.commit('setRefreshList')
            }
            )
        }
        )
    }
  },
  created () {
    this.refreshNote()
    // 获取所有笔记
    this.$http.get('/noteType/findNoteTypeList').then(
      res => {
        this.noteTypeList = res.body.data
        this.changeNoteTyeId = this.noteTypeList[0].typeId
      }
      )
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
.toolbar {
  float: left;
  width: 80px;
  height: 100%;
  background-color: #30414D;
  color: #767676;
  padding: 35px 25px 25px 25px;

  i {
    font-size: 30px;
    margin-bottom: 35px;
    cursor: pointer;
    opacity: 0.8;
    transition: opacity 0.5s ease;
  }

  i:hover {
    opacity: 1;
  }

  .starred {
    color: #F7AE4F;
  }

}

</style>
