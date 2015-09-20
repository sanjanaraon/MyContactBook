/**
 * Created by sanjanar on 20/09/15.
 */
        // just for the demos, avoids form submit
//    jQuery.validator.setDefaults({
//        debug: true,
//        success: "valid"
//    });
function myValidationFunction(id){
    $( id ).validate({
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
        },
        message:{
            emailId:{
                required : "Please enter valid e-mail Id",
            },
            mobileNumber:{
                required : "Please enter numbers only",
                minlength : $.format("Minimum {0} characters required!"),
                maxlength : $.format("Maximum {0} characters allowed!")
            }
        }
    });
}
