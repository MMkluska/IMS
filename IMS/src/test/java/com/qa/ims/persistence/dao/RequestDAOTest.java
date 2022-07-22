package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Request;
import com.qa.ims.utils.DBUtils;

public class RequestDAOTest {
	private final RequestDAO DAO = new RequestDAO();

	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Request created = new Request(2L, 1L, 1L, 2L);
		assertEquals(created, DAO.create(created));

	}

	@Test
	public void testReadAll() {
		List<Request> expected = new ArrayList<>();
		expected.add(new Request(1l,1L, 1L, 2L));

		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatest() {

		assertEquals(new Request(1L, 1L, 1L, 2L), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;

		assertEquals(new Request(ID, 1L, 1L, 2L), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Request updated = new Request(1l, 1L, 1L, 2L);

		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {

		assertEquals(0, DAO.delete(1));
	}
	
	@Test
	public void testDeleteAll() {

		assertEquals(1, DAO.delete(1L,1L));
	}


	@Test
	public void testTotalPrice() {
		final Request updated = new Request(2D);

		assertEquals(updated, DAO.totalPrice(1L));

	}

}