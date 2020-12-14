package org.dependency.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The purpose of BuildSource is to allow the transmitting of who built the project.  Currently the only two
 * supported values are personal (a developer on their personal/work machine), and CI build.
 * <p>
 * This allows for the ability in the tracker-server to only save off builds done by the CI system if they are
 * the only builds that are promoted to production but still allow analysis of data from personal builds.
 */
public enum BuildSource {
    PERSONAL("personal"),
    CI("CI,CI Build,Jenkins,Hudson"),
    UNKNOWN("");

    private final List<String> sources = new ArrayList<>();

    /**
     * Internal constructor
     *
     * @param sourceString
     */
    BuildSource(String sourceString) {
        Arrays.stream(sourceString.split(","))
                .map(String::toUpperCase)
                .forEach(s -> sources.add(s));
    }

    /**
     * @param source - creator of the version.
     * @return - the BuildSource for the given source string,  UNKNOWN otherwise.
     */
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
