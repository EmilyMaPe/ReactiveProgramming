package com.gft.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.model.Persona;
import com.gft.repo.IPersonaRepo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/personas")
public class PersonaController {
	private static final Logger log = LoggerFactory.getLogger(PersonaController.class);

	@Autowired
	private IPersonaRepo repo;

	@GetMapping
	public Flux<Persona> listAll() {
		return repo.listAll();
	}

	@GetMapping("/{id}")
	public Mono<Persona> get(@PathVariable Integer id) {
		return repo.get(id);
	}

	@PostMapping
	public Mono<Persona> save(@RequestBody Persona p) {
		return repo.save(p);
	}

	@PutMapping
	public Mono<Persona> update(@RequestBody Persona p) {
		return repo.update(p);
	}

	@DeleteMapping("/{id}")
	public Mono<Void> delete(@PathVariable Integer id) {
		return repo.get(id).flatMap(p -> repo.delete(p.getIdPersona()));
	}

}
