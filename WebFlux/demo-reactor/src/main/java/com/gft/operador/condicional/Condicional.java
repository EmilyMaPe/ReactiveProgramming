package com.gft.operador.condicional;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gft.model.Persona;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Condicional {
	private static Logger log = LoggerFactory.getLogger(Condicional.class);

	public void defaultEmpty() {
//		Mono.empty()
//		Flux.empty()
		Mono.just(new Persona(1, "Mito", 29)).defaultIfEmpty(new Persona(0, "DEFAULT", 99))
				.subscribe(x -> log.info(x.toString()));

	}

	public void takeUntil() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).takeUntil(p -> p.getEdad() > 22).subscribe(x -> log.info(x.toString()));
	}

	public void timeout() throws InterruptedException {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).delayElements(Duration.ofSeconds(3)).timeout(Duration.ofSeconds(2))
				.subscribe(x -> log.info(x.toString()));

		Thread.sleep(10000);
	}

}
