package com.graphql.graphqldemo.scalar;

import graphql.schema.GraphQLScalarType;
import graphql.schema.idl.RuntimeWiring;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomRuntimeWiringConfigurer implements RuntimeWiringConfigurer {

    @Override
    public void configure(RuntimeWiring.Builder builder) {
        builder
                .scalar(localDateType())
                .scalar(localDateTimeType())
                .build();
    }

    public GraphQLScalarType localDateType() {
        return GraphQLScalarType.newScalar()
                .name("LocalDate")
                .description("LocalDate type")
                .coercing(new LocalDateScalar())
                .build();
    }

    public GraphQLScalarType localDateTimeType() {
        return GraphQLScalarType.newScalar()
                .name("LocalDateTime")
                .description("LocalDateTime type")
                .coercing(new LocalDateTimeScalar())
                .build();
    }

}