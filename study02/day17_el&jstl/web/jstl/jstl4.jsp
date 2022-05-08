<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zyz.entity.User" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    List<User> list = new ArrayList();
    list.add(new User("张三",23,new Date()));
    list.add(new User("李四",83,new Date()));
    list.add(new User("王五",45,new Date()));
    request.setAttribute("list",list);
%>

<table border="1" width="500" align="center">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>日期</td>
    </tr>
<c:forEach items="${requestScope.list}" var="user" varStatus="s">
    <tr>
        <td>${s.count}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.birStr}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
