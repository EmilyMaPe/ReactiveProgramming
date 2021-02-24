package com.gft.operador.combinacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gft.model.Persona;
import com.gft.model.Venta;
import com.gft.operador.transformacion.Transformacion;

import reactor.core.publisher.Flux;

public class Combinacion {
	private static final Logger log = LoggerFactory.getLogger(Transformacion.class);

	public void merge() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		List<Persona> personas2 = new ArrayList<>();
		personas.add(new Persona(4, "Harry", 22));
		personas.add(new Persona(5, "Ron", 23));
		personas.add(new Persona(5, "Hermione", 24));

		List<Venta> ventas = new ArrayList<>();
		ventas.add(new Venta(1, LocalDateTime.now()));

		Flux<Persona> fx1 = Flux.fromIterable(personas);
		Flux<Persona> fx2 = Flux.fromIterable(personas2);
		Flux<Venta> fx3 = Flux.fromIterable(ventas);

		Flux.merge(fx1, fx2, fx3, fx2, fx1).subscribe(p -> log.info(p.toString()));
	}

	public void zip() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		List<Persona> personas2 = new ArrayList<>();
		personas.add(new Persona(4, "Harry", 22));
		personas.add(new Persona(5, "Ron", 23));
		personas.add(new Persona(5, "Hermione", 24));

		List<Venta> ventas = new ArrayList<>();
		ventas.add(new Venta(1, LocalDateTime.now()));

		Flux<Persona> fx1 = Flux.fromIterable(personas);
		System.out.println("Flujo1");
		Flux<Persona> fx2 = Flux.fromIterable(personas2);
		System.out.println("Flujo2");
		Flux<Venta> fx3 = Flux.fromIterable(ventas);
		System.out.println("Flujo3");

//		Flux.zip(fx1, fx2).map(t -> t.getT1().toString() + t.getT2().toString()).subscribe(x -> log.info(x.toString()));
		Flux.zip(fx1.collectList(), fx2.collectList(), (p1, p2) -> String.format("fx1 : %s, fx2: %s", p1, p2))
				.subscribe(x -> log.info(x.toString()));
//		Flux.zip(fx1, fx2, fx3).subscribe(x -> log.info(x.toString()));
//		Flux.zip(Flux.fromIterable(personas), Flux.fromIterable(personas2),
//				(p1, p2) -> String.format("fx1: %s, fx2: %s", p1.toString(), p2.toString()))
//				.subscribe(x -> log.info(x.toString()));

//		Flux.zip(fx1.collectList(), fx2.collectList(),
//				(p1, p2) -> String.format("fx1: %s, fx2: %s", p1.toString(), p2.toString()))
//				.subscribe(x -> log.info(x.toString()));
		System.out.println("Fin zip");

//		Flux.merge(fx1, fx2, fx3).subscribe(p -> log.info(p.toString()));

//		fx3.subscribe(p -> p.toString());
//		Flux<String> fx = Flux.zip(fx1, fx2, (p1, p2) -> ("fx1: " + p1.toString() + ", fx2: " + p2.toString()));
//		fx.subscribe(x -> log.info(x));

//		Flux.merge(fx1, fx2).zip((p1, p2) -> String.format("fx1: %s, fx2: %s", p1.toString(), p2.toString()).subscribe(x -> log.info(x.toString());
	}

	public void zipWith() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		List<Persona> personas2 = new ArrayList<>();
		personas.add(new Persona(4, "Harry", 22));
		personas.add(new Persona(5, "Ron", 23));
		personas.add(new Persona(5, "Hermione", 24));

		List<Venta> ventas = new ArrayList<>();
		ventas.add(new Venta(1, LocalDateTime.now()));

		Flux<Persona> fx1 = Flux.fromIterable(personas);
		Flux<Persona> fx2 = Flux.fromIterable(personas2);
//		Flux<Venta> fx3 = Flux.fromIterable(ventas);

		fx1.zipWith(fx2, (p1, p2) -> String.format("fx1: %s, fx2: %s", p1.toString(), p2.toString()))
				.subscribe(x -> log.info(x.toString()));
	}
}
