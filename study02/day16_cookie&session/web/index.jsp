<%--
  Created by IntelliJ IDEA.
  User: Napoleon
  Date: 2022/5/3
  Time: 22:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    System.out.println("hello jsp");
    int i=5;  //定义局部变量

    String contextPath = request.getContextPath();
    out.println(contextPath);
  %>

  <%!
    int i=3;   //定义成员变量
  %>

  <%=i%>  <%--//输出局部变量i--%>

  <%
    response.getWriter().write("response...."); //response对象输出流永远优先于out
  %>
  </body>
</html>
