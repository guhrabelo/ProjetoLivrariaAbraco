package com.recreio.LivrariaAbraco.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
	
	//Atributos e Anotações:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "idCategoria")
	private long id;
	
	@NotNull 
	@Size(min = 8,max = 30)
	@Column (name = "genero")
	private String genero;
	
	@NotNull 
	@Size(min = 4,max = 30)
	@Column (name = "assunto")
	private String assunto;
	
	@NotNull 
	@Size(min = 4,max = 30)
	private String nacionalidade;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto; 



	//Getters and Setters:
	public long getId() {
		return id;
	}

	public void setId(long idCategoria) {
		this.id = idCategoria;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	

}


