<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/dosearch" method="post" >
    请输入书名
    <input type="text" name="bookname"/>
    <input type="submit" value="搜索" />
</form>

</body>
</html>
