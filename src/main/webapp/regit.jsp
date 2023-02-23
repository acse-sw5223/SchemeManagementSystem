<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/views/include/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>
<%@ include file="/views/include/head.jsp"%>
<script
	src="${adminPath }/static/jquery-validation-1.14.0/lib/jquery.js"></script>
<script
	src="${adminPath }/static/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
	});

	$().ready(function() {
		// 在键盘按下并释放及提交后验证提交表单
		$("#submitForm").validate({
			rules : {
				username : {
					required : true,
					minlength :4,
					remote: {
					    url: "${adminPath}/user?method=checkUserName",     //后台处理程序
					    type: "post",               //数据发送方式
					    dataType: "json",           //接受数据格式   
					    data: {                     //要传递的数据
					        username: function() {
					            return $("#username").val();
					        }
					    }
					}
				},
				trueName : {
					required : true
				},
				sex : {
					required : true,
					maxlength : 2
				},
				phone : {
					required : true,
					maxlength : 11
				},
				password : {
					required : true,
					minlength : 5
				},
				password_again : {
					required : true,
					minlength : 5,
					equalTo : "#password"
				}
			},
			messages : {
				username : {
					required : "请输入用户名",
					minlength : "用户名必须4位以上",
					remote : "用户名已存在，请重新输入"
				},
				trueName : {
					required : "请输入昵称"
				},
				sex : {
					required : "请输入性别",
					minlength : "不能超过2个字符"
				},
				phone : {
					required : "请输入手机号码",
					minlength : "手机号码只能是11位"
				},
				password : {
					required : "请输入密码",
					minlength : "密码长度不能小于 5 个字母"
				},
				password_again : {
					required : "请输入确认密码",
					minlength : "密码长度不能小于 5 个字母",
					equalTo : "两次密码输入不一致"
				}
			}
		})
	});

</script>

<style type="text/css">
	.error{
display: block;
    overflow: hidden;
    padding: 0 8px 0 0;
    position: relative;
    color:red;
}
</style>
</head>

<body style="background-color: #FFFAF0;">
	<div class="container" style="text-align: center; margin-top: 170px;">
		<div class="row" style="text-align: center;">
			<div class="col-sm-3"></div>
			<div class="col-sm-6" style="background-color: #FFF0F5;">
				<br />
				<div class="row" style="text-align: center; font-size: 26px;">用户注册</div>
				<br />
				<form class="form-horizontal" role="form" id="submitForm"
					action="${adminPath}/user?method=regit" method="post">
					<input type="hidden" name="role" value="2">
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">用户名<b
							style="color: red;">*</b></label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="username"
								name="username" placeholder="请输入用户名">
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">昵称<b
							style="color: red;">*</b></label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="trueName"
								name="trueName" placeholder="请输入昵称" >
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">性别<b
							style="color: red;">*</b></label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="sex" name="sex"
								placeholder="请输入性别" >
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">联系方式<b
							style="color: red;">*</b></label>
						<div class="col-sm-9">
							<input type="text" class="form-control" id="phone" name="phone"
								placeholder="请输入联系方式" >
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">密码<b
							style="color: red;">*</b></label>
						<div class="col-sm-9">
							<input type="password" class="form-control" id="password"
								name="password" placeholder="请输入密码" >
						</div>
					</div>
					<div class="form-group">
						<label for="name" class="col-sm-3 control-label">确认密码<b
							style="color: red;">*</b></label>
						<div class="col-sm-9">
							<input type="password" class="form-control" id="password_again"
								name="password_again" placeholder="请输入密码">
						</div>
					</div>



					<div class="form-group">
						<label for="sort" class="col-sm-3 control-label"></label>
						<div class="col-sm-9">
							<input type="submit" class="btn btn-success btn-sm" value="注册">
							<!-- <a href="#" class="btn btn-success btn-sm"  onclick="submit();">注册</a> -->
							<input type="button" class="btn btn-default btn-sm" value="返回"
								onclick="history.go(-1)">
						</div>
					</div>
				</form>
				<br />
			</div>
			<div class="col-sm-2"></div>
		</div>
	</div>
</body>
</html>