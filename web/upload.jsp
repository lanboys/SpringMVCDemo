<%--
  Created by IntelliJ IDEA.
  User: lanbing
  Date: 2018/4/27
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<fieldset>

    <legend>文件上传</legend>

    ${uploadResultMsg}

    <form action="${pageContext.request.contextPath}/uploadFile" method="post"
          enctype="multipart/form-data">

        <input type="file" name="multipartFile"/>
        <input type="submit" name="submitFile" value="点击上传" />
    </form>

</fieldset>


</body>
</html>
