package com.up.restzero.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.up.restzero.dao.UsuarioDao;
import com.up.restzero.entity.Usuario;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager em;

	public Usuario save(Usuario usuario) {
		this.em.persist(usuario);
		return usuario;
	}

	public Usuario find(Usuario usuario) {
		return this.em.find(Usuario.class, usuario);
	}

	public Usuario findById(int id) {
		return this.em.find(Usuario.class, id);
	}

	public List<Usuario> list() {
		Query listQuery = this.em.createQuery("select u from Usuario u" );
		List<Usuario> resultList = listQuery.getResultList();
		return resultList;
	}

}
