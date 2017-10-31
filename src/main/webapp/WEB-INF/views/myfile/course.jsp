<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>课程管理</title>
<link href="${pageContext.request.contextPath }/static/css/bootstrap.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/bootstrap.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/plugins/bootstrap-table/bootstrap-table.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/plugins/bootstrap-table/bootstrap-table-zh-CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/plugins/bootstrap-validator/bootstrapValidator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/plugins/bootstrap-validator/zh_CN.js"></script>
<link href="${pageContext.request.contextPath }/static/css/plugins/bootstrap-validator/bootstrapValidator.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/plugins/select2/lib/select2.js"></script>
<link href="${pageContext.request.contextPath }/static/js/plugins/select2/lib/select2.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/plugins/layer-v2.2/layer/layer.js"></script>
<link href="${pageContext.request.contextPath }/static/js/plugins/layer-v2.2/layer/skin/layer.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript">
$(function(){
	$('#test-table').bootstrapTable('destroy')
	$('#test-table').bootstrapTable({
		method : 'GET',
		url: "${pageContext.request.contextPath}/course/getCourseList",
		cache : false,
		striped : true,
		pagination : true, //在表格底部显示分页工具栏
		pageSize : 5, //默认每页条数
		pageNumber : 1, //默认分页
		pageList : [ 10, 20, 50, 100, 200, 500 ],//分页数
		showColumns : true, //显示隐藏列
		showRefresh : true, //显示刷新按钮
		showExport : true,
		toolbar:"#toolbar",
		singleselect : true,
		 clickToSelect: true, // 单击行即可以选中
		search : false,//显示搜素表单
		silent : true, //刷新事件必须设置
		sidePagination : "server", //表示服务端请求  
		clickToSelect : true, //复选框只能选择一条记录
		columns : [  {
			checkbox : true
		},  {
			field : "course_id",
			title : "课程编号",
			class : 'col-md-1',
			align : "center",
			valign : "middle",
			sortable : "true"
		}, {
			field : "course_name",
			title : "课程名称",
			align : "center",
			valign : "middle",
			sortable : "true"
		}, {
			field : "stageid",
			title : "阶段id",
			align : "center",
			valign : "middle",
			sortable : "true"
		}, {
			field : "course_days",
			title : "课时",
			align : "center",
			valign : "middle",
			sortable : "true"
		}, {
			field : "course_desc",
			title : "课程描述",
			align : "center",
			valign : "middle",
			sortable : "true"
		}, {
            field: 'operate',
            title: '操作',
           class : 'col-md-2',
            align: 'center',
            valign: 'middle',
           formatter: operateFormatter,
        }],
		queryParamsType: "undefined",
        queryParams: function queryParams(params) {   //设置查询参数
            var param = {
                pageNumber: params.pageNumber,
                pageSize: params.pageSize,
                // searchText: params.searchText
            };
            return param;
        },
		formatLoadingMessage : function() {
			return "请稍等，正在加载中...";
		},

		formatNoMatches : function() {
			return '无符合条件的记录';
		}
	});
	
	
	$('#myModal').on('show.bs.modal', function (e) {  
		 // alert(e) ;
		}) 
		
}); 

function operateFormatter(value, row, index) {
    return [
        '<button type="button" class=" btn btn-info" onclick="getvalue('+row.course_id+')">修改</button>',
        '&nbsp;&nbsp;&nbsp;<button class=" btn btn-danger" type="button" onclick="delCourse('+row.course_id+')">删除</button>'
        ].join('');
}

//表单验证
$(function () {
	$('#myform').bootstrapValidator({
		message: 'This value is not valid',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
			},

	        fields: {
	        	course_name: {
	                message: '课程名称验证失败',
	                validators: {
	                    notEmpty: {
	                        message: '课程名称不能为空'
	                    }
	                }
	            },
	            course_desc: {
	                validators: {
	                    notEmpty: {
	                        message: '课程描述不能为空'
	                    }
	                }
	            },
	            course_days:{
	            	validators: {
	            		notEmpty: {
	                        message: '课时不能为空'
	                    },
	            		numeric: {
	                        message: '请输入数字'
	                    }
	                }
	            }
	        }
	    });
	$('#myform1').bootstrapValidator({
		message: 'This value is not valid',
		feedbackIcons: {
			valid: 'glyphicon glyphicon-ok',
			invalid: 'glyphicon glyphicon-remove',
			validating: 'glyphicon glyphicon-refresh'
			},

	        fields: {
	        	course_name: {
	                message: '课程名称验证失败',
	                validators: {
	                    notEmpty: {
	                        message: '课程名称不能为空'
	                    }
	                }
	            },
	            course_desc: {
	                validators: {
	                    notEmpty: {
	                        message: '课程描述不能为空'
	                    }
	                }
	            },
	            course_days:{
	            	validators: {
	            		notEmpty: {
	                        message: '课时不能为空'
	                    },
	            		numeric: {
	                        message: '请输入数字'
	                    }
	                }
	            }
	        }
	    });
});

