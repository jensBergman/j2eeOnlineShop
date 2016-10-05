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
  
        <form method="POST" action="Products">
            Name: <input type="text" name="name" />
            <input type="submit" value="Add" />
        </form>
 
        <hr><ol> <%
            @SuppressWarnings("unchecked") 
            List<Products> products = (List<Products>)request.getAttribute("products");
            if (products != null) {
                for (Products product : products) { %>
                    <li> <%= product %> </li> <%
                }
            } %>
        </ol><hr>
        
        <table>
		  <tr>
		    <th>Name</th>
		    <th>Manufacturer</th>
		    <th>SKU</th>
		    <th></th>
		  </tr>
			<c:forEach items="${products}" var="item">
			     <tr>
			    <td>${item.name}</td>
			    <td>${item.manufacturer}</td>
			    <td>${item.productSKU}</td>
			    <td><a class="btn" href="Products?action=getProduct&currentId=${item.id}">View</a></td>
			  </tr>
			</c:forEach>
		</table>
     </body>
 </html>