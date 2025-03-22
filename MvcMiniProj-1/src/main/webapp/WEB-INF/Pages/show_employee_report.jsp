<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
  <c:when test="${not empty list}">
    <h1 style="color:red; text-align:center">Employee Report</h1>
    <table border="1" align="center" bgcolor="cyan">
      <tr style="color:red; text-align: center;">
        <th>Eid</th>
        <th>EName</th>
        <th>ECate</th>
        <th>ESal</th>
      </tr>
      <c:forEach var="emp" items="${list}">
        <tr style="color:blue; text-align: center;">
          <td>${emp.eid}</td> 
          <td>${emp.ename}</td> 
          <td>${emp.ecate}</td> 
          <td>${emp.esal}</td> 
          
          <td><a href="edit?no=${emp.eid} "><h6>edit</h6></a>
          <a href="delete?no=${emp.eid} "><h6>delete</h6></a>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <h1 style="text-align:center; color:red">Employee Not Found</h1>
  </c:otherwise>
</c:choose>
<h2 style="text-align:center;color:red">${resultMsg} </h2>
<centre>
<a href="add "><h6>AddEmployee</h6></a>
<a href="search"><h6>search</h6></a>

<a href="./ "><h6>Home</h6></a>
</centre>


