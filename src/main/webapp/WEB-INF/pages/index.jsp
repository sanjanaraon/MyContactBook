<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<head><title>Contact Book</title></head>
<a href="/">welcome user</a><br>
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
            <td><a href="getContact?emailId=${contact.emailId}" > Edit</a></td>
            <td><a href="delete?emailId=${contact.emailId}" >Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>