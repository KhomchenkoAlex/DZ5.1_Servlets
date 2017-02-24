<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Guest Book</title>
</head>
<body>
<form method="post">
    <fieldset>
        <legend>Guest Book</legend>
        Name: <input type="text" name="name" placeholder="Name"></p>
        Message: <textarea name="message" cols=40 rows=2 placeholder="Message"></textarea><br/><br/>
        Rating: <select name="rating" size=1>
        <option> 1</option>
        <option> 2</option>
        <option> 3</option>
        <option> 4</option>
        <option> 5</option>
    </select>
    </fieldset>
    <br/><br/>
    <input type="submit">
</form>

<c:forEach items="${entries}" var="entry">
    <c:out value="${entry.value}"/>
    <c:out value="${entry.key}"/> <br/>
</c:forEach>

</body>
</html>
