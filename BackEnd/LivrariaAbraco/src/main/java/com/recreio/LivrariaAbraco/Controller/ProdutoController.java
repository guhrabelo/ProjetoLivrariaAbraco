package com.recreio.LivrariaAbraco.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recreio.LivrariaAbraco.Repository.ProdutoRepository;
import com.recreio.LivrariaAbraco.model.Produto;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController 
{
	@Autowired
	private ProdutoRepository repositorioProduto;
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll()
	{
		return ResponseEntity.ok(repositorioProduto.findAll());
	}
	
	@GetMapping ("/codigo/{id}")
	public ResponseEntity<Produto> getById (@PathVariable long id) {
		return repositorioProduto.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/livro/{nomeProduto}")
	public ResponseEntity<List<Produto>> getByNome (@PathVariable String nome) {
		return ResponseEntity.ok(repositorioProduto.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<Produto> post (@RequestBody Produto produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorioProduto.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<Produto> put (@RequestBody Produto produto) {
		return ResponseEntity.ok(repositorioProduto.save(produto));
	}
	
	@DeleteMapping ("/codigo/{id}")
	public void delete(@PathVariable long id) {
		repositorioProduto.deleteById(id);
	}
	
	
}
