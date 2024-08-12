package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.List;


/**
 * The persistent class for the INVOICEISSUER database table.
 * 
 */
@Entity
@NamedQuery(name="Invoiceissuer.findAll", query="SELECT i FROM Invoiceissuer i")
public class Invoiceissuer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String bankaccount;

	private String city;

	private String name;

	private String street;

	private String taxidentifier;

	private String zipcode;

	//bi-directional many-to-one association to Invoice
	@OneToMany(mappedBy="invoiceissuer")
	private List<Invoice> invoices;

	public Invoiceissuer() {
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

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTaxidentifier() {
		return this.taxidentifier;
	}

	public void setTaxidentifier(String taxidentifier) {
		this.taxidentifier = taxidentifier;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public List<Invoice> getInvoices() {
		return this.invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public Invoice addInvoice(Invoice invoice) {
		getInvoices().add(invoice);
		invoice.setInvoiceissuer(this);

		return invoice;
	}

	public Invoice removeInvoice(Invoice invoice) {
		getInvoices().remove(invoice);
		invoice.setInvoiceissuer(null);

		return invoice;
	}

}