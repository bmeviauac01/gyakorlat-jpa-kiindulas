package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the INVOICEITEM database table.
 * 
 */
@Entity
@NamedQuery(name="Invoiceitem.findAll", query="SELECT i FROM Invoiceitem i")
public class Invoiceitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private BigDecimal amount;

	private String name;

	private double price;

	private BigDecimal vatpercentage;

	//bi-directional many-to-one association to Invoice
	@ManyToOne
	@JoinColumn(name="INVOICEID")
	private Invoice invoice;

	//bi-directional many-to-one association to Orderitem
	@ManyToOne
	@JoinColumn(name="ORDERITEMID")
	private Orderitem orderitem;

	public Invoiceitem() {
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

	public BigDecimal getVatpercentage() {
		return this.vatpercentage;
	}

	public void setVatpercentage(BigDecimal vatpercentage) {
		this.vatpercentage = vatpercentage;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public Orderitem getOrderitem() {
		return this.orderitem;
	}

	public void setOrderitem(Orderitem orderitem) {
		this.orderitem = orderitem;
	}

}