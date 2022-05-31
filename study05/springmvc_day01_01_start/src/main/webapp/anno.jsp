<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用注解</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/anno/testRequestParam?username=haha">RequestParam</a><br>
<br>


<form action="${pageContext.request.contextPath}/anno/testRequestBody" method="post">
    用户姓名： <input type="text" name="username"><br>
    用户年龄： <input type="text" name="age"><br>
    <input type="submit" value="提交">
    <span>RequestBody</span>
</form>
<br>


<a href="${pageContext.request.contextPath}/anno/testPathVariable/10">PathVariable</a>
<br>
<br>


<form action="${pageContext.request.contextPath}/anno/testModelAttribute" method="post">
    用户姓名： <input type="text" name="uname"><br>
    用户年龄： <input type="text" name="age"><br>
    <input type="submit" value="提交">
    <span>ModelAttribute</span>
</form>
<br>


<a href="${pageContext.request.contextPath}/anno/testSessionAttributes">SessionAttributes</a>
<a href="${pageContext.request.contextPath}/anno/getSessionAttributes">SessionAttributes</a>
<br>
<br>
</body>
</html>
