package com.recreio.LivrariaAbraco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_usuario")
public class Usuario 
{	
	@NotNull
	@Size(min = 3, max = 100)
	@Column(name = "nomeUsuario")
	private String nome;
	
	@Id
	@NotNull
	@Column(name = "email")
	private String email;
	
	@NotNull
	//@Size(min = 5, max = 50)
	private String senha;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
