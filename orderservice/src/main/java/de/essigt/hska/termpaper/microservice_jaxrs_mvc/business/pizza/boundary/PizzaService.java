package de.essigt.hska.termpaper.microservice_jaxrs_mvc.business.pizza.boundary;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.essigt.hska.termpaper.microservice_jaxrs_mvc.business.pizza.entity.Pizza;


/**
 * 
 * @author essigt
 *
 */
@Stateless
public class PizzaService {

	private Client client;
	private WebTarget taget;


	// TODO Inject via Env
	private String baseUrl = "http://pizzaservice:8080/pizzaservice";


	@PostConstruct
	private void init() {
		client = ClientBuilder.newClient();
		taget = this.client.target(baseUrl + "/resources/pizza");
	}


	public List<Pizza> findAll() {
		List<Pizza> list = taget.request(MediaType.APPLICATION_JSON_TYPE)
				.get(Response.class)
				.readEntity(new GenericType<List<Pizza>>() {
				});

		return list;
	}
}
