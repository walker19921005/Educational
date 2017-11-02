<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/table.jsp"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/dict.js"></script>
</head>
<body>
<div class="panel-body" style="padding-bottom:0px;">
    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>
        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
                <div class="form-group" style="margin-top:15px">
                    <label class="control-label col-sm-1"
                           for="txt_search_dept">部门名称</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="txt_search_dept">
                    </div>
                    <label class="control-label col-sm-1" for="txt_search_status">状态</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="txt_search_status">
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
                                      data-target="#addDict"></span>
        </button>
        <button id="btn_delete" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        </button>
    </div>
    <div class=table-responsive">
        <table id="dicTable" class="table table-striped table-bordered table-hover text-nowrap"></table>
    </div>
    <div class="modal fade in" id="addDict" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true"></button>
                    <h4 class="modal-title" id="myModalLabel">新增系统字典</h4>
                </div>
                <form id='addForm'>
                    <div class="modal-body">
                        <div class="form-group">
                            <input type="text" class="form-control" name="dicType"
                                   id="dicType" placeholder="表名">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="dicName"
                                   id="dicName" placeholder="字段名">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="dicRef"
                                   id="dicRef" placeholder="存储数值">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="dicValue"
                                   id="dicValue" placeholder="显示数值">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="submit" id="btn_add" class="btn btn-primary">提交</button>
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</div>
</body>
</html>
