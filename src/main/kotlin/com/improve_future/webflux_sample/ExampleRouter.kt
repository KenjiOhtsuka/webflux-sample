package com.improve_future.webflux_sample

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*

@Configuration
open class ExampleRouter {
    @Bean
    open fun mainRouter(exampleHandler: ExampleHandler) = router {
        accept(MediaType.ALL).nest {
            GET("/example").invoke(exampleHandler::hello)
        }
        accept(MediaType.TEXT_PLAIN).nest {
            GET("/exampleFurther1").invoke { exampleHandler.helloFurther1(it) }
            GET("/exampleFurther2").invoke { exampleHandler.helloFurther2(it) }
        }
    }
}