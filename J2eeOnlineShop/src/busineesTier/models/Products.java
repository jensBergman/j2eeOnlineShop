package busineesTier.models;

import java.io.Serializable;
import java.lang.String;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Products
 *
 */
@Entity
public class Products implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	// product name
	@Column(unique=true, nullable=false, length=50)
	private String name;
	// unique product identifier, e.g. product number
	@Column(unique=true, nullable=false, length=25)
	private String productSKU;
	//Selling price.
	@Column(nullable=false, precision=10, scale=2) // 2 decimals
	private BigDecimal listPrice;
	// Date and time the row was last updated.
	@Column(nullable=false)
	private Calendar modifiedDate;
	@Column(nullable=false, length=50)
	private String manufacturer;
	private static final long serialVersionUID = 1L;

//	extend for maintenance
//	/*
//	 * 0 = Product is not a salable item.
//	 * 1 = Product is salable.
//	 */
//	@Column(nullable=false)
//	private boolean finishedGoodsFlag;
//	// minimum stock amount before
//	@Column(nullable=false)
//	private int safetyStockLevel;
//	// Inventory level that triggers a purchase order or work order.
//	@Column(nullable=false)
//	private int reorderPoint;
//	//Standard cost of the product.
//	@Column(nullable=false)
//	private float standardCost;
//	//Product size.
//	@Column(nullable=true)
//	private String size;
//	// Unit of measure for Size column.
//	@Column(nullable=true)
//	private String sizeUnit;
//	//Product weight.
//	@Column(nullable=true)
//	private float weight;
//	//Unit of measure for weight column.
//	@Column(nullable=true)
//	private String weightUnit;
//	// Number of days required to manufacture the product.
//	@Column(nullable=false)
//	private int daysToManufacturing;	
//	// Date the product was available for sale.
//	@Column(nullable=false)
//	private Calendar sellStartDate;
//	// Date the product was no longer available for sale.
//	@Column(nullable=true)
//	private Calendar sellEndDate;	

	
	// Product is a member of this product category. Foreign key to com.bergman.test.model.ProductCategories
	@ManyToOne(cascade = CascadeType.ALL) // CascadeType.PERSIST = when a product is persisted, then also persist/save productCategory
	private ProductCategories productCategory;

	public Products() {
		super();
	}  
	
	public Products(String name, String productSKU, BigDecimal listPrice, String manufacturer, ProductCategories productCategoryId) {
		super();
		// have the current time as a standard
		this.modifiedDate = Calendar.getInstance();
		this.name = name;
		this.productSKU = productSKU;
		this.listPrice = listPrice;
		this.manufacturer = manufacturer;
		this.productCategory = productCategoryId;
	}   

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", productSKU=" + productSKU + ", listPrice=" + listPrice
				+ ", modifiedDate=" + modifiedDate + ", manufacturer=" + manufacturer + ", productCategory="
				+ productCategory + "]";
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

	public String getProductSKU() {
		return this.productSKU;
	}

	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}

	public BigDecimal getListPrice() {
		return this.listPrice;
	}

	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}   

	public Calendar getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public ProductCategories getProductCategoryId() {
		return productCategory;
	}
	public void setProductCategoryId(ProductCategories productCategoryId) {
		this.productCategory = productCategoryId;
	}

	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	} 
	
//	public String getWeightUnit() {
//		return weightUnit;
//	}
//	public void setWeightUnit(String weightUnit) {
//		this.weightUnit = weightUnit;
//	}
//	
//	public boolean getFinishedGoodsFlag() {
//		return this.finishedGoodsFlag;
//	}
//
//	public void setFinishedGoodsFlag(boolean finishedGoodsFlag) {
//		this.finishedGoodsFlag = finishedGoodsFlag;
//	}   
//	public int getSafetyStockLevel() {
//		return this.safetyStockLevel;
//	}
//
//	public void setSafetyStockLevel(int safetyStockLevel) {
//		this.safetyStockLevel = safetyStockLevel;
//	}   
//	public int getReorderPoint() {
//		return this.reorderPoint;
//	}
//
//	public void setReorderPoint(int reorderPoint) {
//		this.reorderPoint = reorderPoint;
//	}   
//	public float getStandardCost() {
//		return this.standardCost;
//	}
//
//	public void setStandardCost(float standardCost) {
//		this.standardCost = standardCost;
//	}   
//
//	public String getSize() {
//		return this.size;
//	}
//
//	public void setSize(String size) {
//		this.size = size;
//	}   
//	public String getSizeUnit() {
//		return this.sizeUnit;
//	}
//
//	public void setSizeUnit(String sizeUnit) {
//		this.sizeUnit = sizeUnit;
//	}   
//	public float getWeight() {
//		return this.weight;
//	}
//
//	public void setWeight(float weight) {
//		this.weight = weight;
//	}   
//	public int getDaysToManufacturing() {
//		return this.daysToManufacturing;
//	}
//
//	public void setDaysToManufacturing(int daysToManufacturing) {
//		this.daysToManufacturing = daysToManufacturing;
//	}   
//	
  
//	public Calendar getSellStartDate() {
//		return this.sellStartDate;
//	}
//
//	public void setSellStartDate(Calendar sellStartDate) {
//		this.sellStartDate = sellStartDate;
//	}   
//	public Calendar getSellEndDate() {
//		return this.sellEndDate;
//	}
//
//	public void setSellEndDate(Calendar sellEndDate) {
//		this.sellEndDate = sellEndDate;
//	}   
}
