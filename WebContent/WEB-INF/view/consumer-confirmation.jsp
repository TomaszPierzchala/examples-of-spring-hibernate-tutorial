<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<html>
<body>
<h3>Result</h3>
<hr>

Consumer name :  ${consumer.firstName} ${consumer.lastName} 
<br>
Free passes = ${consumer.freePasses}
<br>
<br>
Postal code : ${consumer.postalCode}>
<br>
Customer since : ${consumer.consumerSince}
<br>
<hr>

</body>
</html>