package com.gft.repo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.gft.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class PersonaRepoImpl implements IPersonaRepo {

	private static final Logger log = LoggerFactory.getLogger(PersonaRepoImpl.class);

	@Override
	public Mono<Persona> save(Persona p) {
		log.info(p.toString());
		return Mono.just(p);
	}

	@Override
	public Mono<Persona> update(Persona p) {
		log.info(p.toString());
		return Mono.just(p);
	}

	@Override
	public Flux<Persona> listAll() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily"));
		personas.add(new Persona(2, "Erick"));
		personas.add(new Persona(3, "Lidia"));
		return Flux.fromIterable(personas);
	}

	@Override
	public Mono<Persona> get(Integer id) {
		return Mono.just(new Persona(id, "Emily"));
	}

	@Override
	public Mono<Void> delete(Integer id) {
		return Mono.empty();
	}

}
