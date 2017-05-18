<html>
<body>
<form id="J_Form" class="form-horizontal" action="/user/saveUser" method="post">
    <input name="loginName">
    <input name="Password">
    <input type="radio" name="sexCd" value="0" checked="checked"/> 男</label>&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="radio" name="sexCd" value="1"/> 女
    <input id="phone" name="phone" data-rules="{required:true}">
    <input type="radio" name="statusCd" value="1" checked="checked"/> 是</label>&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="radio" name="statusCd" value="0"/> 否
    <button type="submit">保存</button>
</form>
</body>
</html>
