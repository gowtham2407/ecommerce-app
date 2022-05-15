<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ page isELIgnored="false" %>
<title>Welcome</title>

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
	background: linear-gradient(to right, #fc5c7d, #6a82fb);
}
form{
width:25rem;
height:28rem;
display:flex;
flex-direction:column;
background: rgba(255,255,255,0.06);
box-shadow:0 8px 32px 0 rgba(31,38,135,.37);
border-radious:30px;
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
padding-left:10px;
}
input{
width:80%;
margin-left:10%;
margin:5% auto;
}
select{

width:80%;
margin-left:10%;
margin:5% auto;
}

</style>

</head>
<body>
<form action="/LoginUser" method="post" id="form"> <h1>Login</h1>
<label>Mobile</label>
<input type ="text"  id="mobile" name="mobile" required onchange="mobilevalidation()">
    <span id="textmobile"></span> </input>
<label>Password</label>
<input type="password" name ="password"></input>


<select name="action">

  <option value="1" selected>Buyer</option>
  <option value="2">Seller</option>
</select>
<input type="submit" value="Sign up"></input><br>

<a href="/SignupUser"> New User Click here</a>
${error}
<h3>

</h3>
</form>
<script type="text/javascript">

	

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