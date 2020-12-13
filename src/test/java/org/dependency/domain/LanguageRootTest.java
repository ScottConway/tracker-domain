package org.dependency.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageRootTest {

    @DisplayName("Null should be returned from valueOfSource when passed in null and empty string.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    public void valueOfSourceNullOrEmptyString(String input) {
        assertEquals(LanguageRoot.UNKNOWN, LanguageRoot.valueOfSource(input));
    }

    private static Stream<Arguments> provideArgumentsForValueOfSource() {
        return Stream.of(
                Arguments.of("java", LanguageRoot.JAVA),
                Arguments.of("Java", LanguageRoot.JAVA),
                Arguments.of("groovy", LanguageRoot.JAVA),
                Arguments.of("grOOvy", LanguageRoot.JAVA),
                Arguments.of("Ruby", LanguageRoot.UNKNOWN),
                Arguments.of("go", LanguageRoot.UNKNOWN),
                Arguments.of("GoLang", LanguageRoot.UNKNOWN),
                Arguments.of("bad string value", LanguageRoot.UNKNOWN)
        );
    }

    @DisplayName("valueOfSource test")
    @ParameterizedTest
    @MethodSource("provideArgumentsForValueOfSource")
    public void valueOfSource(String input, LanguageRoot expectedSource) {
        assertEquals(expectedSource, LanguageRoot.valueOfSource(input));
    }
}
