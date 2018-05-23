$(document).ready(function() {
	$('#bid').textbox({
		label:'书籍id',
		iconCls:'icon-book',
		width: 300,
		prompt: 'please input bid...',
		required: true
	});
	$('#bookName').textbox({
		label:'书名：',
		iconCls:'icon-book',
		width:300,
		prompt:'please input bookName...',
		required: true
	});
	$('#amount').textbox({
		label:'数量：',
		iconCls:'icon-book',
		width: 300,
		prompt: 'please input amount...',
		required: true
	});
	$('#status').combobox({
		label:'状态：',
		iconCls:'icon-book',
		width:300,
		prompt:'please input status...',
		required: true
	});
	$('#thumbnail').textbox({
		label:'图片：',
		iconCls:'icon-book',
		width:300,
		prompt:'please input thumbnail...',
		required: true
	});
});

/**
 * 更新用户表单提交
 * 
 * @returns
 */
function updateBook() {
	$('#bookForm').form('submit', {
		onSubmit : function() { // 提交动作发生时，回调的函数
			var isValid = $(this).form('validate');
			if (!isValid) {
				$.messager.progress('close'); // 验证失败，隐藏进度条
				return false;
			}
			// 利用ajax方式提交表单
			ajaxUpdateSubmit();
			return false;
		}
	});
}

/**
 * ajax方式提交表单
 * 
 * @returns
 */
function ajaxUpdateSubmit() {
	// 将表单参数转换成表单的js对象
	// 将表单的js对象转换成json字符串
	$.ajax({
		url : 'BookServlet',
		method : 'post',
		data : {
			tp : 'update',
			formData : JSON.stringify(formDataToJson())
		},
		dataType : 'json',
		success : function(data) {
			$.messager.alert('提示', data.msg);
		}
	})
}

/**
 * 将表单参数数组转成json对象
 * 
 * @returns
 */
function formDataToJson() {
	var formArray = $('#bookForm').serializeArray();
	var formJsonObject = {};
	for (var index = 0; index < formArray.length; index++) {
		var temp = formArray[index];
		formJsonObject[temp.name] = temp.value;
	}
	return formJsonObject;
}