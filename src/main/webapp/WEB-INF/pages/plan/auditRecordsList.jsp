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
        <li class="active"><a href="javascript:void(0);">审核列表列表</a></li>
    </ul>
    <br/>
    <c:if test="">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <strong>提示!</strong> ${msg}
        </div>
    </c:if>
    <form class="form-inline" id="searchForm" action="${adminPath}/auditRecords?method=list" method="post">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo }">
        <a class="btn btn-primary btn-sm" href="javascript:history.go(-1);"><span class="glyphicon glyphicon-search"
                                                                                  aria-hidden="true"></span>
            返回
        </a>
    </form>
    <br/>
    <table class="table table-hover table-bordered">
        <thead>
        <tr>
            <th>序号</th>
            <th>方案编号</th>
            <th>审核日期</th>
            <th>审核意见</th>
            <th>审核人</th>
            <th>审核结果</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list }" var="auditRecords" varStatus="num">
            <tr>
                <td>${num.index+1+page.pageSize*(page.pageNo-1) }</td>

                <td><a href="${adminPath}/auditRecords?method=form&id=${auditRecords.id}">
                        ${auditRecords.schemeNo}
                </a></td>
                <td>
                    <fmt:formatDate value="${auditRecords.schemeAuditDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                        ${auditRecords.cchemeReviewComments}
                </td>
                <td>
                        ${auditRecords.schemeReviewer}
                </td>


                <td>
                    <c:if test="${auditRecords.auditStatus == '0'}">
							<span class="btn-danger btn-sm">
                                    ${fns:dictLable("audit_status", auditRecords.auditStatus)}
                            </span>
                    </c:if>
                    <c:if test="${auditRecords.auditStatus == '1'}">
							<span class="btn-info btn-sm">
                                    ${fns:dictLable("audit_status", auditRecords.auditStatus)}
                            </span>
                    </c:if>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <%@ include file="/views/include/pageinfo.jsp" %>
</div>
</body>
</html>






































