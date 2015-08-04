package com.up.restzero.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.up.restzero.entity.Entity;

public class EntityMapper implements RowMapper<Entity>{

	public Entity mapRow(ResultSet rs, int nowRum) throws SQLException {
		Entity e = new Entity();
		e.setParam(rs.getString("param"));
		return e;
	}

}
