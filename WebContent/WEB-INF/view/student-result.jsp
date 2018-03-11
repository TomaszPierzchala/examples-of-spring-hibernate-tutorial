<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<html>
<body>
<h3>Result</h3>
<hr>

Student name : ${student.firstName} ${student.lastName} from ${student.country}
<br>
sex : ${student.gender}
<br>
Prefered OS :
<ul>
<c:forEach var="i" items="${student.oss}">
	<li>${i}</li>
</c:forEach>
</ul>
<br>
${student}
<br>
<br>
<hr>

<br><br>
${theCountryOptions}
</body>
</html>