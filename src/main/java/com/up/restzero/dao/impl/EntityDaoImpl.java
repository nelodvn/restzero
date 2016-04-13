package com.up.restzero.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.up.restzero.dao.EntityDao;
import com.up.restzero.entity.Entity;
import com.up.restzero.rowmapper.EntityRowMapper;
@Repository
public class EntityDaoImpl implements EntityDao{

	@Autowired
	private DataSource dataSource;
	@PersistenceContext
	private EntityManager em;
//	private JdbcTemplate jdbcTemplate;
	
	public List<Entity> listAll() {
		Query createQuery = this.em.createQuery("select e from Entity");
		List resultList = createQuery.getResultList();
		return resultList;
	}

	public void add(Entity e) {
		String sql = "insert into entity values (?)";
//		this.jdbcTemplate.update(sql, new Object[]{e.getParam()});
	}

}
