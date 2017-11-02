<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/common/table.jsp"/>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/static/js/plugins/bootstrap-table/toolbar/bootstrap-table-toolbar.min.js"></script>
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
                                      data-target="#addStudent"></span>
        </button>
        <button id="btn_delete" type="button" class="btn btn-default">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
        </button>
    </div>
    <div class=table-responsive">
        <table id="stuTable" class="table table-striped table-bordered table-hover text-nowrap"></table>
    </div>
    <div class="modal fade in" id="addStudent" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true"></button>
                    <h4 class="modal-title" id="myModalLabel">新增学生信息</h4>
                </div>
                <form id='addForm'>
                    <div class="modal-body">
                        <div class="form-group">
                            <select id="select2_user" class="select2-results__group form-control"
                                    style="width: 100%"
                                    name="userid">
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="stuName"
                                   id="stuName" placeholder="姓名">
                        </div>
                        <div class="form-group">
                            <div class="radio" id="sex">
                                <label><input type="radio" name="userSex" value="男">男</label>
                                <label><input type="radio" name="userSex" value="女">女</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="stuIphone"
                                   id="stuIphone" placeholder="手机号">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="stuPhone"
                                   id="stuPhone" placeholder="固定电话">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="stuAddress"
                                   id="stuAddress" placeholder="联系地址">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="linkman"
                                   id="linkman" placeholder="联系人姓名">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" name="linkmanIphone"
                                   id="linkmanIphone" placeholder="联系人电话">
                        </div>
                        <div class="form-group">
                            <input type="date" class="form-control" name="stuBirthday"
                                   id="stuBirthday" placeholder="出生日期">
                        </div>
                        <div class="form-group">
                            <input type="date" class="form-control" name="enroldate"
                                   id="enroldate" placeholder="入学日期">
                        </div>
                        <div class="form-group">
                            <input type="date" class="form-control" name="graduatedate"
                                   id="graduatedate" placeholder="毕业日期">
                        </div>
                        <div class="form-group">
                            <select id="select2_dept" class="select2-results__group form-control"
                                    style="width: 100%"
                                    name="deptid">
                            </select>
                        </div>
                        <div class="form-group">
                            <select id="select2_class" class="select2-results__group form-control"
                                    style="width: 100%"
                                    name="classid">
                            </select>
                        </div>
                        <div class="form-group">
                            <select id="select2_role" class="select2-results__groups form-control"
                                    multiple="multiple" style="width: 100%" name="roleid">
                            </select>
                            <span id="rid" style="display: none"></span>
                        </div>
                        <div class="form-group">
                            <input type="file" class=" form-control" name="icon"
                                   id="icon" placeholder="个人照片">
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
