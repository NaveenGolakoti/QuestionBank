<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   
<!DOCTYPE html>  
<html>  
 <head>  
 <title>Question Bank</title>  
 </head>  
 <body>
 <div class="container3">  
<h1 style="text-align:center;">Upload question bank here</h1>  
  <hr style="height:1px;border:none;color:#333;background-color:#333;">
<h3 style="color:red">${filesuccess}</h3>  
<form:form method="post" action="savefile" enctype="multipart/form-data" style="margin-left:300px;">  
<p><label for="image">Choose file</label></p>  
<p><input name="file" id="fileToUpload" type="file" /></p>  
<p><input type="submit" value="Upload"></p>  
</form:form> 
</div> 
</body>  
</html>  