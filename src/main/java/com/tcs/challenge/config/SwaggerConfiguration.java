package com.tcs.challenge.config;

import org.reactivestreams.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.reactive.config.WebFluxConfigurer;

import com.fasterxml.classmate.ResolvedType;
import com.fasterxml.classmate.TypeResolver;
import com.fasterxml.classmate.types.ResolvedArrayType;
import com.tcs.challenge.model.Clouds;
import com.tcs.challenge.model.Coord;
import com.tcs.challenge.model.Sys;
import com.tcs.challenge.model.WeatherElement;
import com.tcs.challenge.model.Wind;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.readers.operation.HandlerMethodResolver;

@Configuration
public class SwaggerConfiguration implements WebFluxConfigurer {
    @Bean
    Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .additionalModels(typeResolver.resolve(Clouds.class), typeResolver.resolve(Wind.class),
                        typeResolver.resolve(Coord.class), typeResolver.resolve(Sys.class),
                        typeResolver.resolve(WeatherElement.class))
                .apiInfo(apiInfo()).enable(true).genericModelSubstitutes(Mono.class, Flux.class, Publisher.class)
                .select().apis(RequestHandlerSelectors.basePackage("com.tcs.challenge"))
                .paths(PathSelectors.any()).build();
    }

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API TCS").description("TCS Challenge").version("1.0").build();
	}

    /**
     * How to configure springfox to unwrap reactive types such as Mono and Flux without having to explicitly specify response type in @ApiResponse
     * @param resolver
     * @return
     */
    @Bean
    @Primary
    HandlerMethodResolver fluxMethodResolver(TypeResolver resolver) {
        return new HandlerMethodResolver(resolver) {
            @Override
            public ResolvedType methodReturnType(HandlerMethod handlerMethod) {
                var retType = super.methodReturnType(handlerMethod);

                while (retType.getErasedType() == Mono.class || retType.getErasedType() == Flux.class
                        || retType.getErasedType() == ResponseEntity.class) {
                    if (retType.getErasedType() == Flux.class) {
                        var type = retType.getTypeBindings().getBoundType(0);
                        retType = new ResolvedArrayType(type.getErasedType(), type.getTypeBindings(), type);
                    } else {
                        retType = retType.getTypeBindings().getBoundType(0);
                    }
                }

                return retType;
            }
        };
    }
}