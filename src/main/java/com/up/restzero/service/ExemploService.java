package com.up.restzero.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.up.restzero.dao.EntityDao;
import com.up.restzero.entity.Entity;

@Service
public class ExemploService {
	
	@Autowired
	private EntityDao dao;
	
	public List<Entity> list(){
		return this.dao.listAll();
	}

	public void add(Entity e) {
		this.dao.add(e);
	}
}
