<!DOCTYPE html>
<html>
<head>
<title>foRm</title>
</head>
<body>
<h3>Fill The form</h3>
<hr>
<form action="processForm" method="post">
	<input type="text" name="studentName" placeholder="What's your name ?">
	<input type="submit" value="GO man">
</form>
<br>

1 : ${pageContext.request.contextPath}
</body>
</html>