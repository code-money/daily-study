<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.6.0.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {

                $.ajax({
                    type:"POST",
                    url:"${pageContext.request.contextPath}/user/testAjax",
                    contentType:"application/json; charset=utf-8",
                    data:'{"username":"张三","password":"123","age":13}',
                    dataType:"json",
                    success:function (data) {
                        console.log(data);
                    }
                })
            })
        })
    </script>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/testString">testString</a>
<br>
<a href="${pageContext.request.contextPath}/user/testVoid">testVoid</a>
<br>
<a href="${pageContext.request.contextPath}/user/testModelAndView">testModelAndView</a>
<br>
<a href="${pageContext.request.contextPath}/user/testForwardOrRedirect">testForwardOrRedirect</a>
<br>


<button id="btn">发送ajax请求</button>
</body>
</html>
