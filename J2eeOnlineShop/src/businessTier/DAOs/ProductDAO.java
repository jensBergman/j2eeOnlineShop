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
 
    // Stores a new guest:
    public void persist(Products product) {
        em.persist(product);
    }
 
    // Retrieves all the guests:
    public List<Products> getAllPrducts() {
        TypedQuery<Products> query = em.createQuery(
            "SELECT g FROM Products g ORDER BY g.id", Products.class);
        return query.getResultList();
    }
}
