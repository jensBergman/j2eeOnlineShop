package busineesTier.models;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProductCategories
 *
 */
@Entity

public class ProductCategories implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(unique=true, nullable=false, length=50)
	private String name;
	private static final long serialVersionUID = 1L;

	public ProductCategories() {
		super();
	}  
	
	public ProductCategories(String name) {
		super();
		this.name = name;
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
