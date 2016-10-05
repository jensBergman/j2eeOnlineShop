package webTier.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
/*		boolean transactionState = false;
		// get search query
		String productQuery = request.getParameter("product");
		
		EntityManagerFactory factory = (EntityManagerFactory) getServletContext().getAttribute("entityManagerFactory");				
		EntityManager em = factory.createEntityManager();
 		
		List<Products> productList = new ArrayList<Products>();;
		try{
			TypedQuery<Products> query =
				      em.createQuery(
				    		  "SELECT p FROM Products p "
				    		  + "WHERE p.name = :name OR p.productSKU = :sku OR p.manufacturer = :manufacturer",
				    		  Products.class).
				      setParameter("name", productQuery).
				      setParameter("sku", productQuery).
				      setParameter("manufacturer", productQuery);
			
			productList = query.getResultList();
			transactionState = true;			
		} // there no such category so create a new one
		catch(NoResultException ex){
			transactionState = false;
		} finally {
			em.close();
		}
	
		// store the dynamic data in the request
		request.setAttribute("products", productList);
		// redirect with the new dynamic data
		request.getRequestDispatcher("jsp/products.jsp").forward(request, response);*/
		
		String action = request.getParameter("action");
		if(action!=null && action.equals("getProduct")){
			System.out.println("Id: "+ request.getParameter("currentId"));
		}
	 
        // Display the list of guests:
        request.setAttribute("products", productDao.getAllPrducts());
        request.getRequestDispatcher("/products.jsp").forward(request, response);
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
            productDao.persist(product);
 
        // Display the list of guests:
        doGet(request, response);
	}

}
