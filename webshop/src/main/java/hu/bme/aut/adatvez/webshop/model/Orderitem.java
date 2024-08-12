package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ORDERITEM database table.
 * 
 */
@Entity
@NamedQuery(name="Orderitem.findAll", query="SELECT o FROM Orderitem o")
public class Orderitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal amount;

	private double price;

	//bi-directional many-to-one association to Invoiceitem
	@OneToMany(mappedBy="orderitem")
	private List<Invoiceitem> invoiceitems;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="ORDERID")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="PRODUCTID")
	private Product product;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="STATUSID")
	private Status status;

	public Orderitem() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Invoiceitem> getInvoiceitems() {
		return this.invoiceitems;
	}

	public void setInvoiceitems(List<Invoiceitem> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}

	public Invoiceitem addInvoiceitem(Invoiceitem invoiceitem) {
		getInvoiceitems().add(invoiceitem);
		invoiceitem.setOrderitem(this);

		return invoiceitem;
	}

	public Invoiceitem removeInvoiceitem(Invoiceitem invoiceitem) {
		getInvoiceitems().remove(invoiceitem);
		invoiceitem.setOrderitem(null);

		return invoiceitem;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}