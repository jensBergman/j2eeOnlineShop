<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add product</title>
</head>
<body>
	<h3>Add product</h3><hr>
	
	<form action="/J2eeOnlineShop/Products">
	 	<input type="hidden" name="action" value="addProduct">
		Name: 
		<input name="ProductName" type="text"><br>
		SKU: 
		<input name="ProductSKU" type="text"><br>
		Price: 
		<input name="ProductPrice" type="text"><br>
		ProductManufacturer: 
		<input name="ProductManufacturer" type="text"><br>
		Category: 
		<input name="ProductCategory" type="text"><br>
		<input type="submit" value="Submit">
	</form>
	
	<hr>
</body>
</html>