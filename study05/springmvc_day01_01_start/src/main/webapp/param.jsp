<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请求参数绑定</title>
</head>
<body>

<%--普通参数接收--%>
<%--<a href="${pageContext.request.contextPath}/param/testParam?username=hehe&password=123456">请求参数绑定</a>--%>


<%--引用对象作为参数--%>
<%--<form action="${pageContext.request.contextPath}/param/saveAccount" method="post">--%>
<%--    姓名：  <input type="text" name="username"><br>--%>
<%--    密码：  <input type="text" name="password"><br>--%>
<%--    金额：  <input type="text" name="money"><br>--%>
<%--    用户姓名： <input type="text" name="user.uname"><br>--%>
<%--    用户年龄： <input type="text" name="user.age"><br>--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>


<%--集合对象作为参数--%>
<%--<form action="${pageContext.request.contextPath}/param/saveAccount" method="post">--%>
<%--    姓名：  <input type="text" name="username"><br>--%>
<%--    密码：  <input type="text" name="password"><br>--%>
<%--    金额：  <input type="text" name="money"><br>--%>
<%--    用户姓名： <input type="text" name="list[0].uname"><br>--%>
<%--    用户年龄： <input type="text" name="list[0].age"><br>--%>
<%--    用户姓名： <input type="text" name="map['one'].uname"><br>--%>
<%--    用户年龄： <input type="text" name="map['one'].age"><br>--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>


<%--自定义类型转换器--%>
<%--<form action="${pageContext.request.contextPath}/param/saveUser" method="post">--%>
<%--    用户姓名： <input type="text" name="uname"><br>--%>
<%--    用户年龄： <input type="text" name="age"><br>--%>
<%--    用户日期： <input type="text" name="date"><br>--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>


<%--原生API--%>
<a href="${pageContext.request.contextPath}/param/testServlet">Servlet原生API</a>
</body>
</html>
