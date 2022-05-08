<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
    <c:if test="true">
        <h1>我是真</h1>
    </c:if>

<%
    //判断request域中list集合是否为空
    List list = new ArrayList();
    list.add("aa");
    list.add("bb");
    request.setAttribute("list",list);

%>
    <c:if test="${not empty requestScope.list}">
        <h3>遍历集合...</h3>
        <c:forEach items="list">
        </c:forEach>
    </c:if>
</body>
</html>
