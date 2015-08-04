package com.up.restzero.testes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.up.restzero.entity.Entity;
import com.up.restzero.service.ExemploService;

@RestController
@RequestMapping("/exemplo/")
public class ExemploController {
	
	@Autowired
	private ExemploService service;
	
	@RequestMapping(method = RequestMethod.GET, value = "entitie", produces={"application/json","application/xml"})
	public @ResponseBody ExemploEntitie getExemplo(){
		return service.getExemploEntitie();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "teste")
	public @ResponseBody List<Entity> teste(){
		return this.service.list();
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "add")
	public void add(){
		Entity e = new Entity();
		e.setParam("teste!");
		this.service.add(e);
	}
}
