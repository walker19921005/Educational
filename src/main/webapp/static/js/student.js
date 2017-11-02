$(function () {
    initTable();
    $("#btn_delete").bind("click", delPermission);
    $("#btn_add").bind("click", Add);
    settingForm();
});

function initTable() {
    //先销毁表格
    $('#stuTable').bootstrapTable('destroy');
    //初始化表格,动态从服务器加载数据
    $("#stuTable").bootstrapTable({
        method: "post",  //使用get请求到服务器获取数据
        contentType: "application/x-www-form-urlencoded",
        url: "student/list", //获取数据的Servlet地址
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: true,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: false,                     //是否启用排序
        silentSort: false,
        paginationPreText: "上一页",
        paginationNextText: "下一页",
        // sortOrder: "asc",                   //排序方式
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 15,                       //每页的记录行数（*）
        pageList: [10, 20, 30, 50],        //可供选择的每页的行数（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: false,
        showColumns: true,                  //是否显示所有的列
        showRefresh: false,                  //是否显示刷新按钮
        showPaginationSwitch: true,
        // showFooter:true,
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "stuId",                     //每一行的唯一标识，一般为主键列
        showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                   //是否显示父子表
        checkboxHeader: false,
        columns: [{
            checkbox: true
        }, {
            field: '',
            title: 'No.',
            width: '20px',
            formatter: function (value, row, index) {
                return index + 1;
            }
        }, {
            field: 'stuId',
            visible: false
        }, {
            field: 'stuName',
            title: '姓名'
        }, {
            field: 'userid',
            editable: {
                type: 'select',
                source: function () {
                    var result = [];
                    $.ajax({
                        url: 'user/deptid',
                        async: false,
                        type: "post",
                        success: function (data, status) {
                            $.each(data, function (key, value) {
                                result.push({value: value.id, text: value.text});
                            });
                        }
                    });
                    return result;
                },
                title: '账号'
            },
            title: '账号'
        }, {
            field: 'sex',
            title: '性别'
        }, {
            field: 'stuIphone',
            title: '联系电话'
        }, {
            field: 'classid',
            editable: {
                type: 'select',
                source: function () {
                    var result = [];
                    $.ajax({
                        // url: 'classes/classes',
                        async: false,
                        type: "post",
                        success: function (data, status) {
                            $.each(data, function (key, value) {
                                result.push({value: value.id, text: value.text});
                            });
                        }
                    });
                    return result;
                },
                title: '班级'
            },
            title: '班级'
        }, {
            field: 'deptid',
            editable: {
                type: 'select',
                source: function () {
                    var result = [];
                    $.ajax({
                        url: 'dept/dept',
                        async: false,
                        type: "post",
                        success: function (data, status) {
                            $.each(data, function (key, value) {
                                result.push({value: value.id, text: value.text});
                            });
                        }
                    });
                    return result;
                },
                title: '部门',
                validate: function (v) {
                    if (!v) return '部门不能为空';
                }
            },
            title: '部门'
        }, {
            field: 'delFlag',
            title: '状态'
        }, {
            field: 'roleId',
            title: '系统角色',
            editable: {
                type: 'select2',
                title: '系统角色',
                pk: 1,
                source: function () {
                    var result = [];
                    $.ajax({
                        url: '/role/role',
                        async: false,
                        type: "post",
                        success: function (data, status) {
                            $.each(data, function (key, value) {
                                result.push({value: value.id, text: value.text});
                            });
                        }
                    });
                    return result;
                },
                validate: function (v) {
                    if (!v) return '角色不能为空';
                },
                select2: {
                    allowClear: true,
                    multiple: true,
                    width: '200px'
                }
            }
        }/*, {
            title: '操作',
            formatter: function (value, row) {
                var id = row.userId;
                return '<button type="button" class="btn btn-default" id="roleTree"><span class="glyphicon glyphicon-edit" aria-hidden="true" ' +
                    'data-toggle="modal" data-target="#queryRole" onclick="setCheck(' + id + ')"></span></button> ' +
                    '<button type="button" class="btn btn-default" id="roleTree"><span class="glyphicon glyphicon-delete" aria-hidden="true" ' +
                    'data-toggle="modal" data-target="#queryRole" onclick="setCheck(' + id + ')"></span></button> '
            }
        }*/],
        responseHandler: function (res) {
            return {
                "total": res.total,//总页数
                "size": res.size,
                "rows": res.records   //数据
            };
        },
        onEditableSave: function (field, row, oldValue, $el) {
            $('#stuTable').bootstrapTable('resetView');
            $.ajax({
                type: "post",
                // url: "/user/update",
                async: false,
                contentType: "application/json",
                data: JSON.stringify(row),
                dataType: 'JSON',
                success: function (data) {
                    if (data > 0) {
                        alert("修改成功");
                    }
                },
                error: function () {
                    alert("Error");
                },
                complete: function () {
                    // $('#stuTable').bootstrapTable('refresh', {url: "/user/list"});
                }
            });
        },
        //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
        //设置为limit可以获取limit, offset, search, sort, order
        queryParamsType: "undefined",
        queryParams: function queryParams(params) {   //设置查询参数
            var param = {
                pageNumber: params.pageNumber,
                pageSize: params.pageSize
            };
            return param;
        }
    });
}

