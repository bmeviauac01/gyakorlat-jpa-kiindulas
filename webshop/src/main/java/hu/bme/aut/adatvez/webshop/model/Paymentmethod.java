package hu.bme.aut.adatvez.webshop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


/**
 * The persistent class for the PAYMENTMETHOD database table.
 * 
 */
@Entity
@NamedQuery(name="Paymentmethod.findAll", query="SELECT p FROM Paymentmethod p")
@NamedStoredProcedureQueries({
	@NamedStoredProcedureQuery(name = "createMethodSP", 
			procedureName = "CreateNewPaymentMethod",
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