package com.up.restzero.tests;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class Test {

	@Autowired
	UsuarioServiceMockImpl usuarioService;
	
	@org.junit.Test
	public void justTest() {
		assertEquals(true, usuarioService.test());
	}
}
