<%--
  Created by IntelliJ IDEA.
  User: sanjanar
  Date: 19/09/15
  Time: 7:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Detail</title>
    <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">

</head>
<body>
<form action="/update" name="Contact" id="myForm">
    <label>Enter your name:</label>
    <input type="text" name="name" value="${contact.name}" required><br>
    <label>Enter your mobile number:</label>
    <input type="text" name="mobileNumber" required id="mobileNumber" value=${contact.mobileNumber}><br>
    <label>Enter your street1:</label>
    <input type="text" name="street1" value="${contact.street1}" required><br>
    <label>Enter your street2:</label>
    <input type="text" name="street2" value="${contact.street2}"><br>
    <label>Enter your city:</label>
    <input type="text" name="city" value="${contact.city}" required><br>
    <label>Enter your emailid:</label>
    <input type="text" name="emailId" required id="emailId" value=${contact.emailId}><br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
<script>
    $("#myform").validate({
        rules: {
            emailId: {
                required: true,
                email: true
            },
            mobileNumber: {
                required: true,
                number: true,
                minlength: 8,
                maxlength: 10
            }
        }
    });
</script>
</body>
</html>
