package com.metacube.inventory.rest;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.metacube.inventory.element.Element;
import com.metacube.inventory.service.Service;

@Path("/inventory")
/**
 * 
 * @author Pankaj
 *
 */
public class RestAPI {
	
	Service service = Service.getInstance();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	/**
	 * @return ArrayList<Element> containg All Elements
	 */
	public ArrayList<Element> getAllElements(){
		return service.getAllElements();
	}
	
	@GET
	@Path("{elementName}")
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	/**
	 * @param elementName String type 
	 * @return Element of Element type
	 */
	public Element getElement(@PathParam("elementName") String elementName){
		return service.getElementByName(elementName);
	}
	
	@POST
	@Path("/insert")
	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	/**
	 * @param element type Element 
	 */
	public void insert(Element element){
		service.insertElement(element);
	}
	
	@PUT
	@Path("/update")
	@Consumes({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	/**
	 * @param element type Element 
	 */
	public void update(Element element){
		service.updateElement(element);
	}
	
	@DELETE
	@Path("{elementName}")
	@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
	/**
	 * @param elementName String type 
	 */
	public void deleteElement(@PathParam("elementName") String elementName){
		Element element = service.getElementByName(elementName);
		if(element.getQuantity()!=0){
			service.delete(elementName);
		}
	}
}