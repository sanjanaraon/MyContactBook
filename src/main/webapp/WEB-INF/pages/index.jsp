<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<head><title>Contact Book</title>
    <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">
</head>
<a href="/">Home</a>
<a href="/getUserDetail?emailId=user@mail.com">Welcome </a><br><hr>
<form action="/getContactByNameOrNumber">
<input type="text" name="searchContact" placeholder="enter name or number to search" align="center" size="50">
    <input type="submit" value="search">
</form>
<hr>
<a href="addNewContact">add contact</a>
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
            <td><a href="getContact?emailId=${contact.emailId}"> <input type="submit" value="EDIT"></a></td>
            <td><form action="delete?emailId=${contact.emailId}" method="post"><input type="hidden" name="_method" value="DELETE"><input type="submit" value="DELETE"></form></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>