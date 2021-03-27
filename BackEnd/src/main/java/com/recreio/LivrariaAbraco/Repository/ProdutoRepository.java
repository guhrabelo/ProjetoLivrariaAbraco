package com.recreio.LivrariaAbraco.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.recreio.LivrariaAbraco.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findAllByNomeContainingIgnoreCase(String nome);
	
	public List<Produto> findProdutoByCategoriaGenero(String categoriaGenero);
	
}
