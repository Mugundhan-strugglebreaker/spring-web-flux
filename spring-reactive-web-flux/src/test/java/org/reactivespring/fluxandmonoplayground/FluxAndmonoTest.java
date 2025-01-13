package org.reactivespring.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {

    @Test
    public void fluxTest(){
        Flux<String> flux = Flux.just("spring","spring-boot","reactive-spring")
//                .concatWith(Flux.error(new RuntimeException("Default Error Message")))
                .log();
        flux.subscribe(System.out::println, (e) -> System.err.println(e),() -> System.out.println("Completed"));
    }

    @Test
    public void fluxTestElement_WithoutError(){
        Flux<String> stringFlux = Flux.just("spring","spring-boot","reactive-spring").log();
        StepVerifier.create(stringFlux)
                .expectNext("spring")
                .expectNext("spring-boot")
                .expectNext("reactive-spring")
                .verifyComplete(); // this verify complete starts the flow if it is not present then flux will not execute

        /*
         StepVerifier.create(stringFlux)
                .expectNext("spring")
                .expectNext("spring-boot1") // Here error throws because value does not matches
                .expectNext("reactive-spring")
                .verifyComplete();
         */

    }

    @Test
    public void fluxTestElement_WithError(){
        Flux<String> stringFlux = Flux.just("spring","spring-boot","reactive-spring")
                .concatWith(Flux.error(new RuntimeException("Default Error Message")))
                .log();

        // checking expection
        StepVerifier.create(stringFlux)
                .expectNext("spring")
                .expectNext("spring-boot")
                .expectNext("reactive-spring")
                .expectError(RuntimeException.class)
                .verify(); // this verify complete starts the flow if it is not present then flux will not execute

        //checking error message
        StepVerifier.create(stringFlux)
                .expectNext("spring")
                .expectNext("spring-boot")
                .expectNext("reactive-spring")
                .expectErrorMessage("Default Error Message")
                .verify(); // this verify complete starts the flow if it is not present then flux will not execute
    }

    @Test
    public void fluxTestElementCount(){
        Flux<String> stringFlux = Flux.just("spring","spring-boot","reactive-spring")
                .log();

        // count
        StepVerifier.create(stringFlux)
                .expectNextCount(3)
                .verifyComplete(); // this verify complete starts the flow if it is not present then flux will not execute

    }

    @Test
    public void fluxTestElements(){
        Flux<String> stringFlux = Flux.just("spring","spring-boot","reactive-spring")
                .log();

        StepVerifier.create(stringFlux)
                .expectNext("spring","spring-boot","reactive-spring")
                .verifyComplete();

    }

    @Test
    public void monoTest(){
        Mono<String> stringMono = Mono.just("spring").log();

        StepVerifier.create(stringMono)
                .expectNext("spring")
                .verifyComplete();
    }

    @Test
    public void monoTestError(){
        Mono<Object> stringMono = Mono.error(new RuntimeException("Error")).log();

        StepVerifier.create(stringMono)
                .expectError(RuntimeException.class)
                .verify();
    }
}
