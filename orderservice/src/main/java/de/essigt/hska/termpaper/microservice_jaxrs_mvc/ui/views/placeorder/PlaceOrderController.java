package de.essigt.hska.termpaper.microservice_jaxrs_mvc.ui.views.placeorder;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.CsrfValid;
import javax.mvc.binding.BindingResult;
import javax.validation.Valid;
import javax.validation.executable.ExecutableType;
import javax.validation.executable.ValidateOnExecution;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import de.essigt.hska.termpaper.microservice_jaxrs_mvc.business.pizza.boundary.PizzaService;
import de.essigt.hska.termpaper.microservice_jaxrs_mvc.business.pizza.entity.Pizza;


@Controller
@Path("placeorder")
public class PlaceOrderController {

	@Inject
	BindingResult bindingResult;

	@Inject
	Models models;

	@Inject
	PizzaService ps;


	@GET
	public String show() {
		ps.findAll();
		models.put("pizzas", ps.findAll());

		return "placeorder.jsp";
	}


	@POST
	@CsrfValid
	@ValidateOnExecution(type = ExecutableType.NONE)
	public String post(@Valid @BeanParam PlaceOrderForm orderForm) {

		if (bindingResult.isFailed()) {
			models.put("bindingResult", bindingResult);
			return "placeorder.jsp";
		}

		models.put("amount", orderForm.getAmount());

		Pizza pizza = null;
		for (Pizza p : ps.findAll()) {
			if (p.getId() == orderForm.getId()) {
				pizza = p;
				break;
			}
		}
		models.put("name", pizza != null ? pizza.getName() : "");

		return "orderplaced.jsp";
	}

}
