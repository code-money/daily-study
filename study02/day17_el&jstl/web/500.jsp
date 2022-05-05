<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>服务器正忙...</h1>
<%
    String message = exception.getMessage(); //想要使用exception必须在当前页面头标注：isErrorPage="true"
    out.print(message);
%>
</body>
</html>
