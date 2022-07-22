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

import com.qa.ims.controller.OrderController;
import com.qa.ims.controller.RequestController;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
	@Mock 
	private Utils utils;

	@Mock
	private OrderDAO dao;

	@InjectMocks
	private OrderController controller;
	@InjectMocks
	private RequestController requestController;
	
//	@Test
//	public void testCreateY() {
//		final Long id = 1L;
//		final String choice = "yes";
//		final Order created = new Order(id);
//		final Request created1 = new Request(1L, 1L, 1L);
//		final Long itemId = 1L;
//		final Long quantity = 1L;
//		final String choice2 = "no";
// 
//		Mockito.when(utils.getLong()).thenReturn(id);
//		Mockito.when(utils.getString()).thenReturn(choice);
//		Mockito.when(dao.create(created)).thenReturn(created);
//		
//		Mockito.when(utils.getLong()).thenReturn(itemId);
//		Mockito.when(utils.getLong()).thenReturn(quantity);
//		Mockito.when(utils.getString()).thenReturn(choice2);
//		Mockito.when(requestController.create()).thenReturn(created1);
//
//		assertEquals(created, this.controller.create());
//
//		Mockito.verify(utils, Mockito.times(1)).getLong();
//		Mockito.verify(utils, Mockito.times(1)).getString();
//		Mockito.verify(dao, Mockito.times(1)).create(created);
//	} 
	
//	@Test
//	public void testCreate() {
//		final Long customerId = 1L, orderId = 2L;
//		final Order created = new Order(customerId);
//		final OrderItem created1 = new OrderItem(orderId, 10L, 1L);
//		final String adding = "yes";
//		final Double cost = 20.0;
//
//		Mockito.when(utils.getLong()).thenReturn(customerId, orderId);
//		Mockito.when(dao.create(created)).thenReturn(created);
//
//		Mockito.when(utils.getLong()).thenReturn(orderId);
//		Mockito.when(dao.create(created)).thenReturn(created);
//		Mockito.when(itemController.getOrderId()).thenReturn(orderId);
//		Mockito.when(itemController.createNew()).thenReturn(created1);
//
//		assertEquals(created, controller.create());
//
//		Mockito.verify(utils, Mockito.times(2)).getLong();
//		Mockito.verify(dao, Mockito.times(1)).create(created);
//	}
	
	@Test
	public void testReadAllOrders() {
		final String choice = "orders";
		List<Order> orders = new ArrayList<>();
		orders.add(new Order(1L, 1L));

		Mockito.when(utils.getString()).thenReturn(choice);
		Mockito.when(dao.readAll()).thenReturn(orders);

		assertEquals(orders, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void testReadAllDefault() {
		final String choice = "wrong";

		Mockito.when(utils.getString()).thenReturn(choice);
		
		assertEquals(null, controller.readAll());
	}
	
	@Test
	public void testCreateN() {
		final Long id = 1L;
		final String choice = "n";
		final Order created = new Order(id);
 
		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(utils.getString()).thenReturn(choice);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, this.controller.create());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	} 
	

	
//	@Test
//	public void testReadAllReq() {
//		final String choice = "requests";
//		List<Request> request = new ArrayList<>();
//		request.add(new Request(1L,1L, 1L));
//
//		Mockito.when(utils.getString()).thenReturn(choice);
//		Mockito.when(requestController.readAll()).thenReturn(request);
//
//		assertEquals(request, controller.readAll());
//
//		Mockito.verify(dao, Mockito.times(1)).readAll();
//	}

	@Test
	public void testUpdateCustomer() {
		
		final String choice = "customer";
		final Long orderId = 1L;
		final Long id = 1L;
		Order updated = new Order(orderId, id);

		Mockito.when(this.utils.getString()).thenReturn(choice); 
		Mockito.when(this.utils.getLong()).thenReturn(orderId);
		Mockito.when(this.dao.update(updated)).thenReturn(updated);
		
		assertEquals(updated, this.controller.update()); 

		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	} 

	@Test
	public void testUpdateDefault() {
		final String choice = "wrong";

		Mockito.when(utils.getString()).thenReturn(choice);
		
		assertEquals(null, controller.readAll());
	}
	
	
	@Test 
	public void testDeleteOrder() {
		
		final Long id = 1L;
		final String choice = "order";
	
		
		Mockito.when(utils.getLong()).thenReturn(id);
		Mockito.when(utils.getString()).thenReturn(choice);
		Mockito.when(dao.delete(id)).thenReturn(1);
	

		assertEquals(0L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(dao, Mockito.times(1)).delete(id);
	}
		

}
