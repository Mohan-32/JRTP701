


<%@ page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="frm" %>
<h1 style="color:red;text-align:centre">student registar form</h1>

<frm:form  action="add" method="Post" modelAttribute="emp">
   <table align="center" bgcolor="cyan">
   
   
     
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
           
           <td colspan ="2"><input type="submit" name = "Register"></td>
           <td colspan ="2"><input type="reset" name = "cancel"></td>
      </tr>  
      




   </table>


</frm:form>
