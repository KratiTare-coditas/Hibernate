<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add product</title>
</head>
<body>
	<h1>Product Details</h1>
	<form action='AddToCart'>

	<input type='hidden' name="id" value="<c:out value='${product.id}' />" >
    Name:<input type='text' name="name" value="<c:out value='${product.name}' />" readonly >
    <br><br>
    Price:<input type='text' name="price" value="<c:out value='${product.price}' />"  readonly>
    <br><br>
    Enter Quantity:<input type='text' name="quantity">
    <br><br>
    <a href='customerlogin.html'><button class="btn btn-light">Back</button></a>
    <div align='center'>
    <button type="submit" class="btn btn-primary">Add To Cart</button>
    </div>
    <br><br><br>
</form>

</body>
</html>
