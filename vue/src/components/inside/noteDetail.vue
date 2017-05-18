<template>
	<div class="diaryDetail">
    <form class="form-horizontal">

      <div class="form-group">
        <label for="title" class="col-sm-1 control-label">标题</label>
        <div class="col-sm-10">
          <input v-model="noteTitle" id="title" class="form-control" placeholder="请输入标题">
        </div>
      </div>

      <div class="form-group">
        <label for="content" class="col-sm-1 control-label">内容</label>
        <div class="col-sm-10">
          <div id="editor" class="form-control"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-offset-1 col-sm-10">
          <button type="button" class="btn btn-primary" @click="submit">{{btnText}}</button>
        </div>
      </div>

    </form>
  </div>
</template>

<script>
import WangEditor from 'wangeditor'

export default {
  name: 'diaryDetail',
  data () {
    return {
      editor: null,
      noteTitle: '',
      btnText: '新增'
    }
  },
  computed: {
    // 笔记id
    noteId () {
      return parseInt(this.$store.state.noteId) > 0 ? this.$store.state.noteId : null
    },
    // 当前选中类型id
    noteTypeId () {
      return this.$store.state.noteTypeId
    }
  },
  watch: {
    // 监听笔记id 动态加载详情
    noteId (val) {
      if (parseInt(val) > 0) {
        this.$http.get('/note/getNote', {
          params: {
            noteId: val
          },
          emulateJSON: true
        }).then(
          res => {
            this.noteTitle = res.body.data.noteTitle
            this.editor.$txt.html(res.body.data.noteContent)
            this.btnText = '修改'
          }
          )
      } else {
        this.noteTitle = ''
        this.editor.$txt.html('')
        this.btnText = '新增'
      }
    }
  },
  methods: {
    // 保存笔记
    submit () {
      this.$http.post('/note/saveNote', {
        noteId: this.noteId,
        noteTitle: this.noteTitle,
        noteContent: this.editor.$txt.html(),
        noteTypeId: this.noteTypeId
      }, {
        emulateJSON: true
      }).then(
      res => {
        if (res.body.result) {
          this.$message.success(this.btnText + '成功')
          if (this.btnText === '新增') {
            this.noteTitle = ''
            this.editor.$txt.html('')
          }
          this.$store.commit('setRefreshList')
        }
      }
      )
    }
  },
  created () {
  },
  mounted () {
    // 初始化富文本
    this.editor = new WangEditor('editor')
    this.editor.create()
  }
}
</script>

<style scoped lang="less">
.diaryDetail{
  float: left;
  height: 100%;
  width: 100%-180px;
  background-color: #f3f3f3;
  background-image: url('../../assets/detail.png');

  form{
    margin-top: 50px;

    #editor{
      height: 500px;
    }
  }
}
</style>
