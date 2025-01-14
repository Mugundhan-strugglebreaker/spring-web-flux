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

@WebFlux Annotations:

Purpose:
* Used for testing WebFlux controllers, specifically the web layer of an application.
* Does not load the entire Spring application context; instead, it only loads the beans related to the web layer.
Scope:
* Loads @Controller, @ControllerAdvice, and related configuration classes.
* Excludes components like @Service or @Repository from the application context.
Dependencies:
* Relies on Spring WebFlux-specific classes for non-blocking, reactive tests.
* Works well with WebTestClient, which is a reactive web test client.
Annotations Used Together:
* Often combined with @MockBean or @Import to provide mock implementations or additional configuration for excluded layers.
Testing Framework:
* Compatible with testing frameworks like JUnit or TestNG.
* Focuses on HTTP request-response interactions.

`@RunWith(SpringRunner.class)` is a JUnit 4 annotation used to integrate Spring TestContext Framework with JUnit, enabling loading of the Spring application context and providing Spring features like dependency injection during tests.


Functional Web
	Use Functions to route the request and response.
	RouterFunction and Handler Function

RouterFunction
	Use to route the incoming request
	Similar to the functionality of @RequestMapping annotation

HandlerFunction
	Handles the request and response
	ServerRequest and ServerResponse

	ServerRequest represents the HttpRequests
	ServerResponse represents the HttpResponse
