package com.up.restzero.dao;

import java.util.List;

import com.up.restzero.entity.Usuario;

public interface UsuarioDao {
	Usuario save(Usuario usuario);
	Usuario find(Usuario usuario);
	Usuario findById(int id);
	List<Usuario> list();
}
