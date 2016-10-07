<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*,busineesTier.models.Products"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
 
<html>
    <head>
        <title>Products</title>
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet">
        
        
        <script type="text/javascript">
        	function selectProduct(){
        		alert ( "Kod röd!" );
        		return true;
        	}
        </script>

    </head>
 
    <body>
        
        <table class="table">
        	<thead>
			  <tr>
			    <th>Name</th>
			    <th>Manufacturer</th>
			    <th>SKU</th>
			    <th></th>
			  </tr>
	  		</thead>
	  		<tbody>
			<c:forEach items="${products}" var="item">
		     <tr>
			    <td>${item.name}</td>
			    <td>${item.manufacturer}</td>
			    <td>${item.productSKU}</td>
			    <td><a class="btn" href="Products?action=getProduct&currentProductId=${item.id}">View</a></td>
			  </tr>
			</c:forEach>
			</tbody>
		</table>
     </body>
 </html>