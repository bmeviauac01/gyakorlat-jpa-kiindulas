package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CUSTOMER database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String bankaccount;

	private String email;

	private String login;

	private String name;

	private String password;

	//bi-directional many-to-one association to Customersite
	@ManyToOne
	@JoinColumn(name="MAINCUSTOMERSITE")
	private Customersite customersite;

	//bi-directional many-to-one association to Customersite
	@OneToMany(mappedBy="customer")
	private List<Customersite> customersites;

	public Customer() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBankaccount() {
		return this.bankaccount;
	}

	public void setBankaccount(String bankaccount) {
		this.bankaccount = bankaccount;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customersite getCustomersite() {
		return this.customersite;
	}

	public void setCustomersite(Customersite customersite) {
		this.customersite = customersite;
	}

	public List<Customersite> getCustomersitees() {
		return this.customersites;
	}

	public void setCustomersitees(List<Customersite> customersites) {
		this.customersites = customersites;
	}

	public Customersite addCustomersite(Customersite customersite) {
		getCustomersitees().add(customersite);
		customersite.setCustomer(this);

		return customersite;
	}

	public Customersite removeCustomersite(Customersite customersite) {
		getCustomersitees().remove(customersite);
		customersite.setCustomer(null);

		return customersite;
	}

}