//打开添加课程
function opendlg(){
	$.ajax({
		url:'${pageContext.request.contextPath }/course/getSelList',
		type:'post',
		dataType:"json",
		success:function(data){
			//教师
			$("#teachid").empty();
			$.each(data.tlist,function(i){
			 $("#teachid").append("<option   value='"+this.teachId+"'>"+this.teachName+"</option>"); 
				});
			//阶段
			$("#stageid").empty();
			$.each(data.slist,function(i){
			 $("#stageid").append("<option   value='"+this.stageId+"'>"+this.stageName+"</option>"); 
				});
		}
	});
	$('#mydlg').modal('show');
}
//添加课程
function addCourse(){
	if($('#myform').data('bootstrapValidator').validate().isValid()){
		 $.ajax({
				url:'${pageContext.request.contextPath }/course/addcou.do',
				type:'post',
				//contentType: "application/x-www-form-urlencoded",
				dataType:'json',
				data:$("#myform").serialize(),
				success:function(i){
					if(i>0){
						alert("添加成功！")
					}else{
						alert("添加失败！")
					}
					$("#test-table").bootstrapTable('refresh');
					$('#mydlg').modal('hide');
				},
				error:function(){
					alert("请求失败！")
				}
			}); 
	}else{
		return false;
	}
}

//打开修改框
function getvalue(id){
	$.ajax({
		url:'${pageContext.request.contextPath }/course/getCourseById',
		data:'post',
		dataType:'json',
		data:{course_id:id},
		success:function(data){
			$("#course_name1").val(data.course.course_name);
			$("#course_days1").val(data.course.course_days);
			$("#course_desc1").val(data.course.course_desc);
			$("#course_id1").val(data.course.course_id);
			
			//教师
			$("#teachid1").empty();
			$.each(data.tlist,function(i){
			if(data.tlist!=null&&data.course.teachid==this.teachId){
			 $("#teachid1").append("<option  selected value='"+this.teachId+"'>"+this.teachName+"</option>");
				}else{
			 $("#teachid1").append("<option   value='"+this.teachId+"'>"+this.teachName+"</option>"); 
					}
				});
			//阶段
			$("#stageid1").empty();
			$.each(data.slist,function(i){
			if(data.slist!=null&&data.course.stageid==this.stageId){
			 $("#stageid1").append("<option  selected value='"+this.stageId+"'>"+this.stageName+"</option>");
				}else{
			 $("#stageid1").append("<option   value='"+this.stageId+"'>"+this.stageName+"</option>"); 
					}
				});
			$('#mydlg1').modal('show');
		},
		error:function(){
			alert("请求失败！");
		}
	})
}
//提交修改
function upCourse(){
	if($('#myform1').data('bootstrapValidator').validate().isValid()){
		 $.ajax({
				url:'${pageContext.request.contextPath }/course/updateCourse',
				type:'post',
				dataType:'json',
				data:$("#myform1").serialize(),
				success:function(i){
					if(i>0){
						alert("修改成功！")
					}else{
						alert("修改失败！")
					}
					$("#test-table").bootstrapTable('refresh');
					$('#mydlg1').modal('hide');
				},
				error:function(){
					alert("请求失败！")
				}
			}); 
	}else{
		return false;
	}
}
//单个删除
function delCourse(id){
	if(confirm("您确定要删除这条数据吗")){
		$.ajax({
			url:'${pageContext.request.contextPath }/course/delCourse',
			type:'post',
			dataType:"json",
			data:{
				id:id
			},
			success:function(data){
				if(data>0){
					alert("删除成功！");
				}else{
					alert("删除失败！");
				}
				$("#test-table").bootstrapTable('refresh');
			},
			error:function(){
				alert("请求失败！")
			}
		});
	}else{
		return false;
	}
}
//批量删除
function delAll(){
	var ids = [];
	var s=$("#test-table").bootstrapTable('getSelections');
	if(s.length==0){
		alert("请选中要删除的数据！");
	}else{
		 $.each(s, function(index, item){//索引  循环的对象
			 ids.push(item.course_id);
		}); 
		 
		  $.ajax({
			url:'${pageContext.request.contextPath }/course/delAll',
			type:"post",
			traditional:true,//传数组参数要加
			dataType:'json',
			data:{ids:ids},
			success:function(data){
				if(data){
					alert("删除成功！");
				}else{
					alert("删除失败！")
				}
				$("#test-table").bootstrapTable('refresh');
			},
			error:function(){
				alert("请求失败！")
			}
		 }); 
	}
	 
}
</script>
<body>
<div class="container">
<table id="test-table" class="table table-hover table-striped table-condensed table-bordered"></table>
</div>

