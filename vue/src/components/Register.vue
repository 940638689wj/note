<template>
  <div class="register">
    <div class="border">注册</div>  
    <form class="form-horizontal col-sm-offset-4 form">
      <div class="form-group">
        <label for="loginName" class="col-sm-1 control-label">账号</label>
        <div class="col-sm-4">
          <input type="email" class="form-control" id="loginName" v-model="form.loginName" placeholder="请输入账号">
        </div>
      </div>
      <div class="form-group">
        <label for="password" class="col-sm-1 control-label">密码</label>
        <div class="col-sm-4">
          <input type="password" class="form-control" id="password" v-model="form.password" placeholder="不得小于六位">
        </div>
      </div>
      <div class="form-group">
        <label for="password" class="col-sm-1 control-label">重复密码</label>
        <div class="col-sm-4">
          <input type="password" class="form-control" id="password" v-model="form.agPassword" placeholder="请重复密码">
        </div>
      </div>
      <div class="form-group">
        <label for="userName" class="col-sm-1 control-label">用户名</label>
        <div class="col-sm-4">
          <input type="email" class="form-control" id="userName" v-model="form.userName" placeholder="请输入用户名">
        </div>
      </div>
      <div class="form-group">
        <label for="password" class="col-sm-1 control-label">性别</label>
        <div class="col-sm-4">
          <label class="radio-inline">
            <input type="radio" name="sexCd" value="0" v-model="form.sexCd"> 男
          </label>
          <label class="radio-inline">
            <input type="radio" name="sexCd" value="1" v-model="form.sexCd"> 女
          </label>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-1 col-sm-4">
          <button type="button" class="btn btn-primary" @click="submit">注册</button>
          <button type="button" class="btn btn-default" @click="reset">重置</button>
          已有账号？去<router-link :to="{name: 'Login'}">登录</router-link>
          <div class="alert alert-warning" :style="{display: alertShow ? 'block' : 'none'}">
            <a href="javascript:void(0)" class="" data-dismiss="alert">
              &times;
            </a>
            {{errMsg}}
          </div>
        </div>
      </div>
    </form>
  </div>
</template>

<script>
import router from '@/router'

export default {
  name: 'register',
  data () {
    return {
      form: {
        loginName: '',
        password: '',
        agPassword: '',
        userName: '',
        sexCd: 0
      },
      alertShow: false,
      errMsg: ''
    }
  },
  methods: {
    // 提交注册
    submit () {
      if (!this.form.loginName) {
        this.errMsg = '账号不能为空'
        this.alertShow = true
      } else if (!this.form.password) {
        this.errMsg = '密码不能为空'
        this.alertShow = true
      } else if (this.form.password.length < 6) {
        this.errMsg = '密码不能少于六位'
        this.alertShow = true
      } else if (!this.form.agPassword) {
        this.errMsg = '重复密码不能为空'
        this.alertShow = true
      } else if (this.form.password !== this.form.agPassword) {
        this.errMsg = '密码和重复密码不同'
        this.alertShow = true
      } else if (!this.form.userName) {
        this.errMsg = '用户名不能为空'
        this.alertShow = true
      } else {
        this.$http.post('/register/register_post', this.form, {
          emulateJSON: true
        }).then(
        res => {
          if (res.body.result) {
            this.$message.success('注册成功')
            router.push({name: 'Login'})
          } else {
            this.errMsg = '账号已存在'
            this.alertShow = true
          }
        }
        )
      }
    },
    // 重置
    reset () {
      this.form = {
        loginName: '',
        password: '',
        agPssword: '',
        userName: '',
        sexCd: 0
      }
    }
  },
  created () {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
.register{
  background-image: url('../assets/login.jpg');
  background-size: 100% 100%;
  height: 100%;
  width: 100%;

  .border{
    background-color: #fafafa;
    margin: 140px 0 0 30%;
    border: 1px solid #aaaaaa;
    height: 400px;
    width: 35%;
    border-radius: 20px;
    position: absolute;

    font-size: 20px;
    font-weight: bold;
    color: #333333;
    text-align: center;
    padding-top: 10px;
  }

  .form{
    padding-top: 200px;
  }
}

</style>
