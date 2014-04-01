<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Juan
  Date: 3/27/14
  Time: 9:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Companies</title>
</head>
<body>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Company Name</th>
        <th>Company Ticker</th>
        <th>Company Exchange</th>
    </tr>
    <c:forEach items="${companies}" var="company">
        <tr>
            <td>${company.id}</td>
            <td>${company.name}</td>
            <td>${company.ticker}</td>
            <td>${company.exchange}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
