$(function () {
    initTable();
    $("#btn_delete").bind("click", delPermission);
    $("#btn_add").bind("click", Add);
    settingForm();
});

function initTable() {
    //先销毁表格
    $('#dicTable').bootstrapTable('destroy');
    //初始化表格,动态从服务器加载数据
    $("#dicTable").bootstrapTable({
        method: "post",  //使用get请求到服务器获取数据
        contentType: "application/x-www-form-urlencoded",
        url: "dict/list", //获取数据的Servlet地址
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
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        // height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "dicId",                     //每一行的唯一标识，一般为主键列
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
            field: 'dicId',
            visible: false
        }, {
            field: 'dicType',
            editable: {
                type: 'text',
                title: '表名',
                validate: function (v) {
                    if (!v) return '表名不能为空';
                }
            },
            title: '表名'
        }, {
            field: 'dicName',
            editable: {
                type: 'text',
                title: '字段名',
                validate: function (v) {
                    if (!v) return '字段名不能为空';
                }
            },
            title: '字段名'
        }, {
            field: 'dicRef',
            editable: {
                type: 'text',
                title: '存储数值',
                validate: function (v) {
                    if (!v) return '存储数值不能为空';
                }
            },
            title: '存储数值'
        }, {
            field: 'dicValue',
            editable: {
                type: 'text',
                title: '显示数值',
                validate: function (v) {
                    if (!v) return '显示数值不能为空';
                }
            },
            title: '显示数值'
        },  {
            field: 'delFlag',
            title: '状态'
        }],
        responseHandler: function (res) {
            return {
                "total": res.total,//总页数
                "size": res.size,
                "rows": res.records   //数据
            };
        },
        onEditableSave: function (field, row, oldValue, $el) {
            $('#dicTable').bootstrapTable('resetView');
            $.ajax({
                type: "post",
                url: "dict/update",
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
                    $('#dicTable').bootstrapTable('refresh', {url: "dict/list"});
                }
            });
        },
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
    var rows = $("#dicTable").bootstrapTable("getSelections");
    var ids = "";
    if (rows.length > 0) {
        for (var i = 0; i < rows.length; i++) {
            ids += rows[i].dicId + ',';
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
            url: "dict/delete",
            data: {"ids": ids},
            success: function (data) {
                if (data) {
                    $('#dicTable').bootstrapTable('refresh', {url: "dict/list"});
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
    if (bootstrapValidator.isValid()) {
        $.ajax({
            type: "POST",
            url: "dict/add",
            dataType: "json",
            data: {
                dicType: $("#dicType").val(),
                dicName: $("#dicName").val(),
                dicRef: $("#dicRef").val(),
                dicValue: $("#dicValue").val()
            },
            success: function (data) {
                if (data) {
                    $('#dicTable').bootstrapTable('refresh', {url: "dict/list"});
                }
                $("#addDict").modal('hide');
            },
            error: function () {
                alert("error");
            }
        });
    }
}

function settingForm() {
    $("#addForm").bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        live: 'enabled',
        fields: {
            dicType: {
                enabled: true,
                validators: {
                    notEmpty: {
                        message: '表名不能为空'
                    }
                }
            },
            dicName: {
                validators: {
                    notEmpty: {
                        message: '字段名不能为空'
                    }
                }
            },
            dicRef: {
                validators: {
                    notEmpty: {
                        message: '存储数值不能为空'
                    }
                }
            },
            dicValue: {
                validators: {
                    notEmpty: {
                        message: '显示数值不能为空'
                    }
                }
            }
        }
    });
}