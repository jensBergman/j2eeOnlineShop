<%@page import="busineesTier.models.Products"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*, java.text.*;"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>

    <%
    	Products product = (Products) session.getAttribute("currentProduct");
        DateFormat tipe = new SimpleDateFormat("EEE, MMM d, ''yy");
        Calendar cal = product.getModifiedDate();
    %>
</head>
<body>
Id: ${currentProduct.id}<br>
Name: ${currentProduct.name}<br>
EAN: ${currentProduct.productSKU}<br>
Price: ${currentProduct.listPrice}<br>
Manufacturer: ${currentProduct.manufacturer}<br>
Last modified: <% out.print(tipe.format(cal.getTime())); %><br>
<br>
<br>
<a href="admin/editProduct.jsp">Edit</a><br>
<a href="Products?action=removeProduct">Remove</a>
</body>
</html>