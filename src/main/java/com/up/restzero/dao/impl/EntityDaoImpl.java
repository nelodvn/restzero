package com.up.restzero.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;

import com.up.restzero.dao.EntityDao;
import com.up.restzero.entity.Entity;
import com.up.restzero.rowmapper.EntityMapper;
import com.up.restzero.rowmapper.EntityRowMapper;
@Repository
public class EntityDaoImpl implements EntityDao{

	@Autowired
	private DataSource dataSource;
//	private JdbcTemplate jdbcTemplate;
	
	public List<Entity> listAll() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Entity> query = jdbcTemplate.query("select * from entity", new EntityRowMapper(Entity.class));
		return query;
	}

	public void add(Entity e) {
		String sql = "insert into entity values (?)";
//		this.jdbcTemplate.update(sql, new Object[]{e.getParam()});
	}

}
