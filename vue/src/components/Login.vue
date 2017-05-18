<template>
  <div class="login">
    <div class="border">登录</div>  
      <form class="form-horizontal col-sm-offset-4 form">
        <div class="form-group">
          <label for="loginName" class="col-sm-1 control-label">账号</label>
          <div class="col-sm-4">
            <input v-model="form.loginName" type="email" class="form-control" id="loginName" placeholder="请输入账号">
          </div>
        </div>
        <div class="form-group">
          <label for="password" class="col-sm-1 control-label">密码</label>
          <div class="col-sm-4">
            <input v-model="form.password" type="password" class="form-control" id="password" placeholder="请输入密码">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-1 col-sm-4">
            <button type="button" class="btn btn-primary" @click="submit">登录</button>
            <button type="button" class="btn btn-default" @click="reset">重置</button>
            还没有账号？先<router-link :to="{name: 'Register'}">注册</router-link>

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
  name: 'login',
  data () {
    return {
      form: {
        loginName: '',
        password: ''
      },
      alertShow: false,
      errMsg: ''
    }
  },
  methods: {
    // 提交登录表单
    submit () {
      if (!this.form.loginName) {
        this.errMsg = '账号不能为空'
        this.alertShow = true
      } else if (!this.form.password) {
        this.errMsg = '密码不能为空'
        this.alertShow = true
      } else {
        this.$http.post('/login/loginPost', this.form, {
          emulateJSON: true
        }).then(
        res => {
          if (res.body.result) {
            this.$message.success('登录成功')
            router.push({name: 'Index'})
          } else {
            this.errMsg = '账号或密码错误'
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
        passowrd: ''
      }
    }
  },
  created () {
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="less">
.login{
  background-image: url('../assets/login.jpg');
  background-size: 100% 100%;
  height: 100%;
  width: 100%;

  .border{
    background-color: #fafafa;
    margin: 240px 0 0 30%;
    border: 1px solid #aaaaaa;
    height: 260px;
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
    padding-top: 300px;
  }
}

</style>
