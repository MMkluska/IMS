package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CustomerTest {
	Long Id = 2L;
	private Customer test = new Customer(Id, "first_name", "last_name");

	@Test
	public void testGetLastName() {
		assertEquals("last_name", test.getLastName());

	}

	@Test
	public void testGetFirstName() {
		assertEquals("first_name", test.getFirstName());

	}

	@Test
	public void testGetId() {
		assertEquals(2L, test.getId(), 0);

	}

	@SuppressWarnings("unused")
	@Test
	public void testConstructor() {
		Customer cust1 = new Customer("Eva", "Green");
		Customer cust2 = new Customer(1231L, "John", "Smith");
	}

	@Test
	public void testToString() {
		assertEquals("Customer ID: 2 First name: first_name Last name: last_name", test.toString());
	}
}