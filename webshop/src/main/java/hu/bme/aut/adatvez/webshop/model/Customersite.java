package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CUSTOMERSITE database table.
 * 
 */
@Entity
@NamedQuery(name="Customersite.findAll", query="SELECT p FROM Customersite p")
public class Customersite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String city;

	private String fax;

	private String street;

	private String tel;

	private String zip;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="customersite")
	private List<Customer> customers;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="customersite")
	private List<Order> orders;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="CUSTOMERID")
	private Customer customer;

	public Customersite() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZipcode(String zip) {
		this.zip = zip;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setCustomersite(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setCustomersite(null);

		return customer;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setCustomersite(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setCustomersite(null);

		return order;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}