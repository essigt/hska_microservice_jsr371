package de.essigt.hska.termpaper.microservice_jaxrs_mvc.pizzaservice.boundary;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.essigt.hska.termpaper.microservice_jaxrs_mvc.pizzaservice.entity.Pizza;


@Stateless
public class PizzaService {

	@PersistenceContext(unitName = "h2")
	private EntityManager em;


	public List<Pizza> findAll() {
		return em.createNamedQuery(Pizza.FIND_ALL, Pizza.class).getResultList();
	}
}
