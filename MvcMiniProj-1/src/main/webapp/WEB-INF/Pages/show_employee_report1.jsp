<%@ page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<frm:form  action="search"  modelAttribute="emp">
   <table align="center" bgcolor="cyan">
   
    <tr>
           <td>Employee id:</td>
           <td><frm:input type="text" path = "eid"/></td>
      </tr> 
   
     
      <tr>
           <td>Employee Name:</td>
           <td><frm:input type="text" path = "ename"/></td>
      </tr> 
      
       <tr>
           <td>Employee Cate:</td>
           <td><frm:input type="text" path = "ecate"/></td>
      </tr>  
      
       <tr>
           <td>Employee Sal:</td>
           <td><frm:input type="text" path = "esal"/></td>
      </tr>    
      
      
       
      
       <tr>
           
           <td colspan ="2"><input type="submit" name = "update"></td>
           <td colspan ="2"><input type="reset" name = "cancel"></td>
      </tr>  
      




   </table>


</frm:form>


