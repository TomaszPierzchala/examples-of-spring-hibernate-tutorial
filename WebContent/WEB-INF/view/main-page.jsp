<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
<head>
	<link rel='stylesheet' type='text/css' 
		  href='${pageContext.request.contextPath}/resources/css/my-test.css'>

    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
    
    <%-- <link href="<c:url value="/resources/css/my-test.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/simple-test.js" />"></script> --%>

</head>

<body>
<h3>This is may Main Page</h3>
<hr>
<a href="home/showForm">Home Form</a>
<br><br>
<a href="student/showForm">Student Form</a>
<br><br>
<a href="consumer/showForm">Consumer Form</a>
<br><br>

<input type="button" onclick="doSomeWork()" value="Click Me"/>


</body>
</html>