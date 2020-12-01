package org.dependency.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildSourceTest {

    @DisplayName("Null should be returned from valueOfSource when passed in null and empty string.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "\t", "\n"})
    public void valueOfSourceNullOrEmptyString(String input) {
        assertEquals(BuildSource.UNKNOWN, BuildSource.valueOfSource(input));
    }

    private static Stream<Arguments> provideArgumentsForValueOfSource() {
        return Stream.of(
                Arguments.of("personal", BuildSource.PERSONAL),
                Arguments.of("PerSonAl", BuildSource.PERSONAL),
                Arguments.of("ci", BuildSource.CI),
                Arguments.of("CI", BuildSource.CI),
                Arguments.of("CI Build", BuildSource.CI),
                Arguments.of("Hudson", BuildSource.CI),
                Arguments.of("Jenkins", BuildSource.CI),
                Arguments.of("bad string value", BuildSource.UNKNOWN)
        );
    }

    @DisplayName("valueOfSource test")
    @ParameterizedTest
    @MethodSource("provideArgumentsForValueOfSource")
    public void valueOfSource(String input, BuildSource expectedSource) {
        assertEquals(expectedSource, BuildSource.valueOfSource(input));
    }
}
