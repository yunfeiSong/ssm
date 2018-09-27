<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>index</title>
  </head>
  <body>
  <c:out value="${jsessionId}"/>
  <br/>
  <c:out value="${userAgent}"/>
  <br/>
 <a href="${pageContext.request.contextPath}/con/getRole/10.do">redirectToRole</a>
  </body>
</html>
