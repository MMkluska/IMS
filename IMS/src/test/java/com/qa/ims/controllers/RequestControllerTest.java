package com.qa.ims.controllers;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.RequestController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.RequestDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Request;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class RequestControllerTest {

	@Mock
	private Utils utils;

	@Mock
	private RequestDAO dao;

	@InjectMocks
	private RequestController controller;


	@Test
	public void testReadAll() {
		List<Request> requests = new ArrayList<>();
		requests.add(new Request(1L, 1L, 1L));

		Mockito.when(dao.readAll()).thenReturn(requests);

		assertEquals(requests, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

//	@Test
//	public void testCreate() {
//		final Long itemId = 1L, quantity = 1L;
//		final Request created = new Request(1L,1L,1L);
//
//		Mockito.when(utils.getLong()).thenReturn(itemId, quantity);
//		Mockito.when(dao.create(created)).thenReturn(created);
//
//		assertEquals(created, controller.create());
//
//		Mockito.verify(utils, Mockito.times(2)).getString();
//		Mockito.verify(dao, Mockito.times(1)).create(created);
//	}
//
//	
//	@Test
//	public void testUpdate() {
//		Customer updated = new Customer(1L, "chris", "perrins");
//
//		Mockito.when(this.utils.getLong()).thenReturn(1L);
//		Mockito.when(this.utils.getString()).thenReturn(updated.getFirstName(), updated.getLastName());
//		Mockito.when(this.dao.update(updated)).thenReturn(updated);
//
//		assertEquals(updated, this.controller.update());
//
//		Mockito.verify(this.utils, Mockito.times(1)).getLong();
//		Mockito.verify(this.utils, Mockito.times(2)).getString();
//		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
//	}
//
//	@Test
//	public void testDelete() {
//		final long ID = 1L;
//
//		Mockito.when(utils.getLong()).thenReturn(ID);
//		Mockito.when(dao.delete(ID)).thenReturn(1);
//
//		assertEquals(1L, this.controller.delete());
//
//		Mockito.verify(utils, Mockito.times(1)).getLong();
//		Mockito.verify(dao, Mockito.times(1)).delete(ID);
//	}
//
}
