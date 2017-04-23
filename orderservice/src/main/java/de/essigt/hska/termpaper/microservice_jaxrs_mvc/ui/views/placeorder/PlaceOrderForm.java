package de.essigt.hska.termpaper.microservice_jaxrs_mvc.ui.views.placeorder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;


/**
 * 
 * @author essigt
 *
 */
public class PlaceOrderForm {

	@NotNull
	@FormParam("id")
	private int id;

	@NotNull
	@Min(1)
	@FormParam("amount")
	private int amount;

	@FormParam("comment")
	private String comment;


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


}
