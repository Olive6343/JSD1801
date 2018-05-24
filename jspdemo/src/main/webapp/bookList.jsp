<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>图书列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="img/bitbug_favicon.ico">
<link rel="stylesheet" type="text/css"
	href="css/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="css/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/themes/color.css">
<link rel="stylesheet" type="text/css" href="css/demo/demo.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/datagrid-filter.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script>
	$(document).ready(function() {
		$('#dg').datagrid({
			url : 'GetBookListService.jsp',
			method : 'get',
			singleSelect : false, // 多行可选，如果是true，单行可选
			fit : true,
			fitColumns : true,
			striped : true,
			rownumbers : true, // 显示行号
			pagination : true, // 打开分页栏
			loadFilter : pageFilter,// 在数据加载到控件之前，过滤数据的处理
			columns : [ [ {
				field : 'ck',
				checkbox : true
			// 显示多选框
			}, {
				field : 'bid',
				title : '书籍ID',
				width : 80
			}, {
				field : 'bookName',
				title : '书籍名称',
				width : 100
			}, {
				field : 'amount',
				title : '书籍数量',
				width : 80,
				align : 'right'
			} ] ],
			toolbar : [ {
				text : '保存',
				iconCls : 'icon-save',
				handler : function() {
					getSelectedRow();
				}
			}, '-', {
				text : '批量删除',
				iconCls : 'icon-remove',
				handler : function() {
					var rows = $('#dg').datagrid('getSelections');
					if (rows.length == 0)
						alert('请选中行...');
					else
						alert('批量删除: ' + rows);
				}
			} ],
			footer : '#ft'
		});
	});

	// 假分页： 先获得所有数据，然后分页
	function pageFilter(data) {
		// 获得当前datagrid
		var dg = $(this);
		// 获得当前datagrid的options选项
		var opts = dg.datagrid('options');
		// 获得当前datagrid的分页对象
		var pager = dg.datagrid('getPager');
		console.log(dg,opts);
		console.log(pager);
		
		// 分页对象的onSelectPage事件
		pager.pagination({
			onSelectPage : function(pageNum, pageSize) {
				opts.pageNumber = pageNum;// 新的页码
				opts.pageSize = pageSize;// 新的每页记录数量
				console.log(pageNum + ',' + pageSize);
				// 刷新分页栏信息
				pager.pagination('refresh', {
					pageNumber : pageNum,
					pageSize : pageSize
				});
				// 重新加载data记录
				dg.datagrid('loadData', data);
			}
		});
		
		// 将原始记录保存到originalRows中
		if (!data.originalRows) {
			data.originalRows = data.rows;
		}
		console.log(data.originalRows);
		
		// 分页的起始位置
		var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
		
		// 结束分页位置
		var end = start + parseInt(opts.pageSize);
		
		// 将原始记录从start->end部分的数据提取出来，放到rows中并返回data，这样就完成了分页
		data.rows = data.originalRows.slice(start, end);
		return data;
	}
</script>
<body style="padding: 20px;">
	<div class="easyui-layout"
		style="width: 100%; height: 600px; border: none;">
		<div data-options="region:'center',title:'图书列表'">
			<table id="dg">
			</table>
			<div id="ft">
				<a href="#" class="easyui-linkbutton" iconCls="icon-save"
					plain="true" data-options="text:'保存'" onclick="getSelectedRow();"></a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove"
					plain="true" data-options="text:'批量删除'" onclick="batchDelete();"></a>
				<a href="#" class="easyui-linkbutton" iconCls="icon-edit"
					plain="true" data-options="text:'编辑'"></a>
			</div>
		</div>
	</div>
</body>
</html>