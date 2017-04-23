<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HSKA Pizza Shop</title>
</head>
<body>




<c:if test="${bindingResult != null}">
    <ul>
        <c:forEach var="message" items="${bindingResult.allMessages}">
            <li><span style="color: red;">${mvc.encoders.html(message)}</span></li>
        </c:forEach>
    </ul>
</c:if>
<form action="${mvc.basePath}/placeorder" method="post">
	<select name="id">
		<c:forEach var="pizza" items="${pizzas}">
	        <option value="${mvc.encoders.html(pizza.id)}" >${mvc.encoders.html(pizza.name)}</option>
	    </c:forEach>
	</select><br>
	<input name="amount" placeholder="Amount"><br>
    <input name="comment" placeholder="Comment"><br>
    <input type="submit" value="Place Order">
    
    <input type="hidden" name="${mvc.csrf.name}" value="${mvc.csrf.token}">
</form>

</body>
</html>
