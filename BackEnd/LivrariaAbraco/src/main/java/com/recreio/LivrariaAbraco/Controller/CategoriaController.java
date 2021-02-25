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

import com.recreio.LivrariaAbraco.Repository.CategoriaRepository;
import com.recreio.LivrariaAbraco.model.Categoria;

@RestController
@RequestMapping ("/categoria")
@CrossOrigin ("*")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repositorioCategoria;
	
	
	@GetMapping 
	public ResponseEntity<List<Categoria>> getAll() {
		return ResponseEntity.ok(repositorioCategoria.findAll());
	}
	
	@GetMapping ("/codigo/{id}")
	public ResponseEntity<Categoria> getById (@PathVariable long id) {
		return repositorioCategoria.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping ("/genero/{genero}")
	public ResponseEntity<List<Categoria>> getByAssunto (@PathVariable String genero) {
		return ResponseEntity.ok(repositorioCategoria.findAllByGeneroContainingIgnoreCase(genero));
	}
	
	@PostMapping
	public ResponseEntity<Categoria> post (@RequestBody Categoria categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repositorioCategoria.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<Categoria> put (@RequestBody Categoria categoria) {
		return ResponseEntity.ok(repositorioCategoria.save(categoria));
	}
	
	@DeleteMapping ("/codigo/{id}")
	public void delete(@PathVariable long id) {
		repositorioCategoria.deleteById(id);
	}
	
	
}
