$(document).ready(function(){
    $(".login-btn").click(function(){
    	checkLogin();
	});
}); 
function checkLogin(){
	var accountInput = $("#accountInput").val().trim();
	var pwdInput = $("#pwdInput").val().trim();
	
	if(accountInput.length == 0){
		alert("请输入登录名");
	}else if(pwdInput.length == 0){
        alert("请输入密码");
	}else{
		var user = new Object();
		user.account = accountInput;
		user.pwd = pwdInput;
    	
		//参数传递到后台进行查询
		doLogin(user);
	}
		

}
//参数传递到后台进行查询
function doLogin(userObj){
	//同步访问
	var result = "";
	$.ajax({
		url:'/login/checkLogin',
	    type:'POST',
	    async: false,
	    dataType:'json',
	    data:userObj,
	    success:function(msg){
	    	result = msg;
	    },
	    error:function(msg){
	    	alert(msg);
	    }
	});

	
	if(result.code == "-1"){
	  	alert("登录名或密码错误");
	}else{ 
		//跳转到主页	
		var userId = result.userId;
		window.location.href = "/content/load/wxcms$content/";
	}
}

String.prototype.trim=function(){   
    return this.replace(/(^\s*)|(\s*$)/g, "");    
}