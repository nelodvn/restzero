package com.up.restzero.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	private int id;
	
	@Column
	private String nome;
	@Column
	private String email;
}
