package webTier.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import busineesTier.models.ProductCategories;
import busineesTier.models.Products;
import businessTier.DAOs.ProductDAO;

/**
 * Servlet implementation class SearchController
 */
@WebServlet(description = "Search for products in the online store", urlPatterns = { "/Products" })
public class ProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// Injected DAO EJB:
    @EJB ProductDAO productDao;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		System.out.println("Inside get");
		
		String action = request.getParameter("action");
		String redirectTo = "";
		
		if(action == null){ action = ""; }
		
		System.out.println("Action: "+ action);
		
		switch (action) {
		case "": case "listProducts":
			System.out.println("getting list of products...");
			// Display the list of guests:
	        request.setAttribute("products", productDao.getAllPrducts());
	        redirectTo = "/products.jsp";
			break;
			
		case "addProduct":
			// add product
			ProductCategories category = new ProductCategories(request.getParameter("ProductCategory"));
			Products product = new Products(
					request.getParameter("ProductName"),
					request.getParameter("ProductSKU"),
					new BigDecimal(request.getParameter("ProductPrice")),
					request.getParameter("ProductManufacturer"),
					category);

	        productDao.create(product);
			// Display the list of products:
			request.setAttribute("products", productDao.getAllPrducts());
	        redirectTo = "/products.jsp";
			break;
			
		case "editProduct":
			// edit product
			HttpSession editSession = request.getSession();
			Products modifiedProduct = (Products) editSession.getAttribute("currentProduct");
			modifiedProduct.setName(request.getParameter("ProductName"));
			modifiedProduct.setProductSKU(request.getParameter("ProductSKU"));
			modifiedProduct.setListPrice(new BigDecimal(request.getParameter("ProductPrice")));
			modifiedProduct.setManufacturer(request.getParameter("ProductManufacturer"));
			modifiedProduct.setModifiedDate();
			modifiedProduct.getProductCategoryId().setName(request.getParameter("ProductCategory"));

	        productDao.update(modifiedProduct);
			// Display the list of products:
			request.setAttribute("products", productDao.getAllPrducts());
	        redirectTo = "/products.jsp";
			break;
			
		case "getProduct":
			try{
				int id = Integer.parseInt((String) request.getParameter("currentProductId"));
				// after we stored the product in the session variable we do not need the id anymore
				request.removeAttribute("currentProductId");
				HttpSession readSession = request.getSession();
				readSession.setAttribute("currentProduct", productDao.read(id));
				redirectTo = "/product.jsp";
			}catch (NumberFormatException ex){
				redirectTo = "/error404.jsp";
			}
			break;
			
		case "removeProduct":
			HttpSession removeSession = request.getSession();
			productDao.delete( (Products) removeSession.getAttribute("currentProduct") );
			// after we deleted the record we have to make sure we don't try to get it later
			removeSession.removeAttribute("currentProduct");
			redirectTo = "/products.jsp";
			break;
			
		default:
			break;
		}	
	 
		request.getRequestDispatcher(redirectTo).forward(request, response);
        
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		/*boolean transactionState = false;
		EntityManagerFactory factory = (EntityManagerFactory) getServletContext().getAttribute("entityManagerFactory");	
		EntityManager em = factory.createEntityManager();
		BigDecimal price = new BigDecimal((String) request.getParameter("ProductPrice"));
		
		ProductCategories category;
		try{
			TypedQuery<ProductCategories> query =
				      em.createQuery(
				    		  "SELECT c FROM ProductCategories c WHERE c.name = :name",
				    		  ProductCategories.class).setParameter("name", (String) request.getParameter("ProductCategory"));
			category = query.getSingleResult();
		} // there no such category so create a new one
		catch(NoResultException ex){
			category = new ProductCategories((String) request.getParameter("ProductCategory"));
			System.out.println("inside exception");
		}
	
		//ProductCategories category = new ProductCategories((String) request.getParameter("ProductCategory"));
		Products product1 = new Products(
				(String) request.getParameter("ProductName"), 
				(String) request.getParameter("ProductSKU"), 
				price,
				(String) request.getParameter("ProductManufacturer"),
				category);
		
 		try{
 			em.getTransaction().begin();
 			em.persist(product1);
 	        em.getTransaction().commit();
 	        transactionState = true;
 	        
 		} catch(ConstraintViolationException ex){
 			transactionState = true;
		} finally{
 			// if a transaction has failed we need to rollback
             if (em.getTransaction().isActive()){
                 em.getTransaction().rollback();
                 transactionState = false;
             }
 			em.close();
 		} 

		// store the dynamic data in the request
		request.setAttribute("transactionState", transactionState);
		// redirect with the new dynamic data
		request.getRequestDispatcher("jsp/AddProduct.jsp").forward(request, response);*/
		
		ProductCategories category = new ProductCategories("guitars");
		Products product = new Products("Gibson", "fafafaf", new BigDecimal("22"), "gagaga", category);
		
		// Handle a new guest:
       // String name = request.getParameter("name");
        //if (name != null)
            productDao.create(product);
 
        // Display the list of guests:
        doGet(request, response);
	}

}
