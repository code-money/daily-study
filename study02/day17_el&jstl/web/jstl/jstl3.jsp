<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
<c:forEach begin="1" end="10" var="i" step="1">
    ${i}<br>
</c:forEach>
<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add("ddd");
    list.add("eee");
    request.setAttribute("list",list);
%>
<c:forEach items="${requestScope.list}" var="str">
    ${str}<br>
</c:forEach>
</body>
</html>
