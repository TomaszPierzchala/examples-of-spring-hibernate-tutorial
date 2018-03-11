<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>foRm</title>
</head>
<body>
<h3>Fill The form</h3>
<hr>
<form:form action="processForm" modelAttribute="student">
	
 	First Name : <form:input path="firstName"/> 
 	<br>
 	Last Name : <form:input path="lastName"/>
 	<br>
 	<form:select path="country"  items="${theCountryOptions}"/>
	<%-- 
	<form:select path="country">
 		<form:options items="${theCountryOptions}"/>
 	</form:select> 	
 	--%>
 	<br><br>
 	
 	<form:radiobuttons items="${student.genderLabels}" path="gender"/>
 	<br><br>
 	Operating systems : 
 	<form:checkboxes items="${student.ossLabels}" path="oss"/>
 	<br>
 	<br>
	<input type="submit" value="GO man">
</form:form>
<br>

1 : ${pageContext.request.contextPath}
</body>
</html>