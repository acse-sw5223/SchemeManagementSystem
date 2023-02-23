<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ include file="/views/include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>主页</title>
    <%@ include file="/views/include/head.jsp" %>
    <script
            src="${adminPath }/static/jquery-validation-1.14.0/lib/jquery.js"></script>
    <script
            src="${adminPath }/static/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("#submitForm").validate({
                rules: {
                    username: {
                        required: true,
                        minlength: 4,
                        remote: {
                            depends: function (element) {
                                return element.value !== "${user.username}";
                            },
                            param: {
                                url: "${adminPath}/user?method=checkUserName",     //后台处理程序
                                type: "post",               //数据发送方式
                                dataType: "json",           //接受数据格式
                                data: {                     //要传递的数据
                                    username: function () {
                                        return $("#username").val();
                                    }
                                },
                                cache: false
                            }
                        }
                    },
                    trueName: {
                        required: true
                    },
                    sex: {
                        required: true,
                        maxlength: 2
                    },
                    phone: {
                        required: true,
                        maxlength: 11
                    }
                },
                messages: {
                    username: {
                        required: "请输入用户名",
                        minlength: "用户名必须4位以上",
                        remote: "用户名已存在，请重新输入"
                    },
                    trueName: {
                        required: "请输入昵称"
                    },
                    sex: {
                        required: "请输入性别",
                        minlength: "不能超过2个字符"
                    },
                    phone: {
                        required: "请输入手机号码",
                        minlength: "手机号码只能是11位"
                    }
                }
            })
        });

        function page(n) {
            $("#pageNo").val(n);
            $("#searchForm").submit();
            return false;
        }
    </script>
    <style type="text/css">
        .error {
            display: block;
            overflow: hidden;
            padding: 0 8px 0 0;
            position: relative;
            color: red;
        }
    </style>
</head>

<body>
<div class="container-fluid">

    <ul class="nav nav-tabs">
        <li><a href="${adminPath}/user?method=list">系统用户列表</a></li>
        <li class="active"><a href="${adminPath}/user?method=form&id=${user.id}">系统用户添加</a></li>
    </ul>
    <br/>
    <form id="submitForm" class="form-horizontal" role="form" action="${adminPath}/user?method=save" method="post"
          enctype="multipart/form-data">
        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="role" value="${user.role}">
        <div class="form-group">
            <label for="username" class="col-sm-3 control-label">用户名</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名"
                       value="${user.username}">
            </div>
        </div>
        <div class="form-group" style="display: none;">
            <label for="password" class="col-sm-3 control-label">密码</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码"
                       value="${user.password}">
            </div>
        </div>
        <div class="form-group">
            <label for="name" class="col-sm-3 control-label">昵称</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入昵称" value="${user.name}">
            </div>
        </div>
        <div class="form-group">
            <label for="picture" class="col-sm-3 control-label">头像</label>
            <div class="col-sm-5">
                <img src="${user.picture}" alt="" class="img-circle" style="width: 50px;height: 50px;">
                <input type="file" id="picture" name="picture" placeholder="请输入昵称">
                <input type="hidden" name="picture" value="${user.picture}">
            </div>
        </div>
        <div class="form-group">
            <label for="sex" class="col-sm-3 control-label">性别</label>
            <div class="col-sm-5">
                <c:forEach items="${fns:dictList('sex')}" var="dict">
                    <label class="radio-inline">
                        <input type="radio" name="sex" id="sex" value="${dict.dictValue}" <c:if test="${user.sex == dict.dictValue}">checked</c:if> > ${dict.dictLabel}
                    </label>
                </c:forEach>

            </div>
        </div>
        <div class="form-group">
            <label for="phone" class="col-sm-3 control-label">联系方式</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入联系方式"
                       value="${user.phone}">
            </div>
        </div>
        <div class="form-group">
            <label for="content" class="col-sm-3 control-label">个人简介</label>
            <div class="col-sm-5">
                <textarea rows="20" cols="" class="form-control" id="content" name="content">${user.content}</textarea>
            </div>
        </div>


        <div class="form-group">
            <label class="col-sm-3 control-label"></label>
            <div class="col-sm-5">
                <input type="submit" class="btn btn-success btn-sm" value="保存">
                <input type="button" class="btn btn-default btn-sm" value="返回" onclick="history.go(-1)">
            </div>
        </div>
    </form>
</div>
</body>
</html>