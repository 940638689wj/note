<html>
<head>
</head>
<body>
<div class="container">
    <form id="J_Form" class="form-horizontal" action="/user/saveUser" method="post">
        <div id="edit-div" class="form-content">
            <div class="row">
                <div class="control-group">
                    <label class="control-label"><s>*</s>登录名：</label>
                    <div class="controls">
                        <input id="Login_Name" name="Login_Name" data-rules="{required:true}" class="input-normal control-text">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group">
                    <label class="control-label"><s>*</s>密码：</label>
                    <div class="controls">
                        <input name="Password" data-rules="{required:true}" class="input-normal control-text">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group">
                    <label class="control-label"><s>*</s>性别：</label>
                    <div class="controls" data-rules="{required:true}">
                        <label><input type="radio" name="sexCd" value="0" checked="checked" /> 男</label>&nbsp;&nbsp;&nbsp;&nbsp;
                        <label><input type="radio" name="sexCd" value="1"  /> 女</label>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="control-group">
                    <label class="control-label"><s>*</s>联系方式：</label>
                    <div class="controls">
                        <input id="phone" name="phone" data-rules="{required:true}" class="input-normal control-text">
                        <span id="phoneInfo" class="x-field-error"></span>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="control-group">
                    <label class="control-label"><s>*</s>启用状态：</label>
                    <div class="controls" data-rules="{required:true}">
                        <label><input type="radio" name="statusCd" value="1" checked="checked" /> 是</label>&nbsp;&nbsp;&nbsp;&nbsp;
                        <label><input type="radio" name="statusCd" value="0"  /> 否</label>
                    </div>
                </div>
            </div>
            <div class="actions-bar">
                <button type="submit" id="save" class="button button-primary">保存</button>
                <button type="reset" class="button">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>