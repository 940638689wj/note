<template>
	<div class="addNoteType">
    <a class="list-group-item" v-show="showAddType">
      <input v-model="typeName" class="form-control inputAddType" placeholder="请输入类型名称">
      <button class="btn btn-default confirmAddType" type="button" @click="confirmAddType"><i class="glyphicon glyphicon-ok"></i></button>
      <button class="btn btn-default calcenAddType" type="button" @click="cancelAddType"><i class="glyphicon glyphicon-remove"></i></button>
    </a>
  </div>
</template>

<script>

export default {
  name: 'addNoteType',
  data () {
    return {
      typeName: ''
    }
  },
  computed: {
    showAddType () {
      return this.$store.state.showAddType
    }
  },
  methods: {
    // 确认新增类型
    confirmAddType () {
      if (!this.typeName) {
        this.$message.error('类型名称不能为空')
        return false
      }

      this.$http.post('noteType/saveNoteType', {
        typeName: this.typeName
      }, {
        emulateJSON: true
      }).then(
      res => {
        this.$message.success('添加类型成功')
        this.$store.commit('setShowAddType', false)
        this.$store.commit('setRefreshList')
      }
      )
    },
    // 取消新增类型
    cancelAddType () {
      this.$store.commit('setShowAddType', false)
    }
  },
  created () {
  }
}
</script>

<style scoped lang="less">
.addNoteType{
  // 添加类型相关
  .inputAddType{
    width: 180px;
  }
  
  .confirmAddType{
    position:absolute;
    right: 55px;
    top: 10px;
  }

  .calcenAddType{
    position:absolute;
    right: 10px;
    top: 10px;
  }
}
</style>
