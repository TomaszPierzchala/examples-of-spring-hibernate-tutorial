<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Consumer Form</title>
<style>.error { color: #f23; font-weight: bold;}</style>
</head>
<body>
<h3>Fill The form</h3>
<hr>
<form:form action="processForm" modelAttribute="consumer">
	
 	First Name : <form:input path="firstName"/> 
 	<br>
 	Last Name (*): <form:input path="lastName"/>
 	<form:errors path="lastName" cssClass="error"/>
 	<br>
 	<br>
 	Free passes : <form:input path="freePasses"/>
 	<form:errors path="freePasses" cssClass="error"/>
 	<br>
 	<br>
 	Postal code : <form:input path="postalCode"/>
 	<form:errors path="postalCode" cssClass="error"/>
 	<br>
 	<br>
 	
 	Customer since : <form:input path="consumerSince" type="date" />
 	<form:errors path="consumerSince" cssClass="error"/>
 	<br>
 	<br>
	<input type="submit" value="This is mine consumer">
</form:form>
<br>
<br>
<hr>
<small>*) field is required</small>

</body>
</html>