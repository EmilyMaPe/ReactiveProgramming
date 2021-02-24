package com.gft.operador.error;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gft.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ErrorOP {
	private static final Logger log = LoggerFactory.getLogger(ErrorOP.class);

	public void retry() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).concatWith(Flux.error(new RuntimeException("UN ERROR"))).retry(1)
				.doOnNext(x -> log.info(x.toString())).subscribe();
	}

	public void errorReturn() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).concatWith(Flux.error(new RuntimeException("UN ERROR")))
				.onErrorReturn(new Persona(0, "XYZ", 99)).subscribe(x -> log.info(x.toString()));
	}

	public void errorResume() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).concatWith(Flux.error(new RuntimeException("UN ERROR")))
				.onErrorResume(e -> Mono.just(new Persona(0, "xyz", 99))).subscribe(x -> log.info(x.toString()));
	}

	public void errorMap() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).concatWith(Flux.error(new RuntimeException("UN ERROR")))
				.onErrorMap(e -> new InterruptedException(e.getMessage())).subscribe(x -> log.info(x.toString()));
	}
}
