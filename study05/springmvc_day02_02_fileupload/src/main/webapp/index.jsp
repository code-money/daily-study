<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>传统方式文件上传</h2>
<form action="${pageContext.request.contextPath}/file/fileUpload1" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload"> <br>
    <input type="submit" value="上传">
</form>
<br>
<h2>SpringMvc文件上传</h2>
<form action="${pageContext.request.contextPath}/file/fileUpload2" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="upload"> <br>
    <input type="submit" value="上传">
</form>
</body>
</html>
