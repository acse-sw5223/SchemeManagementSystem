<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ include file="/views/include/taglib.jsp" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>主页</title>
    <%@ include file="/views/include/head.jsp" %>
    <script type="text/javascript">
        $(document).ready(function () {

        });

        function page(n) {
            $("#pageNo").val(n);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>

<body>
<div class="container-fluid">
    <ul class="nav nav-tabs">
        <li><a href="${adminPath}/bookMakes?method=list&requirementItemNo=${bookMakesBean.requirementItemNo}">制定书列表</a>
        </li>

        <c:if test="${bookMakesBean.id == null}">
            <li><a
                    href="${adminPath}/bookMakes?method=form&id=${bookMakesBean.id}&requirementItemNo=${bookMakesBean.requirementItemNo}">新增制定书</a>
            </li>
        </c:if>
        <c:if test="${bookMakesBean.id != null}">
            <li><a
                    href="${adminPath}/bookMakes?method=form&id=${bookMakesBean.id}&requirementItemNo=${bookMakesBean.requirementItemNo}">修改制定书</a>
            </li>
            <li class="active"><a href="${adminPath}/bookMakes?method=fixList&schemeNo=${bookMakesBean.schemeNo}">修改记录</a></li>
            <li><a href="${adminPath}/auditRecords?method=list&schemeNo=${bookMakesBean.schemeNo}">审核记录</a></li>
        </c:if>
    </ul>
    <br/>
    <c:if test="">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <strong>提示!</strong> ${msg}
        </div>
    </c:if>
    <br/>
    <table class="table table-hover table-bordered">
        <thead>
        <tr>
            <th>序号</th>
            <th>方案编号</th>
            <th>方案修改记录</th>
            <th>返修人</th>
            <th>返修日期</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page }" var="planFixRecords" varStatus="num">
            <tr>
                <td>${num.index+1}</td>

                <td><a href="${adminPath}/planFixRecords?method=form&id=${planFixRecords.id}">
                        ${planFixRecords.schemeNo}
                </a></td>
                <td>
                        ${planFixRecords.schemeModificationRecord}
                </td>
                <td>
                        ${fns:getTableDataByPk("db_user", "id", planFixRecords.schemeRepairer, "name")}
                </td>
                <td>
                    <fmt:formatDate value="${planFixRecords.schemeRepairDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>

            </tr>
        </c:forEach>

        </tbody>
    </table>

</div>
</body>
</html>






































