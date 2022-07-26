package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.RequestDAO;
import com.qa.ims.persistence.domain.Request;
import com.qa.ims.utils.Utils;

/**
 * Takes in request details for CRUD functionality
 *
 */
public class RequestController implements CrudController<Request> {

	public static final Logger LOGGER = LogManager.getLogger();

	private RequestDAO requestDAO;
	private Utils utils;

	public RequestController(RequestDAO requestDAO, Utils utils) {
		this.requestDAO = requestDAO;
		this.utils = utils;
	}

	/**
	 * Reads all requests to the logger
	 */
	@Override
	public List<Request> readAll() {
		List<Request> requests = requestDAO.readAll();
		for (Request request : requests) {
			LOGGER.info(request);
		}
		return requests;
	}

	/**
	 * Dead method, must be implemented from CrudController<>
	 */
	@Override
	public Request create() {
		return null;

	}

	/**
	 * Creates an request by taking in user input
	 */
	public Request create(Long orderId) {
		LOGGER.info("Please enter a product ID you wish to add: ");
		Long productId = utils.getLong();
		LOGGER.info("Please enter a quantity you wish to have: ");
		Long quantity = utils.getLong();
		Request request = requestDAO.create(new Request(orderId, productId, quantity));
		LOGGER.info("Item/s added.");

		return request;
	}

	/**
	 * Updates an existing request by taking in user input
	 */
	@Override
	public Request update() {

		LOGGER.info("Please enter ID of the order you would like to change");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter item ID");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter quantity");
		Long quantity = utils.getLong();
		Request request = requestDAO.update(new Request(orderId, itemId, quantity));
		LOGGER.info("Order Updated");
		return request;
	}

	/**
	 * Dead method, must be implemented from CrudController<>
	 */
	@Override
	public int delete() {
		return 0;
	}

	/**
	 * Deletes an existing request by the id of the order
	 * 
	 * @return
	 */
	public int delete(Long orderID) {
		LOGGER.info("Enter the item ID you would like to delete from order " + orderID + "?");
		Long productID = utils.getLong();
		return requestDAO.delete(orderID, productID);
	}

}
