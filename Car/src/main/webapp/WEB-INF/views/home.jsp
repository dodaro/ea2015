<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
	<title>CarSeller</title>
</head>
<body>
<h1>
	Make your choice 
</h1>
<form:form method="GET" commandname="form1" action="summary.html" /> 
<form  name="form1" method="POST" />
<input type="submit" name="button 1" value="car 1" onclick="button1()">SE (11000.00 euro)
<input type="submit" name="button 2" value="car 2" onclick="button2()">SE A/L (12400.00 euro)
<input type="submit" name="button 3" value="car 3" onclick="button3()">SL (15000.00 euro)
  <SCRIPT LANGUAGE="JavaScript">
            
            function button1()
            {
                document.form1.buttonName.value = "button 1"
                form1.submit()
            }    
            function button2()
            {
                document.form1.buttonName.value = "button 2"
                form1.submit()
            }    
            function button3()
            {
                document.form1.buttonName.value = "butto3 2"
                form1.submit()
            }    
            
        </SCRIPT>
        
      <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
<br/>

<a href="${pageContext.request.contextPath}/">Main page</a>

<br>  
</body>
</html>
