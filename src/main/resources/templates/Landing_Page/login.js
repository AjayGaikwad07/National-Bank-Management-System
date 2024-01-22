function validateForm(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("pwd").value;


    // Simple validation for the username (non-empty)

    if (username=="") {
        document.getElementById("usernameError").innerHTML="Username is required.";
        return false;
    } else{
        document.getElementById("usernameError").innerHTML="";
    }

    // Simple validation for the password (non-empty)

    if (password=="") {
        document.getElementById("passwordError").innerHTML="Password is required.";
        return false;
    } else{
        document.getElementById("passwordError").innerHTML="";
    }

    return true;
   
}
// Function to toggle password visibility
document.getElementById('showPassword').addEventListener('change',function(){
    var pwdInput = document.getElementById('pwd');
    pwdInput.type= this.checked ? 'text': 'password';

}); 