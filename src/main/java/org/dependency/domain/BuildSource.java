package org.dependency.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum BuildSource {
    PERSONAL("personal"),
    CI("CI,CI Build,Jenkins,Hudson"),
    UNKNOWN("");

    public List<String> sources = new ArrayList<>();

    private BuildSource(String sourceString) {
        Arrays.stream(sourceString.split(","))
                .map(String::toUpperCase)
                .forEach(s -> sources.add(s));
    }

    public static BuildSource valueOfSource(String source) {
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
