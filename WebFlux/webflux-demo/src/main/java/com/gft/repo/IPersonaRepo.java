package com.gft.repo;

import com.gft.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IPersonaRepo {

	Mono<Persona> save(Persona p);

	Mono<Persona> update(Persona p);

	Flux<Persona> listAll();

	Mono<Persona> get(Integer id);

	Mono<Void> delete(Integer id);
}
