<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
	<%@ include file="../../common/sysHeader.jsp"%>
	<!-- CSS -->
	<link href="<%=contextPath%>/css/public.css" type="text/css" rel="stylesheet" />
	<link href="<%=contextPath%>/css/loginAdmin.css" type="text/css" rel="stylesheet" />
	<!-- Script -->
	<script type="text/javascript" src="<%=contextPath%>/js/common/jquery-1.6.min.js"></script>
	<script type="text/javascript" src="<%=contextPath%>/js/common/md5-min.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			var inputid = "${inputId}";
			var errorMsg = "${errorMsg}";
			
			if(errorMsg == ""){
				$("#loginUpMsg").hide();
			}else{
				$("#loginUpMsg").html(errorMsg);
				$("#loginUpMsg").show();
			}
			
			if(inputid == ""){
			    $("#loginName").focus();
			}else{
				$("#"+inputid).focus();
			}
			
			$(this).keypress(function (e){
				if(e.keyCode == 13){
					doAdminLogin();
				}
			});
			
		});
		
		function doAdminLogin(){
			
			var loginName = $("#loginName").val();
			if($.trim(loginName) == ""){
				$("#loginUpMsg").html("请输入用户名");
				$("#loginUpMsg").show();
				$("#loginName").focus();
				return;
			}
			var loginPass = $("#loginPass").val();
			
			if($.trim(loginPass) == ""){
				$("#loginUpMsg").html("请输入密码");
				$("#loginUpMsg").show();
				$("#loginPass").focus();
				return;
			}
			
			var vilicode = $("#vilicode").val();
			if($.trim(vilicode) == ""){
				$("#loginUpMsg").html("请输入验证码");
				$("#loginUpMsg").show();
				$("#vilicode").focus();
				return;
			}
			
			$.ajax({
				url: "<%=contextPath%>/validAdminLoginCode.do",
				type:'POST',
		        data:{
		        	vilicode:vilicode
		        },
		        success: function (data){
		        	if(data == "true"){
		        	    var passRandom = $("#passRandom").val();
					    var pass = hex_md5(hex_md5(loginPass)+passRandom);
					    $("#loginPass").val(pass);
					    $("#adminLoginForm").submit();
		        	}else{
		        		$("#loginUpMsg").html("验证码错误");
						$("#loginUpMsg").show();
						$("#vilicode").focus();
		        	}
		        }
			});
		}
		
		function changeAdminLoginImg(obj){
			obj.src= "<%=contextPath%>/showAdminImg.do?r="+ Math.random();
		}
		
	</script>
  </head>

  <body>
	<!--header-->
	<div class="loginAdminLogo">
	    <span class="logoE">管理员登录</span>
	</div>

	<!--main-->
	<div class="loginA">
		<div class="loginAd">
	    	<div class="loginAdmin">
	    	   <form id="adminLoginForm" action="<%=contextPath%>/doadminlogin.do" method="post">
	    	        <div class="loginUp" id="loginUpMsg" style="display:none;"></div>
		        	<h2><img src="images/admin.jpg" />管理员登录</h2>
		            <div class="loginInput">
		            	<label>账 号：</label><input class="txt" type="text" name="loginName" value="${loginName}"  id="loginName"/>
		            </div>
		            <div class="loginInput">
		            	<label>密 码：</label>
		            	<input class="txt" type="password" name="loginPass" id="loginPass"/>
		            	<input class="txt" type="hidden" name="passRandom" id="passRandom" value="${passRandom}"/>
		            </div>
		            <div class="loginInput02">
		                <div class="loginCode">
		                    <label>验证码：</label><input class="txt02" type="text" name="vilicode" id="vilicode"/>
		                </div>
		                <div class="loginImg"><img src="<%=contextPath%>/showAdminImg.do" width="90" height="40" onclick="changeAdminLoginImg(this)" style="cursor:pointer;" alt="换一张"/></div>
		            </div>
		            <div class="loginInput03">
		                <a href="#" class="loginBtn" onclick="doAdminLogin()" title="登录"><em class="lt"></em><em class="rt"></em>登录</a>
		                <a href="#" class="loginNo" title="">&nbsp;</a>
		            </div>
	            </form>
	        </div>
	        <div class="shadow"></div>
	    </div>
	</div>
	
    <!--footer-->
    <%@ include file="../../common/adminFooter.jsp"%>
  </body>
</html>