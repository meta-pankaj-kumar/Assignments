package com.metacube.inventory.service;

import java.util.ArrayList;
import com.metacube.inventory.element.Element;
/**
 * 
 * @author Pankaj
 *
 */
public class Service {
	private ArrayList<Element> elements;
	private static Service instance = null;
	
	/**
	 * @return Service instance
	 */
	public static Service getInstance(){
		if(instance == null){
			instance = new Service();
		}
		return instance;
	}
	
	public Service(){
		this.elements = new ArrayList<Element>();
		
		Element element1 = new Element("Apples",5);
		Element element2 = new Element("Banana",7);
		this.elements.add(element1);
		this.elements.add(element2);
	}
	
	/**
	 * @return ArrayList<Element> type
	 */
	public ArrayList<Element> getAllElements(){
		return this.elements;
	}
	
	/**
	 * @param name String type 
	 * @return Element type Element 
	 */
	public Element getElementByName(String name){
		for(int index = 0 ; index < this.elements.size() ; index ++){
			if(this.elements.get(index).getName().equalsIgnoreCase(name)){
				return this.elements.get(index);
			}
		}
		return new Element();
	}
	
	/**
	 * @param element type Element 
	 */
	public boolean insertElement(Element element){
		this.elements.add(element);
		return true;
	}
	
	/**
	 * @param element type Element 
	 */
	public boolean updateElement(Element element){
		boolean flag = false;
		for(int index = 0 ; index < this.elements.size() ; index ++ ){
			if(this.elements.get(index).getName().equalsIgnoreCase(element.getName())){
				this.elements.get(index).setQuantity(element.getQuantity());
				flag=true;
			}
		}
		if(!flag){
			insertElement(element);
		}
		return flag;
	}
	
	/**
	 * @param elementName String type 
	 */
	public boolean delete(String elementName) {
		Element element = getElementByName(elementName);
		boolean flag=false;
		for(int index=0 ; index < this.elements.size() ; index ++){
			if(this.elements.get(index) == element){
				this.elements.remove(index);
				flag=true;
			}
		}
		return flag;
	}
}