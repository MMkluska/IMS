package com.qa.ims.persistence.dao;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Request;
import com.qa.ims.utils.DBUtils;

public class RequestDAOExceptionTest {
	private final RequestDAO DAO = new RequestDAO();
	
	@Before
	public void setup() {
		DBUtils.connect("Fail");
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	
	@Test
	public void testCreate() {
		final Request created = new Request(1L, 15L, 1L);
		assertEquals(null, DAO.create(created));
		
	}

	@Test
	public void testReadAll() {
		List<Request> expected = new ArrayList<>();
		expected.add(new Request(1L,1L, 10L));
	
		assertEquals(new ArrayList<>(), DAO.readAll());
	}

	@Test
	public void testReadLatest() {

		assertEquals(null, DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
	
		assertEquals(null, DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Request updated = new Request(1L, 1L, 10L);
	
		assertEquals(null, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		
		assertEquals(0, DAO.delete(1));
	}
	
	@Test
	public void testDeleteProduct() {
		
		assertEquals(0, DAO.delete(1));
	}
	
	@Test
	public void testTotalPrice() {
		final Request created = new Request(1L, 1L, 1L);
	
		assertEquals(null, DAO.totalPrice(1L));
		
	}
	
	
	}