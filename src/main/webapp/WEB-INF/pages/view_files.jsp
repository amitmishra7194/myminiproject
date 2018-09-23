<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<h1 style="color:red"> Files to be donwloaded</h1>
<c:choose>
  <c:when test="${!empty filesList}">
     <table border="1">
       <c:forEach  var="file" items="${filesList}">
           <tr>
             <td> ${file}</td>
             <td> <a href="download.htm?file_name=${file}">download</a>  </td>
           </tr>
       </c:forEach>
     </table>
  </c:when>
  <c:otherwise>
     files  not found
  </c:otherwise>
</c:choose>
<br>
<a href="home_page.htm">HomePage</a>
