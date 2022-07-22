package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ItemTest {
	Long itemId = 2L;
	Double itemValue = 10.0D;
	String itemName = "name";
	
	private Item test = new Item( itemId,  itemName , itemValue) ;

	@Test
	public void testGetitemValue() {
		assertEquals(itemValue, test.getItemValue(),1);
	
}
	@Test
	public void testGetItemName() {
		assertEquals(itemName, test.getItemName());
	
}
	@Test
	public void testGetItemId() {
		assertEquals(2L, test.getId(),0);

}
	@SuppressWarnings("unused")
	@Test 
	public  void testConstructor() {
		Item it1 = new Item ("Car" , 10.00);
		Item it2 = new Item (13L, "Axe" , 40.00);
	}
	@Test 
	public void testToString( ) {
		assertEquals( "Item ID: 2 Item name: name Item price: 10.0",test.toString());
	}
}