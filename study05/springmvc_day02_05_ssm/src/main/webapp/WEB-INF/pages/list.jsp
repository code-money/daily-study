<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>查询成功</h2>

<c:forEach items="${accounts}" var="account">
    ${account.name}
    ${account.money}<br>
</c:forEach>
</body>
</html>
