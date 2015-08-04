package com.up.restzero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.up.restzero.dao.EntityDao;
import com.up.restzero.entity.Entity;
import com.up.restzero.testes.ExemploEntitie;

@Service
public class ExemploService {
	
	@Autowired
	private EntityDao dao;
	
	public ExemploEntitie getExemploEntitie() {
		ExemploEntitie e = new ExemploEntitie();
		e.setParam("param value");
		return e;
	}
	
	public List<Entity> list(){
		return this.dao.listAll();
	}

	public void add(Entity e) {
		this.dao.add(e);
	}
}
