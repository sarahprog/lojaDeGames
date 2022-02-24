package com.generation.lojadegames.controller;

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

import com.generation.lojadegames.model.ProdutoModel;
import com.generation.lojadegames.repository.ProdutoRepository;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> getAll(){
		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> getById(@PathVariable long id){
		
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<List<ProdutoModel>> getByName(@PathVariable String name){
		return ResponseEntity.ok(repository.findAllByNameContainingIgnoreCase(name));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> post(@RequestBody ProdutoModel product){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(product));
		
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> put(@RequestBody ProdutoModel product){
		
		return ResponseEntity.ok(repository.save(product));
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
	
		repository.deleteById(id);
		
	}
	
}
