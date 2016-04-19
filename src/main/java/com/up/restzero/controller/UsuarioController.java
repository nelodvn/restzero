package com.up.restzero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.up.restzero.controller.base.BaseRestController;
import com.up.restzero.controller.base.JsonResponse;
import com.up.restzero.entity.Usuario;
import com.up.restzero.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends BaseRestController{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/list")
	public @ResponseBody JsonResponse list(){
		try {
			return success(this.usuarioService.list());
		} catch (Exception e) {
			return error("Error listing users: " + e.getMessage());
		}
		
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody JsonResponse add(@RequestBody Usuario usuarioDoFront){
		try{
			return success(this.usuarioService.save(usuarioDoFront), "User created.");
		}
		catch(Exception e){
			return error(usuarioDoFront, "Erro criando usuario");
		}
	}
	
}
