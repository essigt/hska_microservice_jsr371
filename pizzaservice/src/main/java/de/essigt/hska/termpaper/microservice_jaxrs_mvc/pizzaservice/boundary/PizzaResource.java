package de.essigt.hska.termpaper.microservice_jaxrs_mvc.pizzaservice.boundary;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.essigt.hska.termpaper.microservice_jaxrs_mvc.pizzaservice.entity.Pizza;


@Path("pizza")
@Produces(MediaType.APPLICATION_JSON)
public class PizzaResource {

	@Inject
	PizzaService ps;


	@GET
	public List<Pizza> findAll() {
		List<Pizza> all = ps.findAll();
		Logger.getLogger("PizzaResource").log(Level.INFO, "Size: " + all.size());

		return all;
	}
}
