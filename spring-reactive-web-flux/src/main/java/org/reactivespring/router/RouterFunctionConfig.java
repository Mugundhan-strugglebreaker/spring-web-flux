package org.reactivespring.router;

import org.reactivespring.handlers.SampleHandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class RouterFunctionConfig {

    @Bean
    public RouterFunction<ServerResponse> route(SampleHandlerFunctions sampleHandlerFunctions){
        return RouterFunctions
                .route(RequestPredicates.GET("/function/flux").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),(req) -> sampleHandlerFunctions.flux(req))
                .andRoute(RequestPredicates.GET("/function/mono").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),sampleHandlerFunctions::mono);
    }

}