<div id="toolbar" class="btn-toolbar">
                            <button type="button" class="btn btn-default" onclick="opendlg()">
                                <span class="glyphicon glyphicon-plus" aria-hidden="true" data-toggle="modal">添加</span>
                            </button>
                            <button onclick="delAll()" type="button" class="btn btn-default">
                                <span class="glyphicon glyphicon-remove" aria-hidden="true">删除</span>
                            </button>
                        </div>
                        
<!-- 模态框（Modal） -->
<!-- 添加 -->
<div id="mydlg" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   
    <div class="modal-dialog">
        <div class="modal-content">
        
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">添加课程</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="myform"  method="post">
			<div class="form-group">
			<label class="col-md-2 control-label">课程名称：</label>
			<div class="col-md-3 ">
			<input type="text" id="course_name" name="course_name" class="form-control form-control-static" placeholder="必填">
			</div>
			</div>
			
			<!-- 下拉选择框 -->
			<div class="form-group">
			<label class="col-md-2 control-label">任课老师：</label>
			<div class="col-md-3">
			<select id="teachid" name="teachid" class="form-control"></select>
			</div>
			</div>
 
			<div class="form-group">
   			 <label for="inputPassword" class="col-md-2 control-label">课程阶段</label>
   			 <div class="col-md-3">
				<select id="stageid" name="stageid" class="form-control"></select>
			</div>
  			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">课时：</label>
			<div class="col-md-3 ">
			<input type="text" id="course_days" name="course_days" class="form-control form-control-static" placeholder="请输入数字">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">课程描述：</label>
			<div class="col-md-3">
			<textarea rows="3" id="course_desc" name="course_desc" cols="36"></textarea>
			</div>
			</div>
            <div class="modal-footer col-md-6">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
               <button type="button" onclick="addCourse()" class="btn btn-primary">提交</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>                    
      
 <!-- 模态框（Modal） -->
<!-- 修改 -->
<div id="mydlg1" class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
   
    <div class="modal-dialog">
        <div class="modal-content">
        
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">修改课程</h4>
            </div>
            <div class="container">
			<form class="form-horizontal" id="myform1"  method="post">
			<div class="form-group">
			<label class="col-md-2 control-label">课程名称：</label>
			<div class="col-md-3 ">
			<input type="hidden" id="course_id1" name="course_id">
			<input type="text" id="course_name1" name="course_name" class="form-control form-control-static" placeholder="必填">
			</div>
			</div>
			
			<!-- 下拉选择框 -->
			<div class="form-group">
			<label class="col-md-2 control-label">任课老师：</label>
			<div class="col-md-3">
			<select id="teachid1" name="teachid" class="form-control"></select>
			</div>
			</div>
 
			<div class="form-group">
   			 <label for="inputPassword" class="col-md-2 control-label">课程阶段</label>
   			 <div class="col-md-3">
			<select id="stageid1" name="stageid" class="form-control"></select>
			</div>
  			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">课时：</label>
			<div class="col-md-3 ">
			<input type="text" id="course_days1" name="course_days" class="form-control form-control-static" placeholder="请输入数字">
			</div>
			</div>
			
			<div class="form-group">
			<label class="col-md-2 control-label">课程描述：</label>
			<div class="col-md-3">
			<textarea rows="3" id="course_desc1" name="course_desc" cols="36"></textarea>
			</div>
			</div>
            <div class="modal-footer col-md-6">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
               <button type="button" onclick="upCourse()" class="btn btn-primary">提交</button>
            </div>
            </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>                  
</body>
</html>