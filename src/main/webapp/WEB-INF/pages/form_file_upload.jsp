<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@page isELIgnored="false" %>
<h1 style="color:red;text-align:center">File Uploading form page</h1>
<h4 style="color: maroon;">
 ${upl_filename}
</h4>
<form:form  method="post"  enctype="multipart/form-data" commandName="uplCmd">
 
  select file ::: <input type="file"  name="file"><br>
  <input type="submit"  value="upload"/> 
  
</form:form>


<br><br>
<a href="home_page.htm">Home_page</a>