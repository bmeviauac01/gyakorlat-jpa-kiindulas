package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the VAT database table.
 * 
 */
@Entity
@NamedQuery(name="Vat.findAll", query="SELECT v FROM Vat v")
public class Vat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal percentage;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="vat")
	private List<Product> products;

	public Vat() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getPercentage() {
		return this.percentage;
	}

	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setVat(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setVat(null);

		return product;
	}

}