function delPermission() {
    var rows = $("#stuTable").bootstrapTable("getSelections");
    var ids = "";
    if (rows.length > 0) {
        for (var i = 0; i < rows.length; i++) {
            ids += rows[i].userid + ',';
        }
    } else {
        alert("请先选择要删除的记录!");
        return;
    }
    ids = ids.substring(0, ids.length - 1);
    //询问框
    layer.confirm('确定删除吗？', {
        btn: ['确定', '取消'] //按钮
    }, function () {
        $.ajax({
            type: "POST",
            url: "/student/delete",
            data: {"ids": ids},
            success: function (data) {
                if (data > 0) {
                    alert("成功删除" + data + "条信息");
                    $('#stuTable').bootstrapTable('refresh', {url: "/student/list"});
                }
                layer.closeAll();
            }
        });
    }, function () {
        return;
    });
}

function Add() {
    var bootstrapValidator = $("#addForm").data('bootstrapValidator');
    bootstrapValidator.validate();
    $("#rid").text($("#select2_role").select2('val'));
    if (bootstrapValidator.isValid()) {
        $.ajax({
            type: "POST",
            url: "/student/add.do",
            dataType: "json",
            data: {
                userName: $("#userName").val(),
                userSex: $("#userSex input:radio:checked").val(),
                userDesc: $("#userDesc").val(),
                udeptId: $("#select2_dept option:selected").val(),
                userAddress: $("#userAddress").val(),
                creattime: $("#creattime").val(),
                role: $("#rid").text()
            },
            success: function (data) {
                if (data) {
                    $('#empTable').bootstrapTable('refresh', {url: "/emp/list.do"});
                }
                $("#addEmp").modal('hide');
            },
            error: function () {
                alert("error");
            }
        });
    }
}

function settingForm() {
    $("#select2_user").select2({
        ajax: {
            url: "user/deptid",//请求的API地址
            dataType: 'json',//数据类型
            processResults: function (data) {
                return {
                    results: data
                };
            }//返回的结果
        }
    });//启动select2

    $("#select2_dept").select2({
        ajax: {
            url: "dept/dept",//请求的API地址
            dataType: 'json',//数据类型
            /*data: function (params) {
                return {
                    name: params.term//此处是最终传递给API的参数
                }
            },*/
            processResults: function (data) {
                return {
                    results: data
                };
            }//返回的结果
        }
    });//启动select2

    $("#select2_class").select2({
        ajax: {
            // url: "dept/dept",//请求的API地址
            dataType: 'json',//数据类型
            processResults: function (data) {
                return {
                    results: data
                };
            }//返回的结果
        }
    });//启动select2

    $("#select2_role").select2({
        tags: true,
        ajax: {
            url: "role/role",//请求的API地址
            dataType: 'json',//数据类型
            processResults: function (data) {
                var parsed = data;
                var arr = [];
                for (var x in parsed) {
                    arr.push(parsed[x]); //这个应该是个json对象
                }
                return {
                    results: arr
                };
            }
        }
    }).on("select2:select", function (e) {
        e.params.data.disabled = true //让此元素之后不能被再选
    });//启动select2

    $("#addForm").bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        live: 'enabled',
        fields: {
            userName: {
                enabled: true,
                validators: {
                    notEmpty: {
                        message: '姓名不能为空'
                    }
                }
            },
            userSex: {
                validators: {
                    notEmpty: {
                        message: '性别不能为空'
                    }
                }
            },
            deptid: {
                validators: {
                    notEmpty: {
                        message: '部门不能为空'
                    }
                }
            },
            roleid: {
                validators: {
                    notEmpty: {
                        message: '角色不能为空'
                    }
                }
            },
            creattime: {
                validators: {
                    notEmpty: {
                        message: '入学时间不能为空'
                    }
                }
            }
        }
    });
}