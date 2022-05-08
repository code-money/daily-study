<%@ page import="com.zyz.entity.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = new User();
    user.setName("张三");
    user.setAge(23);
    user.setBirthday(new Date());
    request.setAttribute("user",user);

    List list = new ArrayList();
    list.add("aa");
    list.add("bb");
    list.add(user);
    request.setAttribute("list",list);

    HashMap hashMap = new HashMap();
    hashMap.put("sname","张三");
    hashMap.put("gender","男");
    request.setAttribute("map",hashMap);
%>
<h3>el获取对象中的值</h3>
<%--
    通过的是对象的属性来获取
    get或者set方法  去掉set将剩余部分首字母变为大写
    getName-->Name-->name
--%>
${requestScope.user.name}<br>
${requestScope.user.age}<br>
${requestScope.user.birthday.year}<br>
${requestScope.user.birStr}

<h3>el获取集合</h3>
${requestScope.list}<br>
${requestScope.list[0]}<br>
${requestScope.list[1]}<br>
${requestScope.list[2].name}<br>

<h3>el获取Map</h3>
${requestScope.map}<br>
${requestScope.map.gender}<br>
${requestScope.map["gender"]}<br>
${requestScope.map.sname}<br>
</body>
</html>
