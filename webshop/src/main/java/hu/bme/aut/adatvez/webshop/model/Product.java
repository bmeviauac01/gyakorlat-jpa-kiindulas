package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PRODUCT database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p"),
	@NamedQuery(name="Product.findMostExpensive", 
	query="SELECT p FROM Product p "
			+ "WHERE p.price IN (SELECT MAX(p2.price) FROM Product p2)")
})
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal stock;

	private String name;

	private double price;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(mappedBy="product")
	private List<Orderitem> orderitems;

	//bi-directional many-to-one association to Vat
	@ManyToOne
	@JoinColumn(name="VATID")
	private Vat vat;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CATEGORYID")
	private Category category;

	public Product() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getStock() {
		return this.stock;
	}

	public void setStock(BigDecimal stock) {
		this.stock = stock;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Orderitem addOrderitem(Orderitem orderitem) {
		getOrderitems().add(orderitem);
		orderitem.setProduct(this);

		return orderitem;
	}

	public Orderitem removeOrderitem(Orderitem orderitem) {
		getOrderitems().remove(orderitem);
		orderitem.setProduct(null);

		return orderitem;
	}

	public Vat getVat() {
		return this.vat;
	}

	public void setVat(Vat vat) {
		this.vat = vat;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}