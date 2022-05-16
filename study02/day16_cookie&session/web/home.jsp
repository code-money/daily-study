<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //设置响应头
    response.setContentType("text/html;charset=utf-8");
    Cookie[] cookies = request.getCookies();
    if (cookies!=null){
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("lastTime")){
                Date date = new Date();
                //进行格式设置，出现空格会报错，cookie不支持空格
                SimpleDateFormat ft = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
                //获取上次的访问时间
                String value = cookie.getValue();
                %>
<h1>欢迎回来，您上次的访问时间为<%=value%></h1>
<%
                //重新设置cookie对应的值
                cookie.setValue(ft.format(date));
                //将cookie返回，如果不进行返回就不会更新
                response.addCookie(cookie);
                break;
            }
        }
    }else {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
        String value=ft.format(date);
        Cookie cookie = new Cookie("lastTime",value);
        response.addCookie(cookie);

%>
        <h1>欢迎您，首次访问</h1>
<%
    }
%>


</body>
</html>
