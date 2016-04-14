package com.up.restzero.dao.impl;

import javax.persistence.PersistenceContext;

import javax.persistence.EntityManager;

import com.up.restzero.dao.UsuarioDao;
import com.up.restzero.entity.Usuario;

public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager em;
	public void save(Usuario usuario) {
		this.em.persist(usuario);
	}

	public Usuario find(Usuario usuario) {
		return this.em.find(Usuario.class, usuario);
	}

	public Usuario findById(int id) {
		return this.em.find(Usuario.class, id);
	}

}
