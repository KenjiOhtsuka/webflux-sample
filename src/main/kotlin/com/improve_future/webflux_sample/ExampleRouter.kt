package com.improve_future.webflux_sample

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor.DefaultImpls.accept
import kotlin.reflect.jvm.javaMethod

@Configuration
open class ExampleRouter {
    @Bean
    open fun route(exampleHandler: ExampleHandler): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(
                RequestPredicates.GET("/example").and(
                    RequestPredicates.accept(
                        MediaType.TEXT_PLAIN
                    )
                ), HandlerFunction { exampleHandler.hello(it) })
    }
    @Bean
    open fun routeExampleOneStepFurther(exampleHandler: ExampleHandler): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route<ServerResponse>(
                RequestPredicates.GET("/exampleFurther1").and(
                    RequestPredicates.accept(MediaType.TEXT_PLAIN)
                ),
                HandlerFunction<ServerResponse> {
                    exampleHandler.helloFurther1(
                        it
                    )
                })
            .andRoute(
                RequestPredicates.GET("/exampleFurther2").and(
                    RequestPredicates.accept(MediaType.TEXT_PLAIN)
                ),
                HandlerFunction<ServerResponse> {
                    exampleHandler.helloFurther2(
                        it
                    )
                })
    }
}