package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.RequestDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in Order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils = new Utils();
	private RequestDAO requestDAO = new RequestDAO();
	RequestController reqCont = new RequestController(requestDAO, utils);

	public OrderController(OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}

	/**
	 * Reads all Orders or Requests to the logger
	 */
	@Override
	public List<Order> readAll() {
		LOGGER.info(
				"Do you want to view orders database, requests database or total price of specific order? Orders/Requests/Price");
		String choose = utils.getString();
		switch (choose.toLowerCase()) {

		case "orders":
			List<Order> orders = orderDAO.readAll();
			for (Order order : orders) {
				LOGGER.info(order);
			}
			return orders;

		case "requests":

			reqCont.readAll();
			return null;

		case "price":

			LOGGER.info("Please enter an order ID");
			Long orderId = utils.getLong();
			LOGGER.info(requestDAO.totalPrice(orderId).toStringCost());
			return null;

		default:
			LOGGER.info("Wrong operator!");
			break;
		}

		return null;
	}

	/**
	 * Creates an order by taking in user input
	 */
	@Override
	public Order create() {
		boolean addItem = true;
		LOGGER.info("Please enter a customer ID");
		Long customerId = utils.getLong();
		Order order = orderDAO.create(new Order(customerId));
		while (addItem) {
			LOGGER.info("Do you want to add an item to the order? Yes?");
			String choice = utils.getString();
			if (choice.toLowerCase().equals("yes")) {
				reqCont.create(order.getId());
			} else {
				addItem = false;
			}
		}
		LOGGER.info("Order created");
		return order;
	}

	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {

		LOGGER.info("Would you like to update customer ID or add item to an order? Customer/Item");
		String choiceSwitch = utils.getString();
		LOGGER.info("Please enter the ID of the order you would like to update");
		Long id = utils.getLong();

		switch (choiceSwitch.toLowerCase()) {
		case "customer":

			LOGGER.info("Please enter a customer ID");
			long customerId = utils.getLong();
			Order order = orderDAO.update(new Order(id, customerId));
			LOGGER.info("Order Updated");
			return order;

		case "item":
			boolean addItem = true;
			do {
				reqCont.create(id);

				LOGGER.info("Do you want to add an item to the order? Yes?");
				String choice = utils.getString();
				if (choice.toLowerCase().equals("yes")) {
					addItem = true;
				} else {
					addItem = false;
				}

			} while (addItem);
			return null;
		default:
			LOGGER.info("Wrong operator!");
			break;
		}
		return null;
	}

	/**
	 * Deletes an existing order by the id of the order
	 * 
	 * @return
	 */
		
	@Override
	public int delete() {
		LOGGER.info("Please enter your order ID");
		Long id = utils.getLong();
		LOGGER.info("Would you like to delete an item from an order or an entire order? Item/Order");
		String choice = utils.getString();
		
		switch (choice.toLowerCase()) {
		
		case "item":
			
			reqCont.delete(id);
			LOGGER.info("Item deleted"); 
			break;
			
		case "order":
			
			orderDAO.delete(id);
			LOGGER.info("Order deleted"); 
			break;
			
		default:
			LOGGER.info("Wrong operator!");
			break;
		}
		return 0;
		
			
}

}
