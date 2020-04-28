<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
       <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="myclass" style="margin-left:400px;margin-top:100px;margin-right:200px;border:2px solid black"">
<h2 style="text-align:center;">Download Assignments</h2>
 <hr style="height:1px;border:none;color:#333;background-color:#333;">
 <c:choose>
  <c:when test="${fn:length(list) > 0 }">
  <c:forEach var="links" items="${list}">  
<a style="margin-left:400px;font-size:x-large;"href="downloadPdf?type=assignment&typeNumber=${links}">assignment${links}</a> <br><br>
</c:forEach>
  </c:when>
  <c:otherwise>
       <p style="color:red;font-weight:bold;text-align:center;">No data found. Please upload questions to download</p> 
        <br />
    </c:otherwise>
 </c:choose>
 
</div>
<a href="index.jsp"><input style="font-weight: bold;
    background-color: lightgrey;margin-top: 30px;
    margin-left: 400px;" type="button" value="Go To Home" name="Go Back"/></a>
</body>
</html>