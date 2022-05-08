<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="top.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    pageContext.setAttribute("msg","今天天气真不错");
%>

<%=pageContext.getAttribute("msg")%>

</body>
</html>
