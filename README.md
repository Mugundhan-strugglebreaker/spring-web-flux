Spring boot Webflux



Api
 Publicer —> Datasource
 Subscriber —> consumer or client
 Subscription —> request or cancel subscription 
 Processor —> extends publicer and subscriber

Project Reactor — Library
	reactor-core
	reactor-test
	reactor-natty

Reactor-core:
	Core library
	Implementation of reactive stream specification
	Java 8 minimum
	

Implementation of reactive stream application
	Flux and Mono (Reactive Types in Project Reactor)
	Flux —> Represent 0 to N elements
	Mono —> Represents 0 to 1 element

Flux (More than one results)
	Flux.just(“spring”,”springboot”,”reactive spring boot”) ——> consider this data is fetched from database
	.map( s -> s.concat(“flux”) —> operation needed to perform
	.subscribe(System.out::println); —> subscribe to println method

Mono ( 0 or 1 result)
	Mono.just(“spring”) —> consider this data fetched from database
	.map( s -> s.concat(“flux”) —> operation needed to perform
	.subscribe(System.out::println); —> subscribe to println method
