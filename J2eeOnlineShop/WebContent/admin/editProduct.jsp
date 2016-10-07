<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Product</title>
</head>
<body>

<h3>Edit product</h3>
<form action="/J2eeOnlineShop/Products">
	 	<input type="hidden" name="action" value="editProduct">
	 	<input type="hidden" name="ProductId" value="${currentProduct.id}">
		Name: 
		<input name="ProductName" type="text" value="${currentProduct.name}"><br>
		SKU: 
		<input name="ProductSKU" type="text" value="${currentProduct.productSKU}"><br>
		Price: 
		<input name="ProductPrice" type="text" value="${currentProduct.listPrice}"><br>
		ProductManufacturer: 
		<input name="ProductManufacturer" type="text" value="${currentProduct.manufacturer}"><br>
		Category: 
		<input name="ProductCategory" type="text" value="${currentProduct.productCategoryId.name}"><br>
		<input type="submit" value="Submit">
</form>
</body>
</html>