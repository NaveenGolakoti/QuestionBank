<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Generate PDF</title>
</head>
<body>
<h1 style="text-align:center;">QUESTION BANK</h1>
<div class="container1" style="margin-left:400px;margin-top:100px;margin-right:200px;border:2px solid black"">
<form method="get" action="generateAssignmentPdf.htm" style="margin:30px;">
<input type="submit" value="Generate Assignment PDF" style="font-weight:bold">
</form>
<br><br>
<form method="get" action="generateTestPdf.htm" style="margin:30px;">
<input type="submit" value="Generate Test PDF "style="font-weight:bold">
</form>
</div>
<div class="conatiner2"style="margin-left:400px;margin-top:100px;margin-right:200px;border:2px solid black">
<jsp:include page="/WEB-INF/views/home.jsp"></jsp:include>
</div>
</body>
</html>