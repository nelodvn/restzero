package com.up.restzero.rowmapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.RowMapper;

public class Automapper<T> implements RowMapper<T> {

	private static final String SET = "set";
	private Class<T> clazz;
	private List<String> params;

	private Automapper() {
	}

	public Automapper(Class<T> c) {
		this.clazz = c;
	}

	private Map<Field, Object> getFieldTypeMap(Class<T> clazz) {
		Map<Field, Object> map = new HashMap<Field, Object>();

		for (Field f : clazz.getDeclaredFields()) {
			Class<?> type = f.getType();
			if (type.equals(String.class)) {
				map.put(f, String.class);
			} else if (type.equals(int.class) || type.equals(Integer.class)) {
				map.put(f, Integer.class);
			}
		}
		return map;
	}

	public T mapRow(ResultSet rs, int rowNum) throws SQLException {
		Object newInstance = null;
		try {
			newInstance = this.clazz.newInstance();
			Map<Field, Object> fieldTypeMap = getFieldTypeMap(this.clazz);
			Map<String, Method> methodsByName = getMethods(this.clazz);

			Iterator<Field> iterator = fieldTypeMap.keySet().iterator();
			while (iterator.hasNext()) {
				Field next = iterator.next();
				if (methodsByName.containsKey(getMethodNameForField(next))) {

					methodsByName.get(getMethodNameForField(next)).invoke(
							newInstance, getValue(next, fieldTypeMap, rs));
				}
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return (T) newInstance;
	}

	private Object getValue(Field next, Map<Field, Object> fieldTypeMap,
			ResultSet rs) throws SQLException {
		Object object = fieldTypeMap.get(next);
		Object ret = null;
		if (next.getType().equals(String.class)) {
			ret = rs.getString(next.getName());
		}
		if (next.getType().equals(Integer.class)
				|| next.getType().equals(int.class)) {
			ret = rs.getInt(next.getName());
		}
		return ret;
	}

	private String getMethodNameForField(Field next) {
		String name = next.getName();
		name = SET + StringUtils.capitalise(name);
		return name;
	}

	private Map<String, Method> getMethods(Class clazz2) {
		Map<String, Method> map = new HashMap<String, Method>();
		for (Method m : clazz2.getMethods()) {
			if (m.getName().startsWith(SET))
				map.put(m.getName(), m);
		}
		return map;
	}
}
