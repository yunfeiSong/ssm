<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="${role.id}"/>
<p>${role.note}</p>
<p>${role.roleEnum}</p>

</body>
</html>
