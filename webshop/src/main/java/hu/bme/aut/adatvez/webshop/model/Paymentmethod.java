package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;


/**
 * The persistent class for the PAYMENTMETHOD database table.
 * 
 */
@Entity
@NamedQuery(name="Paymentmethod.findAll", query="SELECT p FROM Paymentmethod p")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "paymentMehodSP", 
			procedureName = "CreatePaymentMethod",
			parameters = {
			        @StoredProcedureParameter(mode = ParameterMode.IN, name = "Method", type = String.class),
	                @StoredProcedureParameter(mode = ParameterMode.IN, name = "Deadline", type = BigDecimal.class)
	        })	  
})
public class Paymentmethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	@NotNull
	private BigDecimal deadline;

	@NotEmpty
	private String method;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="paymentmethod")
	private List<Order> orders;

	public Paymentmethod() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getDeadline() {
		return this.deadline;
	}

	public void setDeadline(BigDecimal deadline) {
		this.deadline = deadline;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setPaymentmethod(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setPaymentmethod(null);

		return order;
	}

}