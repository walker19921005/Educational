<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" href="${pageContext.request.contextPath}/static/css/bootstrap-table.css" rel="stylesheet">
    <link type="text/css"
          href="${pageContext.request.contextPath}/static/css/plugins/x-editable/bootstrap-editable.css"
          rel="stylesheet">
    <link type="text/css" href="${pageContext.request.contextPath}/static/css/plugins/select2/select2.min.css" rel="stylesheet">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/bootstrap-table.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/bootstrap-table-zh-CN.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/plugins/x-editable/bootstrap-editable.js"></script>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/plugins/editable/bootstrap-table-editable.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/select2/select2.full.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/toolbar/bootstrap-table-toolbar.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/student.js"></script>

</head>
<body>
<div class="panel-body" style="padding-bottom:0px;">
    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>
        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
                <div class="form-group" style="margin-top:15px">
                    <label class="control-label col-sm-1"
                           for="txt_search_departmentname">部门名称</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="txt_search_departmentname">
                    </div>
                    <label class="control-label col-sm-1" for="txt_search_statu">状态</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="txt_search_statu">
                    </div>
                    <div class="col-sm-4" style="text-align:left;">
                        <button type="button" style="margin-left:50px" id="btn_query"
                                class="btn btn-primary">查询
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div id="toolbar" class="fixed-table-toolbar">
        <button type="button" class="btn btn-default">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true" data-toggle="modal"
                                      data-target="#addEmp"></span>
        </button>
        <button id="btn_delete" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        </button>
    </div>
    <div class=table-responsive">
    <table id="stuTable" class="table table-striped table-bordered table-hover text-nowrap"></table>
    </div>
</div>
</body>
</html>
