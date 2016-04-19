package com.up.restzero.tests;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public UsuarioServiceMockImpl getSampleService() {
		return new UsuarioServiceMockImpl();

	}
}
