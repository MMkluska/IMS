package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RequestTest {

	Long id = 1L;
	Long orderId = 1L;
	Long itemId = 1L;
	Long quantity = 2L;
	Double orderPrice = 10.0D;

	private Request test = new Request(id, orderId, itemId, quantity);
	private Request cost = new Request(orderPrice);

	@Test
	public void testGetId() {
		assertEquals(id, test.getId(), 0);

	}

	@Test
	public void testGetOrderId() {
		assertEquals(orderId, test.getOrderId(), 0);

	}

	@Test
	public void testGetItemId() {
		assertEquals(itemId, test.getItemId(), 0);

	}

	@Test
	public void testGetQuantity() {
		assertEquals(quantity, test.getQuantity(), 0);

	}

	@Test
	public void testGetOrderPrice() {
		assertEquals(orderPrice, cost.getOrderPrice(), 1);
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testConstructor() {
		Request cons1 = new Request(2L, 5L, 10L);
		Request cons2 = new Request(1L, 3L, 20L, 5L);	
		Request cons3 = new Request(30.0);
	}

	@Test
	public void testToString() {
		assertEquals("Request ID: 1 Order ID: 1 Item ID: 1 Quantity: 2", test.toString());
	}

	@Test
	public void testToStringCost() {
		assertEquals("Total price is : 10.0", cost.toStringCost());
	}
}
