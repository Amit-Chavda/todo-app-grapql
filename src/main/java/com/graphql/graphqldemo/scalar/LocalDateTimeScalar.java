package com.graphql.graphqldemo.scalar;

import graphql.GraphQLContext;
import graphql.execution.CoercedVariables;
import graphql.language.StringValue;
import graphql.language.Value;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class LocalDateTimeScalar implements Coercing<LocalDateTime, String> {

    private static final String DATE_PATTERN = "dd-MMM-yyyy HH:mm";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    @Override
    public String serialize(@NonNull Object dataFetcherResult, @NonNull GraphQLContext graphQLContext, @NonNull Locale locale) throws CoercingSerializeException {
        if (dataFetcherResult instanceof LocalDateTime) {
            return ((LocalDateTime) dataFetcherResult).format(DATE_FORMATTER);
        }
        throw new CoercingSerializeException("Invalid LocalDateTime value: " + dataFetcherResult);
    }

    @Override
    public LocalDateTime parseValue(@NonNull Object input, @NonNull GraphQLContext graphQLContext, @NonNull Locale locale) throws CoercingParseValueException {
        if (input instanceof String) {
            try {
                return LocalDateTime.parse((String) input, DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                throw new CoercingParseValueException("Invalid LocalDate value: " + input);
            }
        }
        throw new CoercingParseValueException("Invalid LocalDate value: " + input);
    }

    @Override
    public LocalDateTime parseLiteral(@NonNull Value<?> input, @NonNull CoercedVariables variables, @NonNull GraphQLContext graphQLContext, @NonNull Locale locale) throws CoercingParseLiteralException {
        if (input instanceof StringValue) {
            try {
                return LocalDateTime.parse(((StringValue) input).getValue(), DATE_FORMATTER);
            } catch (DateTimeParseException e) {
                throw new CoercingParseLiteralException("Invalid LocalDate value: " + input);
            }
        }
        throw new CoercingParseLiteralException("Invalid LocalDate value: " + input);
    }
}
