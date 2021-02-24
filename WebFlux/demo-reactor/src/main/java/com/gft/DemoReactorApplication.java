package com.gft;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gft.model.Persona;
import com.gft.operador.matematico.Matematico;

import io.reactivex.Observable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoReactorApplication implements CommandLineRunner {

	// Log
	private static final Logger Log = LoggerFactory.getLogger(DemoReactorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoReactorApplication.class, args);
	}

	public void reactor() {
		// Flujo de un solo elemento, entre parentesis es el tipo de dato
		Mono.just(new Persona(1, "Emily", 22)).doOnNext(p -> {
			// Logica adicional
			Log.info("[Reactor] Persona: " + p);
		}).subscribe(p -> Log.info("[Reactor] Persona: " + p));
	}

	public void rxjava2() {
		Observable.just(new Persona(1, "Emily", 22)).doOnNext(p -> Log.info("[RxJava2] Persona: " + p))
				.subscribe(p -> Log.info("[RxJava2] Persona: " + p));
	}

	public void mono() {
		Mono.just(new Persona(1, "Emily", 22)).subscribe(p -> Log.info(p.toString()));
	}

	public void flux() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		Flux.fromIterable(personas).subscribe(p -> Log.info(p.toString()));
	}

	public void fluxMono() {
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "Emily", 22));
		personas.add(new Persona(2, "Montserrat", 23));
		personas.add(new Persona(3, "Madrigal", 24));

		// De un flux donde recorriamos elemento por elemento
		// pasamos a mono a recorrer una sola lista
		Flux<Persona> fx = Flux.fromIterable(personas);
		// De flux a mono
		fx.collectList().subscribe(lista -> Log.info(lista.toString()));
	}

	@Override
	public void run(String... args) throws Exception {
		// reactor();
		// rxjava2();
		// mono();
		// flux();
		// fluxMono();

		// Creacion app = new Creacion();
		// app.range();
		// app.repeat();

//		Transformacion app = new Transformacion();
		// app.map();
		// app.flatMap();
//		app.groupBy();

//		Filtrado app = new Filtrado();
		// app.filter();
		// app.distinct();
//		app.take();
//		app.takeLast();
//		app.skip();
//		app.skipLast();

//		Combinacion app = new Combinacion();
//		app.merge();
//		app.zip();
//		app.zipWith();

//		ErrorOP app = new ErrorOP();
//		app.retry();
//		app.errorReturn();
//		app.errorResume();
//		app.errorMap();

//		Condicional app = new Condicional();
//		app.defaultEmpty();
//		app.takeUntil();
//		app.timeout(); //no funciona con el thread.sleep

		Matematico app = new Matematico();
//		app.average();
//		app.count();
//		app.min();
//		app.sum();
		app.summarizing();

	}

}
