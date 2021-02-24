package com.gft.operador.filtrado;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gft.model.Persona;
import com.gft.operador.transformacion.Transformacion;

import reactor.core.publisher.Flux;

public class Filtrado {
	private static final Logger Log = LoggerFactory.getLogger(Transformacion.class);

	public void filter() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).filter(p -> p.getEdad() > 23).subscribe(p -> Log.info(p.toString()));
	}

	public void distinct() {

		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).distinct().subscribe(p -> Log.info(p.toString()));
	}

	public void take() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).take(1).subscribe(p -> Log.info(p.toString()));

	}

	public void takeLast() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).takeLast(1).subscribe(p -> Log.info(p.toString()));

	}

	public void skip() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).skip(2).subscribe(p -> Log.info(p.toString()));

	}

	public void skipLast() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).skipLast(2).subscribe(p -> Log.info(p.toString()));

	}

}
