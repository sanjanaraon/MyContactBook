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
    <link rel="stylesheet" href="http://jqueryvalidation.org/files/demo/site-demos.css">

</head>
<body>
<form action="/add" method="post" name="Contact" id="detail-form">
    <label>Enter your name:</label>
    <input type="text" name="name" required><br>
    <label>Enter your mobile number:</label>
    <input type="text" name="mobileNumber" required id="mobileNumber"><br>
    <label>Enter your street1:</label>
    <input type="text" name="street1" required><br>
    <label>Enter your street2:</label>
    <input type="text" name="street2"><br>
    <label>Enter your city:</label>
    <input type="text" name="city" required><br>
    <label>Enter your emailid:</label>
    <input type="text" name="emailId" required id="emailId"><br>
    <input type="submit" value="Submit">
    <input type="reset" value="Reset">
</form>
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>
<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>
<script>
    // just for the demos, avoids form submit
//    jQuery.validator.setDefaults({
//        debug: true,
//        success: "valid"
//    });
    $( "#detail-form" ).validate({
        rules: {
            emailId: {
                required: true,
                email: true
            },
            mobileNumber:{
                required: true,
                number:true,
                minlength:8,
                maxlength:10
            }
        }
    });
</script>
<%--<script>--%>
    <%--$("#detail-form").validate();--%>
<%--</script>--%>
</body>
</html>
