<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>学生信息页面</title>
<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/static/js/jquery/jquery-1.11.1.min.js"></script>
    
	<!--   Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap-table.min.js"></script>
	<!-- 汉化表格   -->
	<script src="${pageContext.request.contextPath}/static/bootstrap/js/bootstrap-table-zh-CN.min.js"></script>
	<!--  时间控件   -->
	<script src="${pageContext.request.contextPath}/js/laydate/laydate.js"></script>
	<!-- Bootstrap Core CSS -->
    <link href="../css/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 公用css -->
    <link href="../css/sb-admin-2.css" rel="stylesheet">
    <!-- 表格样式 -->
    <link rel="stylesheet" href="../css/bower_components/bootstrap/js/bootstrap-table.min.css">
	<script type="text/javascript">
		var path = "${pageContext.request.contextPath}";
	</script>
	<script type="text/javascript">
	    //修改
		function edits() {
			var rows = $("#yes").bootstrapTable('getSelections');
			if(rows==""){
				alert("请选中需要修改的数据！");
			}else{
				var numid=rows[0].id;
				alert(numid);
				$('#myModalUpd').modal('show');
		    	$.ajax({
		    		url:path+"/selstu.action?id="+numid,
		    		dataType:"json",
		    		type:"post",
		    		success:function(data){
		    			$("#uid").val(data.id);
		    			$("#stuname").val(data.stuname);
		    			$("#age").val(data.age);
		    			$("#stupass").val(data.stupass);
		    		},
		    		error:function(){
		    			alert("你好");
		    		}
		    	});
			}
			
		}
		function updsave(){
			var obj = $("#updModal").serialize();
			var submitData=decodeURIComponent(obj,true);
			//alert(submitData);
			$.ajax({
				type:'post',
				url:path+'/updstu.action',
				dataType:'json',
				
			    data:submitData,
			    success:function(result){
			        if(result){
			        	$("#myModalUpd").modal('hide');
			        	window.location="${pageContext.request.contextPath}/page/stulist.jsp";
			        }
			    },
			    error:function(){
			    	alert('error');
			    }
			});
		}
		//保存
		function append(){
			$("#myModal").modal('show');
		}
		function save(){
			var obj = $("#addModal").serialize();
			var submitData=decodeURIComponent(obj,true);
			//alert(submitData);
			$.ajax({
				type:'post',
				url:path+'/addstu.action',
				dataType:'json',
				
			    data:submitData,
			    success:function(result){
			        if(result){
			        	$("#myModal").modal('hide');
			        	window.location="${pageContext.request.contextPath}/page/stulist.jsp";
			        }
			    },
			    error:function(){
			    	alert('error');
			    }
			});
		}
		//删除
		function del(){
			var rows = $("#yes").bootstrapTable('getSelections');
			if(rows==""){
				alert("请选中需要修改的数据！");
			}else{
				var numid=rows[0].id;
				alert(numid);
				$('#myModalDel').modal('show');
		    	$.ajax({
		    		url:path+"/selstu.action?id="+numid,
		    		dataType:"json",
		    		type:"post",
		    		success:function(data){
		    			$("#did").val(data.id);
		    		},
		    		error:function(){
		    			alert("你好");
		    		}
		    	});
			}
			
		}
		function delsave(){
			var obj = $("#delModal").serialize();
			var submitData=decodeURIComponent(obj,true);
			//alert(submitData);
			$.ajax({
				type:'post',
				url:path+'/delstu.action',
				dataType:'json',
				
			    data:submitData,
			    success:function(result){
			        if(result){
			        	$("#myModalDel").modal('hide');
			        	window.location="${pageContext.request.contextPath}/page/stulist.jsp";
			        }
			    },
			    error:function(){
			    	alert('error');
			    }
			});
		}
	</script>
	<script type="text/javascript">
	 
		$(function(){
			var hig = $(window).height();
			$('#yes').bootstrapTable({
				method : 'GET',
				url:path + "/studlist.action",
				cache : false,
				height : hig - 150,//表格高度
				striped : true,
				pagination : true, //在表格底部显示分页工具栏
				pageSize : 5, //默认每页条数
				pageNumber : 1, //默认分页
				pageList : [ 10, 20, 50, 100, 200, 500 ],//分页数
				showColumns : true, //显示隐藏列
				showRefresh : true, //显示刷新按钮
				showExport : true,
				singleselect : true,
				search : false,//显示搜素表单
				silent : true, //刷新事件必须设置
				sidePagination : "server", //表示服务端请求  
				clickToSelect : true, //复选框只能选择一条记录
				columns : [ {
					checkbox : true
				}, {
					field : "id",
					title : "编号",
					align : "center",
					valign : "middle",
					sortable : "true"
				}, {
					field : "stuname",
					title : "姓名",
					align : "center",
					valign : "middle",
					sortable : "true"
				}, {
					field : "age",
					title : "年龄",
					align : "center",
					valign : "middle",
					sortable : "true"
				}, {
					field : "stupass",
					title : "密码",
					align : "center",
					valign : "middle",
					sortable : "true"
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
		}); 
		//屏幕尺寸改变刷新
		$(window).resize(function() {
			$('#yes').bootstrapTable('resetView');
			$('#no').bootstrapTable('resetView');
		});
		 
	</script>
</head>
<body>
<!-- 标题部分 -->
	<div class="bootom10">
		<div class="col-lg-12 manage-head">
			<h6 class="panel-title">tab切换与列表</h6>
		</div>
		<!-- /.col-lg-12 -->
	</div>
	<!-- tab切换 -->
	<ul id="myTab" class="nav nav-tabs">
		<li class="active"><a href="#home" data-toggle="tab">带表单搜索</a></li>
		<li><a href="#ios" data-toggle="tab">无表单搜索</a></li>

	</ul>

	<div id="myTabContent" class="tab-content">

		<div class="tab-pane fade in active" id="home">
			<!-- 列表引用开始 -->
			<div class="panel-table">
				<div class="heading">


					<button id="build" type="button" class="btn  btn-success"
						data-toggle="modal" data-target="" onclick="append()">
						<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加
					</button>


					<button id="btnEdit" type="button" class="btn   btn-warning"
						onclick="edits()">
						<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>修改
					</button>


					<button id="btnDel" type="button" class="btn  btn-danger"
						data-toggle="modal" data-target="#DeleteForm" onclick="del()">
						<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>删除
					</button>


				</div>
				<div class="manage-time">
					开始时间:<input class="form_datetime form-control right10" type="text"
						id="form_datetime" value="2016-03-07" size="16"> 姓名:<input
						class=" form-control right10" type="text" size="16">
					<button type="button" class="btn btn-primary">查询</button>
				</div>

				<div class="dataTable_wrapper">
					<table class="table table-striped table-bordered table-hover"
						id="yes">

					</table>
				</div>
			</div>
			<!-- 列表引用结束 -->
		</div>
		<div class="tab-pane fade" id="ios">
			<!-- 列表引用开始 -->
			<div class="panel-table">
				<div class="dataTable_wrapper">
					<table class="table table-striped table-bordered table-hover"
						id="no">
                       
					</table>
				</div>
			</div>
			<!-- 列表引用结束 -->
		</div>

	</div>
<!-- 添加弹出层内容 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">用户添加</h4>
				</div>
				<div class="modal-body">
					<form id="addModal"  >
                        <div class="form-table">
                         
                            <div class="control-group">
                                <label>姓名：</label>
                                <div class="form-div"><input class=" form-control" type="text" name="stuname" placeholder="请输入姓名"></div>
                            </div>
                         
                            <div class="control-group">
                                <label>年龄：</label>
                                <div class="form-div"><input class=" form-control" type="text" name="age" placeholder="请输入年龄"></div>
                            </div>
                             <div class="control-group">
                                <label>密码：</label>
                                <div class="form-div"><input class=" form-control" type="password" name="stupass" placeholder="请输入密码"></div>
                            </div>
                  		</div>
                    </form> 
                 </div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="save()">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 修改弹出层内容 -->
	<div class="modal fade" id="myModalUpd" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">用户修改</h4>
				</div>
				<div class="modal-body">
					<form id="updModal"  >
                        <div class="form-table">
                        <input class=" form-control" type="hidden" name="id" id="uid">
                            <div class="control-group">
                                <label>姓名：</label>
                                <div class="form-div"><input class=" form-control" type="text" name="stuname" id="stuname" placeholder="请输入姓名"></div>
                            </div>
                         
                            <div class="control-group">
                                <label>年龄：</label>
                                <div class="form-div"><input class=" form-control" type="text" name="age" id="age" placeholder="请输入年龄"></div>
                            </div>
                             <div class="control-group">
                                <label>密码：</label>
                                <div class="form-div"><input class=" form-control" type="password" name="stupass" id="stupass" placeholder="请输入密码"></div>
                            </div>
                  		</div>
                    </form> 
                 </div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="updsave()">保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 删除弹出层内容 -->
	<div class="modal fade" id="myModalDel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">用户删除</h4>
				</div>
				<div class="modal-body">
					<form id="delModal"  >
                        <div class="form-table">
                        <input class=" form-control" type="hidden" name="id" id="did">
                        <span>是否删除该学生信息？</span>
                  		</div>
                    </form> 
                 </div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="delsave()">删除</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>