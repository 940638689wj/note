<template>
	<div class="index">
    <Toolbar></Toolbar>
    <NoteList></NoteList>
    <NoteDetail></NoteDetail>
    <!-- <router-view></router-view> -->
  </div>
</template>

<script>
import Toolbar from './toolbar'
import NoteList from './noteList'
import NoteDetail from './noteDetail'
import router from '@/router'

export default {
  name: '',
  data () {
    return {
    }
  },
  methods: {
  },
  components: {
    Toolbar,
    NoteList,
    NoteDetail
  },
  created () {
    this.$http.get('/login/isLogin').then(
      res => {
        if (!res.body.result) {
          router.push({name: 'Login'})
        }
      }
      )
  }
}
</script>

<style scoped>
.index{
  height: 100%;
}
</style>
