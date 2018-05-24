/**
 * 注册按钮点击事件绑定
 */
function regist() {
	var loginname = document.getElementsByTagName('input')[0].value;
	if(loginname == null || loginname == '' || loginname == undefined){
		alert('请输入用户名...');
		return false;
	}
	
	var password = document.getElementsByTagName('input')[1].value;
	if(password == null || password == '' || password == undefined){
		alert('请输入密码...');
		return false;
	}
	var repass = document.getElementsByTagName('input')[2].value;
	if(repass!=password){
		alert('两次输入密码不一致...');
		return false;
	}
		
	
	var realname = document.getElementsByTagName('input')[3].value;
	if(realname == null || realname == '' || realname == undefined){
		alert('请输入真是姓名...');
		return false;
	}
}