package businessTier.DAOs;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import busineesTier.models.Products;
 
@Stateless
public class ProductDAO {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
 
    // Stores a new product:
    public void create(Products product) {
        em.persist(product);
    }
    
    // updates an existing product:
    public void update(Products product) {
        em.merge(product);
    }
    
    // updates an existing product:
    public void delete(Products product) {
    	
    	// to delete an object it must be in the persistent context....
    	// if it's in context:
    	if( em.contains(product) ){ em.remove(product); }
    	// if it's not in the context, we first fetch it
    	else{ em.remove(em.find(Products.class, product.getId())); }
    	
    	//em.remove(em.contains(product) ? product : em.merge(product));
    }
 
    // Retrieves all the products:
    public List<Products> getAllPrducts() {
        TypedQuery<Products> query = em.createQuery(
            "SELECT g FROM Products g ORDER BY g.id", Products.class);
        return query.getResultList();
    }
    
    // Retrieves one product:
    public Products read(int id) {
        return em.find(Products.class, id);
    }
}
