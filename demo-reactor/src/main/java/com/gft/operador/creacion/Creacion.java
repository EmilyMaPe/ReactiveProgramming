package com.gft.operador.creacion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gft.model.Persona;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Creacion {
	private static final Logger Log = LoggerFactory.getLogger(Creacion.class);

	public void justFrom() {
		Mono.just(new Persona(1, "Emily", 22));
//		Flux.fromIterable(coleccion);
//		Observable.just(item);
	}

	// Cuando tenemos conexiones de datos, el retorno de la consulta
	// puede estar vacio, para expresar flujos vacios podemos usar empty
	public void empty() {
		Mono.empty();
		Flux.empty();
		Observable.empty();
	}

	public void range() {
		int start = 0; // greater than or equal
		int end = 3; // less than
		Flux.range(start, end).doOnNext(i -> Log.info("i : " + i)).subscribe();
	}

	public void repeat() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));
		int repeat = 3; // how many times repeat
		Flux.fromIterable(personas).repeat(repeat).subscribe(p -> Log.info(p.toString()));
		Mono.just(new Persona(1, "Emily", 22)).repeat(repeat).subscribe(p -> Log.info(p.toString()));
	}
}
