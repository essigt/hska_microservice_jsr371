<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HSKA Pizza Shop</title>
</head>
<body>

<h1>Your order:</h1>
<p>You have ordered ${mvc.encoders.html(amount)} Pizza "${mvc.encoders.html(name)}".</p>


</body>
</html>