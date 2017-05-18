import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    noteId: '-1',
    noteTypeId: '-1',
    refreshList: 0,
    showAddType: false
  },
  mutations: {
    setNoteId (state, msg) {
      state.noteId = msg
    },
    setNoteTypeId (state, msg) {
      state.noteTypeId = msg
    },
    setRefreshList (state) {
      state.refreshList++
    },
    setShowAddType (state, msg) {
      state.showAddType = msg
    }
  }
})
