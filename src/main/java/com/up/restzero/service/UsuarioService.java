package com.up.restzero.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.up.restzero.dao.UsuarioDao;
import com.up.restzero.entity.Usuario;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;
	@Transactional
	public Usuario save(Usuario usuario){
		return this.usuarioDao.save(usuario);
	}
	
	public List<Usuario> list(){
		return this.usuarioDao.list();
	}
}
