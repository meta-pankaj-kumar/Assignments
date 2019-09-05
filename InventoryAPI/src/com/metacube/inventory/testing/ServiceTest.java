package com.metacube.inventory.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.inventory.element.Element;
import com.metacube.inventory.service.Service;
/**
 * 
 * @author Pankaj
 *
 */
public class ServiceTest {
	
	Service service = Service.getInstance();
	
	@Test
	/**
	 * @param null
	 * @return null
	 */
	public void testGetElementByName() {
		
		//Positive Test Case
		Element element = service.getElementByName("Apples");
		assertEquals("Apples", element.getName());
		
		//Negative Test Case
		element = service.getElementByName("Apple");
		assertEquals(null, element.getName());
		
	}
	
	@Test
	/**
	 * @param null
	 * @return null
	 */
	public void testInsertElement(){
		
		//Positive Test Case
		Element element = new Element("XYZ",5);
		assertTrue(service.insertElement(element));
		
	}
	
	@Test
	/**
	 * @param null
	 * @return null
	 */
	public void testUpdateElement(){
		
		//Positive Test Case
		Element element = new Element("Apples",5);
		assertTrue(service.updateElement(element));
		
		//Negative Test Case
		element = new Element("App",5);
		assertFalse(service.updateElement(element));
		
	}
	
	@Test
	/**
	 * @param null
	 * @return null
	 */
	public void testDelete(){
		
		//Positive Test Case
		assertTrue(service.delete("XYZ"));
		
		//Negative Test Case
		assertFalse(service.delete("XYZq"));
		
	}
}