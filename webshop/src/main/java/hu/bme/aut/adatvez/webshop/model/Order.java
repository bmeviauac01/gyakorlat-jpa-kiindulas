package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the "ORDER" database table.
 * 
 */
@Entity
@Table(name="\"ORDER\"")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name="\"Date\"")
	private Date date;

	@Temporal(TemporalType.DATE)
	private Date deadline;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="order")
	private List<Invoice> invoices;

	//bi-directional many-to-one association to Customersite
	@ManyToOne
	@JoinColumn(name="CUSTOMERSITEID")
	private Customersite customersite;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="STATUSID")
	private Status status;

	//bi-directional many-to-one association to Paymentmethod
	@ManyToOne
	@JoinColumn(name="PAYMENTMETHODID")
	private Paymentmethod paymentmethod;

	//bi-directional many-to-one association to Orderitem
	@OneToMany(mappedBy="order")
	private List<Orderitem> orderitems;

	public Order() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setOrder(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setOrder(null);

		return invoice;
	}

	public Customersite getCustomersite() {
		return this.customersite;
	}

	public void setCustomersite(Customersite customersite) {
		this.customersite = customersite;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Paymentmethod getPaymentmethod() {
		return this.paymentmethod;
	}

	public void setPaymentmethod(Paymentmethod paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	public List<Orderitem> getOrderitems() {
		return this.orderitems;
	}

	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}

	public Orderitem addOrderitem(Orderitem orderitem) {
		getOrderitems().add(orderitem);
		orderitem.setOrder(this);

		return orderitem;
	}

	public Orderitem removeOrderitem(Orderitem orderitem) {
		getOrderitems().remove(orderitem);
		orderitem.setOrder(null);

		return orderitem;
	}

}