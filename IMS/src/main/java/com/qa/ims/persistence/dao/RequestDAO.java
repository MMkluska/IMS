package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.qa.ims.persistence.domain.Request;
import com.qa.ims.utils.DBUtils;

public class RequestDAO implements Dao<Request> {

	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Request modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long requestId = resultSet.getLong("request_id");
		Long orderId = resultSet.getLong("fk_order_id");
		Long itemId = resultSet.getLong("fk_item_id");
		Long quantity = resultSet.getLong("quantity");
		return new Request(requestId, orderId, itemId, quantity);
	}

	/**
	 * Separate model for printing out total price
	 */
	public Request modelFromResultSet2(ResultSet resultSet) throws SQLException {
		Double orderPrice = resultSet.getDouble("Total Price");
		return new Request(orderPrice);
	}

	/**
	 * Reads all requests from the database
	 * 
	 * @return A list of requests
	 */
	@Override
	public List<Request> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM Requests");) {
			List<Request> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	/**
	 * Reads last request from the database
	 * 
	 * @return An order
	 */
	public Request readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM Requests ORDER BY request_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Calculates a total price for a specific order ID
	 * 
	 * @return A total price
	 */
	public Request totalPrice(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT sum(item_value*quantity) as `Total Price` FROM orders o "
								+ "LEFT JOIN requests r ON o.order_id = r.fk_order_id "
								+ "LEFT JOIN items i ON i.item_id = r.fk_item_id WHERE o.order_id = ?");) {
			statement.setLong(1, orderId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet2(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a request in the database
	 * 
	 * @param request id - takes in an request object. request_id will be ignored
	 */
	@Override
	public Request create(Request request) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"INSERT INTO Requests(fk_order_id, fk_item_id, quantity) VALUES (?, ?, ?)");) {
			statement.setLong(1, request.getOrderId());
			statement.setLong(2, request.getItemId());
			statement.setLong(3, request.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Request read(Long requestId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM Requests WHERE request_id = ?");) {
			statement.setLong(1, requestId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a request in the database
	 * 
	 * @param request - takes in a request object, the request_id field will be used
	 *                to update that request in the database
	 * @return
	 */
	@Override
	public Request update(Request request) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement(
						"UPDATE Requests SET fk_order_id = ?, fk_item_id = ?, quantity = ? WHERE request_id = ?");) {
			statement.setLong(1, request.getOrderId());
			statement.setLong(2, request.getItemId());
			statement.setLong(3, request.getQuantity());
			statement.setLong(4, request.getId());
			statement.executeUpdate();
			return read(request.getId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Dead method, must be implemented from Dao<>
	 */
	@Override
	public int delete(long requestId) {
		return 0;
	}

	/**
	 * Deletes a request/s in the database
	 * 
	 * @param orderId - fk_order_id of the request
	 * @param itemId  - fk_item_id of the request
	 */
	public int delete(Long orderId, Long itemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("DELETE FROM Requests WHERE fk_order_id = ? and fk_item_id = ?");) {
			statement.setLong(1, orderId);
			statement.setLong(2, itemId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

}
