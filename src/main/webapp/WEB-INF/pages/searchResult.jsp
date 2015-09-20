<%--
  Created by IntelliJ IDEA.
  User: sanjanar
  Date: 20/09/15
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<h4>${message}</h4>
<table>
  <c:forEach var="contact" items="${contacts}">
    <tr>
      <td>name:${contact.name}</td>
      <td>mobile number:${contact.mobileNumber}</td>
      <td>street1:${contact.street1}</td>
      <td>street2:${contact.street2}</td>
      <td>city:${contact.city}</td>
      <td>email id:${contact.emailId}</td>
      <td><a href="getContact?emailId=${contact.emailId}"> Edit</a></td>
      <td><a href="delete?emailId=${contact.emailId}">Delete</a></td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
