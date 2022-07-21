package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.RequestDAO;
import com.qa.ims.persistence.domain.Request;
import com.qa.ims.utils.Utils;

/**
 * Takes in customer details for CRUD functionality
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
	 * Reads all customers to the logger
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
	 * Creates an request by taking in user input
	 */
	@Override
	public Request create() {
		return null;
	
	}

	public Request create(Long orderId) {
		LOGGER.info("Please enter a product ID you wish to add");
		Long productId = utils.getLong();
		LOGGER.info("Please enter a quantity you wish to have");
		Long quantity = utils.getLong();
		Request request = requestDAO.create(new Request(orderId, productId, quantity));
		LOGGER.info("Item/s Added.");
		
	

		return request;
	}

	/**
	 * Updates an existing request by taking in user input
	 */
//	@Override
//	public Request update() {
//		LOGGER.info("Please enter the ID of the request you would like to update");
//		Long id = utils.getLong();
//		LOGGER.info("Please enter an order ID");
//		Long orderId = utils.getLong();
//		LOGGER.info("Please enter an item ID");
//		Long itemId = utils.getLong();
//		LOGGER.info("Please enter quantity");
//		Long quantity = utils.getLong();
//		Request request = requestDAO.update(new Request(id, orderId, itemId, quantity));
//		LOGGER.info("Request Updated");
//		return request;
//	}
//	
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
	 * Deletes an existing request by the id of the request
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the request you would like to delete");
		Long id = utils.getLong();
		return requestDAO.delete(id);
	}

	

}
