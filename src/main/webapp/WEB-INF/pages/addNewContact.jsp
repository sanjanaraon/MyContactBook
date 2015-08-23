<%--
  Created by IntelliJ IDEA.
  User: sanjanar
  Date: 23/08/15
  Time: 4:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Contact</title>
</head>
<body>
<form action="/contacts/add" >
    <label>Enter your name:</label>
    <input type="text" name="name"><br>
    <label>Enter your mobile number:</label>
    <input type="text" name="mobile number"><br>
    <label>Enter your street1:</label>
    <input type="text" name="street1"><br>
    <label>Enter your street2:</label>
    <input type="text" name="street2"><br>
    <label>Enter your city:</label>
    <input type="text" name="city" ><br>
    <label>Enter your emailid:</label>
    <input type="text" name="emailid"><br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
</body>
</html>
