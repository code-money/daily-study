<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取域中的数据</title>
</head>
<body>
    <%
        //在域中存储数据
        request.setAttribute("name","张三");
        session.setAttribute("tt","");
        session.setAttribute("age",23);
        session.setAttribute("name","李四");
    %>


    <h3>获取值</h3>
${requestScope.name}<br>
${requestScope.tt}<br>  <%--如果为空就不在前端页面上显示--%>
${sessionScope.age}<br>


${name}<br>   <%--直接写键名字会以域从小到大的顺序来寻找   pagecontext-->request-->session-->application(servletContext)   --%>
${sessionScope.name}<br>
</body>
</html>
