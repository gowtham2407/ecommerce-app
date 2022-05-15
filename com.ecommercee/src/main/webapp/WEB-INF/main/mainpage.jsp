<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main page</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

</head>

<body onload="validation()">
	<div ${typeofuser} id="tyepofuser"></div>
	<nav class="navbar">
		<ul class="links-container">
			<li style='display: inline;'><img
				src=https://mpng.subpng.com/20180926/qau/kisspng-computer-icons-scalable-vector-graphics-applicatio-tynor-wrist-splint-ambidextrous-rs-274-wrist-s-5bac3149dcb297.944285061538011465904.jpg
				title=ecommerce width="150"></li>

			<li class="link-item" style='display: inline;'><a href="#"
				class="link">Mobiles</a></li>
			<li class="link-item" style='display: inline;'><a href="#"
				class="link">Tv</a></li>
			<li class="link-item" style='display: inline;'><a href="#"
				class="link">Kitchen</a></li>
			<li class="link-item" style='display: inline;'><a href="#"
				class="link">Games</a></li> &ensp; &ensp;
			<li class="link-item" style='display: inline;' style="hidden"><a
				href="/addProducts" id="seller1" class="link"> add products</a></li>
			<li class="link-item" style='display: inline;' style="hidden"><a
				href="/manageproducts" id="seller2" class="link"> Manage
					products</a></li>
			<li class="link-item" style='display: inline;' style="hidden"><a
				href="/yourorders" id="buyer" class="link"> Your orders</a></li>

			<li class="link-item" style='display: inline;'><a
				href="/LoginUser" class="link">logout</a></li>

			</li>
		</ul>
	</nav>

			<div class="card-header my-3">All Products</div>
	
	<div class="container" id="renderDiv">
	</div>


	<script src="https://code.jquery.com/jquery-1.12.4.min.js"
		integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
		crossorigin="anonymous"></script>
	<script type="text/javascript"> 
function validation(){
	
	<%String type = (String) request.getAttribute("type");%>
	var s= "<%=type%>";
			console.log(s)
			if (s === "Seller") {
				document.getElementById("seller1").style.visibility = "visible";
				document.getElementById("seller2").style.visibility = "visible";
				document.getElementById("buyer").style.visibility = "hidden";

			} else if (s === "Buyer") {
				document.getElementById("seller1").style.visibility = "hidden";
				document.getElementById("seller2").style.visibility = "hidden";
				document.getElementById("buyer").style.visibility = "visible";
			}

		}
		
		$.ajax({
			url : '/getProducts',
			type : 'GET',
			success : function(response) {
				console.log(response);
// 				<div class="card" style="width: 18rem;">
// 				  <div class="card-body">
// 				    <h5 class="card-title">Card title</h5>
// 				    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
// 				    <a href="#" class="btn btn-primary">Go somewhere</a>
// 				  </div>
// 				</div>
				let renderDiv = document.querySelector("#renderDiv");
				renderDiv.innerHTML="";
				for (let obj of response) {
					let div1 = document.createElement("div");
					div1.classList.add("card");
					div1.setAttribute("style", "width:18rem");
					let div2 = document.createElement("div");
					div2.classList.add("card-body");
					div1.appendChild(div2);
					let h5 = document.createElement("h5");
					h5.classList.add("card-title");
					h5.innerHTML = obj.productName;
					div2.appendChild(h5);
					renderDiv.appendChild(div1);
				}
				
			}
		});

		
	</script>




	<style>
.product-list {
	background-color: #b2bec3;
	padding: 3em;
}

.product-list .card {
	background-color: white;
	border-radious: 10px;
	padding: 1em;
	box-shadow: 0px 10px 5px #b2bec3;
	text-align: center;
}

.card img {
	max-width: 100%;
	border-radious: 5;
}

.card .title {font-size 18px;
	font-weight: bold;
}

.card .text {
	text-align: left;
	margin-left: 2em;
}

.btn-primary {
	background-color: #f9ca24;
	border: none;
	padding: 1em;
	border-radius: 20px;
}

.container {
	width: 100%;
	display: flex;
	padding: 10px 10vw;
	list-style: none;
}

.link {
	text-transform: capitalize;
	padding: 0 10px;
	margin: 0 5px;
	text-decoration: none;
	color: #383838;
	opacity: 0.5;
	transition: .5s;
}

.link:hover {
	opacity: 2;
}

.product-container {
	padding: 0 10vw;
	display: flex;
	overflow-x: auto;
	scroll-behavior: smooth;
}

.product-container::-webkit-scrollbar {
	display: none;
}
</style>
	<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
</body>
</html>