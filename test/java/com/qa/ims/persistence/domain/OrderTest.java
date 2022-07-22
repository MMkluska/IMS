package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderTest {
	Long id = 1L;
	Long customerId = 1L;

	private Order test = new Order(id, customerId);

	@Test
	public void testGetOrderId() {
		assertEquals(1L, test.getId(), 0);

	}

	@Test
	public void testGetCustomerId() {
		assertEquals(1L, test.getCustomerId(), 0);

	}

	@SuppressWarnings("unused")
	@Test
	public void testConstructor() {
		Order cons1 = new Order(2L);
		Order cons2 = new Order(2L, 2L);
	}

	@Test
	public void testToString() {
		assertEquals("Order ID: 1 Customer ID: 1", test.toString());
	}
}