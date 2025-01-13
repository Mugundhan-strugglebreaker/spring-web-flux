package org.reactivespring.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FluxAndmonoTest {

    @Test
    public void fluxTest(){
        Flux<String> flux = Flux.just("spring","spring-boot","reactive-spring")
//                .concatWith(Flux.error(new RuntimeException("Default Error Message")))
                .log();
        flux.subscribe(System.out::println, (e) -> System.err.println(e),() -> System.out.println("Completed"));
    }

    public void fluxTestElement_WithoutError(){

    }
}
