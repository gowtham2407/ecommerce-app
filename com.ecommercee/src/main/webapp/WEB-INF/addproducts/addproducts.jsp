<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add products</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<form action="/addspecs" method="post">

		<label for="productName">product name</label> <input type="text"
			id="productName" name="productName"><br> <label
			for="productDesc">product description</label>
		<textarea id="productDesc" name="productDesc"></textarea>
		<br> <label for="brandName">brand name</label> <input type="text"
			id="brandName" name="brandName"><br> <label
			for="updatedCount">Add Count</label> <input type="number"
			id="updatedCount" name="updatedCount"><br> <label
			for="sellerMob">Seller Mobile</label> <input type="text"
			id="sellerMob" name="sellerMob"><br> <label for="price">Price</label>
		<input type="number" id="price" name="price"><br> <label
			for="discount">Discount</label> <input type="number" id="discount"
			name="discount"><br>

		<div class="form-group">
			<label for="Category">Category</label> <select name="category">
				<option value="select a category">Select a category</option>
				<option value="mobile">Mobile</option>
				<option value="laptop">Laptop</option>
				<option value="game">Game</option>
				<option value="kitchen">kitchen</option>
			</select>
		</div>
		<br>

		<div id="show_result"></div>

		<br> <input type="submit" value="Submit">



	</form>



	<meta name="viewport" content="width=device-width, initial-scale=1">
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"
		integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
		crossorigin="anonymous"></script>

	<script>
		var select = document.querySelector("select");
		let renderDiv = document.querySelector("#show_result");
		select.addEventListener("change", function() {
			renderDiv.innerHTML = "";
			$.ajax({
				url : '/addProducts',
				type : 'POST',
				data : 'category=' + select.value,
				success : function(response) {
					let specs = response.specs;
					for ( let str in specs) {
						console.log(specs[str]);
						let LB = document.createElement("Label");
						LB.setAttribute("for", specs[str]);
						LB.innerHTML = specs[str];
						renderDiv.appendChild(LB);
						let FN = document.createElement("input");
						FN.setAttribute("type", "text");
						FN.setAttribute("name", "spec=" + specs[str]);
						renderDiv.appendChild(FN)
						renderDiv.appendChild(document.createElement("br"));
					}
					// 	$('#show_result').html(specs);
				}
			});
		});
	</script>

</body>
</html>