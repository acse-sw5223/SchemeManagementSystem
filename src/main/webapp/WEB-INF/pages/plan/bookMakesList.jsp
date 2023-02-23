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
        <li class="active"><a href="${adminPath}/bookMakes?method=list&requirementItemNo=${requirementItemNo}">制定书列表</a>
        </li>
        <li><a href="${adminPath}/bookMakes?method=form&requirementItemNo=${requirementItemNo}">添加制定书</a></li>
    </ul>
    <br/>
    <c:if test="">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span
                    aria-hidden="true">&times;</span></button>
            <strong>提示!</strong> ${msg}
        </div>
    </c:if>
    <form class="form-inline" id="searchForm" action="${adminPath}/bookMakes?method=list" method="post">
        <input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo }">

        <div class="form-group">
            <label for="schemeNo">方案编号</label>
            <input type="text" class="form-control" name="schemeNo" id="schemeNo" placeholder="请输入方案编号"
                   value="${schemeNo}">
        </div>
        <div class="form-group">
            <label for="schemeFormulator">制定员</label>
            <select class="form-control" id="schemeFormulator" name="schemeFormulator">
                <option value="">-请选择-</option>
                <c:forEach items="${fns:getTableData('db_user', 'id', 'name')}" var="item">
                    <option value="${item.value}"
                            <c:if test="${schemeFormulator == item.value}">selected</c:if> >${item.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="requirementItemNo">需求编号</label>
            <select class="form-control" id="requirementItemNo" name="requirementItemNo">
                <option value="">-请选择-</option>
                <c:forEach items="${fns:getTableData('plan_demand_info', 'id', 'experiment_name')}" var="item">
                    <option value="${item.value}"
                            <c:if test="${requirementItemNo == item.value}">selected</c:if> >${item.name}</option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary btn-sm">
            <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
            查询
        </button>
    </form>
    <br/>
    <table class="table table-hover table-bordered">
        <thead>
        <tr>
            <th>序号</th>
            <th>需求编号</th>
            <th>方案编号</th>
            <th>方案描述</th>
            <th>方案细则</th>
            <th>制定员</th>
            <th>制定日期</th>
            <th>方案状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${page.list }" var="bookMakes" varStatus="num">
            <tr>
                <td>${num.index+1+page.pageSize*(page.pageNo-1) }</td>
                <td>
                        ${fns:getTableDataByPk("plan_demand_info", "id", bookMakes.requirementItemNo, "experiment_name")}
                </td>
                <td><a href="${adminPath}/bookMakes?method=form&id=${bookMakes.id}">
                        ${bookMakes.schemeNo}
                </a></td>
                <td>
                        ${bookMakes.schemeDescription}
                </td>
                <td>
                        ${bookMakes.schemeProgramRules}
                </td>
                <td>
                        ${fns:getTableDataByPk("db_user", "id", bookMakes.schemeFormulator, "name")}
                </td>
                <td>
                    <fmt:formatDate value="${bookMakes.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
                <td>
                        ${fns:dictLable("plan_status", bookMakes.planStatus)}
                </td>


                <td>

                    <c:if test="${bookMakes.planStatus != '0' && bookMakes.planStatus != '2'}">
                        <a href="${adminPath }/bookMakes?method=form&id=${bookMakes.id}">
                            <button class="btn btn-warning btn-xs">
                                查看
                            </button>
                        </a>
                    </c:if>
                    <c:if test="${bookMakes.planStatus == '0' || bookMakes.planStatus == '2'}">
                        <a href="${adminPath }/bookMakes?method=form&id=${bookMakes.id}">
                            <button class="btn btn-primary btn-xs">
                                编辑
                            </button>
                        </a>
                        <a href="${adminPath }/bookMakes?method=submitToAudit&id=${bookMakes.id}"
                           onclick="return confirm('确认要提交审批部吗？', this.href)">
                            <button class="btn btn-info btn-xs">
                                提交审批部
                            </button>
                        </a>
                        <a href="${adminPath }/bookMakes?method=delete&id=${bookMakes.id}"
                           onclick="return confirm('确认要删除吗？', this.href)">
                            <button class="btn btn-danger btn-xs">
                                删除
                            </button>
                        </a>
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






































