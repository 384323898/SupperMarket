<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/searchIdName" method="post" >
    请输入学号<input type="text" name="id"/><br/>
    请输入姓名<input type="text" name="name"/><br/>
    <input type="submit" value="搜索" />
</form>

</body>
</html>
