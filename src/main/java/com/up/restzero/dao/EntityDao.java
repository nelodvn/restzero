package com.up.restzero.dao;

import java.util.List;

import com.up.restzero.entity.Entity;

public interface EntityDao {
	public List<Entity> listAll();
	
	public void add(Entity e);
}
