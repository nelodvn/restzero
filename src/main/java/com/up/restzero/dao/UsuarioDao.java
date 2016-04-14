package com.up.restzero.dao;

import com.up.restzero.entity.Usuario;

public interface UsuarioDao {
	void save(Usuario usuario);
	Usuario find(Usuario usuario);
	Usuario findById(int id);
}
