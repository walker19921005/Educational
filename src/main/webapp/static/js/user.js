$(function () {
    initTable();
});

function initTable() {
    //先销毁表格
    $('#userTable').bootstrapTable('destroy');
    //初始化表格,动态从服务器加载数据
    $("#userTable").bootstrapTable({
        method: "post",  //使用get请求到服务器获取数据
        contentType: "application/x-www-form-urlencoded",
        url: "/user/list", //获取数据的Servlet地址
        toolbar: '#toolbar',                //工具按钮用哪个容器
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,                   //是否显示分页（*）
        sortable: true,                     //是否启用排序
        silentSort: true,
        paginationPreText: "上一页",
        paginationNextText: "下一页",
        sortOrder: "asc",                   //排序方式
        sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        pageNumber: 1,                       //初始化加载第一页，默认第一页
        pageSize: 15,                       //每页的记录行数（*）
        pageList: [10, 20, 30, 50],        //可供选择的每页的行数（*）
        search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: false,
        showColumns: true,                  //是否显示所有的列
        showRefresh: true,                  //是否显示刷新按钮
        showPaginationSwitch: true,
        // showFooter:true,
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "userid",                     //每一行的唯一标识，一般为主键列
        showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                   //是否显示父子表
        checkboxHeader: true,
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
            field: 'userid',
            visible: false
        }, {
            field: 'userName',
            editable: {
                type: 'text',
                title: '姓名',
                validate: function (v) {
                    if (!v) return '姓名不能为空';
                }
            },
            title: '姓名'
        }, {
            field: 'userSex',
            editable: {
                type: 'select',
                source: [{value: "男", text: "男"}, {value: "女", text: "女"}],
                title: '性别',
                validate: function (v) {
                    if (!v) return '性别不能为空';
                }
            },
            title: '性别'
        }, {
            field: 'userDesc',
            editable: true,
            title: '用户描述'
        }, {
            field: 'udeptId',
            editable: {
                type: 'select',
                source: function () {
                    var result = [];
                    $.ajax({
                        url: '/dept/dept.do',
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
                title: '部门名称',
                validate: function (v) {
                    if (!v) return '部门名称不能为空';
                }
            },
            title: '部门名称'
        }, {
            field: 'userAddress',
            editable: true,
            title: '地址'
        }, {
            field: 'creattime',
            title: '入职时间',
            editable: {
                type: 'combodate',
                title: '入职时间',
                validate: function (v) {
                    if (!v) return '入职时间不能为空';
                }
            }
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
                        url: '/role/role.do',
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
                    if (!v) return '系统角色不能为空';
                },
                select2: {
                    allowClear: true,
                    multiple: true,
                    width: '200px'
                }
            }
        }, {
            title: '权限',
            formatter: function (value, row) {
                var id = row.userid;
                return '<button type="button" class="btn btn-default" id="roleTree"><span class="glyphicon glyphicon-edit" aria-hidden="true" ' +
                    'data-toggle="modal" data-target="#queryRole" onclick="setCheck('+id+')"></span></button>'
            }
        }],
        responseHandler: function (res) {
            return {
                "total": res.total,//总页数
                "size": res.size,
                "rows": res.records   //数据
            };
        },
        onEditableSave: function (field, row, oldValue, $el) {
            $('#empTable').bootstrapTable('resetView');
            $.ajax({
                type: "post",
                url: "/user/update",
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
                    $('#empTable').bootstrapTable('refresh', {url: "/user/list"});
                }

            });
        },
        //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
        //设置为limit可以获取limit, offset, search, sort, order
        queryParamsType: "undefined",
        queryParams: function queryParams(params) {   //设置查询参数
            var param = {
                pageNumber: params.pageNumber,
                pageSize: params.pageSize,
            };
            return param;
        }
    });
}