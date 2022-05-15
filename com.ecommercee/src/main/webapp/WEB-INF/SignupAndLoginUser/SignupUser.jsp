<web-app xmlns="http://java.sun.com/xml/ns/j2ee"
     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd"
     version="2.4">
<!DOCTYPE html>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User </title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Poppins:ital,wght@1,400;1,900&display=swap');
*{ margin:0;
padding:0;
box-sizing:border-box;
font-family: 'Poppins', sans-serif;
}
body{
	height:100vh;
	width: 100%;
	display :flex;
	justify-content:center;
	align-items:center;
	background: linear-gradient(to right, #8360c3, #2ebf91);
}
form{
width:25rem;
height:30rem;
display:flex;
flex-direction:column;
background: rgba(255,255,255,0.06);
box-shadow:0 8px 32px 0 rgba(31,38,135,.37);
border-radious:30px;
padding-left:10px;
}
h1{
font-size:40px;
text-align:center;
}
h3{
font-size:20px;
text-align:center;
}
label{
font-size:20px;
text-align:center;
padding-left:10px;

}
input{

width:80%;
padding-left:10px;
margin:2% auto;

}

</style>
</head>
<body>
<form action ="/signupUser" method="post" id="form" >

<h1>New User Signup </h1>
<div>
    <label for="email">Email:</label><br>
    <input type="text" id="email" name="email" required onchange="validation()"><br>
    <span id="textemail"></span>
</div>
<div>
    <label for="username">Username:</label><br>
    <input type="text" id="username" name="username" required>
</div>
<div>
    <label for="mobile"> Mobile:</label><br>
    <input type="text" id="mobile" name="mobile" required onchange="mobilevalidation()"><br>
    <span id="textmobile"></span>   
    </div>
<div>
    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password" 
           minlength="8" required>
</div>
<h3>
<select name="action">

  <option value="1" selected>Buyer</option>
  <option value="2">Seller</option>
</select>
</h3>

<font color="red">  
${error}
</font>  
<input type="submit" value="Sign up">
<a href="/LoginUser"> Already have an account Click here</a>


</form>
<script type="text/javascript">
function validation(){
	
	var form= document.getElementById("form");
	var email=document.getElementById("email").value;
    var pattern1="(^[a-zA-Z][a-zA-Z0-9\\.]+)@([a-z0-9]+)\\.([a-z]{2,3})(\\.[a-z]{2,3})?$";
    if(email.match(pattern1)){
    	
    	textemail.innerHTML="Your email is valid";
    	textemail.style.color="#00ff00"
    }else {
    	
    	textemail.innerHTML="Your email is Invalid";
    	textemail.style.color="#ff0000"
    }
	
	
}
function mobilevalidation(){
	
	var form= document.getElementById("form");
	var mobile=document.getElementById("mobile").value;
    var pattern2="[0-9]{9}";
    if(mobile.match(pattern2)){
    
    	textmobile.innerHTML="Your Mobile number is valid";
    	textmobile.style.color="#00ff00"
    }else {
    	
    	textmobile.innerHTML="Your Mobile number is Invalid";
    	textmobile.style.color="#ff0000"
    }
	
}
</script>
</body>
 
</html>
</web-app>