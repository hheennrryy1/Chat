<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = this.getServletContext().getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>Chatroom</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
		<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet"/>
		<script src="<%=path %>/js/jquery.min.js"></script>
		<script src="<%=path %>/js/chat.js"></script>
		<script>
			var username = '${username}';
		</script>
	</head>
	
	<body>
		<h1 class="text-center">Chatroom</h1>
		<h2 class="text-center">Welcome,${username}</h2>
		<div class="container">
		    <div id="message"></div>
		    <textarea id="text" class="form-control" rows="3"></textarea>
		    
		    <br />
			
		    <div class="col-sm-offset-5">
			    <button id="send-button" class="btn btn-primary">发送</button> 
			    <button id="close-button" class="btn btn-danger">断开</button>
		    </div>
		    
		    <br />
		</div>
	</body>
</html>