package org.dependency.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LanguageRoot allows the transmitting of the language that the dependency/project will run on.
 * <p>
 * The purpose of this is to allow for future expandability in different languages where two different
 * languages would have dependencies that have the same name but are actually completely different.
 * By recording and displaying the language root it is hoped that any confusion will be minimized.
 */
public enum LanguageRoot {
    JAVA("java,groovy"),
    UNKNOWN("");

    private final List<String> sources = new ArrayList<>();

    /**
     * Internal constructor
     *
     * @param sourceString
     */
    LanguageRoot(String sourceString) {
        Arrays.stream(sourceString.split(","))
                .map(String::toUpperCase)
                .forEach(s -> sources.add(s));
    }

    /**
     * @param source - Name of the language family for which the given project is for.
     * @return the associated LanguageRoot for the source, UNKNOWN otherwise.
     */
    public static LanguageRoot valueOfSource(String source) {
        if (source == null) {
            return UNKNOWN;
        }

        String ucSource = source.toUpperCase();
        return Arrays.stream(values())
                .filter(e -> e.sources.contains(ucSource))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
