<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose标签</title>
</head>
<body>
<%--
        完成数字编号对应星期几的案例

--%>
<%
    pageContext.setAttribute("number",3);

%>
<c:choose>
    <c:when test="${pageScope.number == 1}">星期一</c:when>
    <c:when test="${pageScope.number == 2}">星期二</c:when>
    <c:when test="${pageScope.number == 3}">星期三</c:when>
    <c:when test="${pageScope.number == 4}">星期四</c:when>
    <c:when test="${pageScope.number == 5}">星期五</c:when>
    <c:when test="${pageScope.number == 5}">星期六</c:when>
    <c:when test="${pageScope.number == 5}">星期日</c:when>
    <c:otherwise>输入有误</c:otherwise>
</c:choose>

</body>
</html>
