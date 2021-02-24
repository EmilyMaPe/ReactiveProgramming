package com.gft.operador.matematico;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gft.model.Persona;

import reactor.core.publisher.Flux;

public class Matematico {
	private static final Logger log = LoggerFactory.getLogger(Matematico.class);

	public void average() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).collect(Collectors.averagingInt(Persona::getEdad))
				.subscribe(p -> log.info(p.toString()));
	}

	public void count() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).count().subscribe(p -> log.info("Cantidad: " + p));
	}

	public void min() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).collect(Collectors.minBy(Comparator.comparing(Persona::getEdad)))
				.subscribe(p -> log.info(p.get().toString()));
	}

	public void sum() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).collect(Collectors.summingInt(Persona::getEdad))
				.subscribe(p -> log.info("Suma: " + p));
	}

	public void summarizing() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).collect(Collectors.summarizingInt(Persona::getEdad))
				.subscribe(p -> log.info("Resumen: " + p));
	}

}
