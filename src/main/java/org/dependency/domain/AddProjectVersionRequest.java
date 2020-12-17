package org.dependency.domain;


import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * This is the request class that will go between the build plugin (initially just the dependency-tracker-maven-plugin)
 * and the tracker-server.
 * <p>
 * This is basically a flattened version of the Project with no enforcement on the completeness.   This is because I
 * realized in writing this that different languages may different rules in what is required for a dependency.   So I
 * am opting for an simpler request and will have the plugin guarantee completeness/correctness instead of the
 * Project/ProjectVersion/Dependency classes themselves.
 */
public class AddProjectVersionRequest implements Serializable {
    private String groupName;
    private String artifactName;
    private LanguageRoot languageRoot;
    private String version;
    private OffsetDateTime createdDateTime;
    private BuildSource buildSource;

    /**
     * default constructor
     */
    public AddProjectVersionRequest() {
    }

    /**
     * @return The group name (IE io.github.scottconway) of the project
     * @see Project#getGroupName()
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @return the artifact name (IE tracker-domain) of the project.
     * @see Project#getArtifactName()
     */
    public String getArtifactName() {
        return artifactName;
    }

    /**
     * @return the language root that the project will run on.
     * @see Project#getLanguageRoot()
     * @see LanguageRoot
     */
    public LanguageRoot getLanguageRoot() {
        return languageRoot;
    }

    /**
     * @return the version being built
     * @see ProjectVersion#getVersion()
     */
    public String getVersion() {
        return version;
    }

    /**
     * @return the date/time of the build.
     * @see ProjectVersion#getCreatedDateTime()
     */
    public OffsetDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * @return the source of the build.
     * @see ProjectVersion#getBuildSource()
     * @see BuildSource
     */
    public BuildSource getBuildSource() {
        return buildSource;
    }

    /**
     * A setter for the gropuName
     *
     * @param groupName
     * @return this
     */
    public AddProjectVersionRequest withGroupName(String groupName) {
        this.groupName = groupName;
        return this;
    }

    /**
     * A setter for the artifactName
     *
     * @param artifactName
     * @return this
     */
    public AddProjectVersionRequest withArtifactName(String artifactName) {
        this.artifactName = artifactName;
        return this;
    }

    /**
     * A setter for the languageRoot
     *
     * @param languageRoot
     * @return this
     */
    public AddProjectVersionRequest withLanguageRoot(LanguageRoot languageRoot) {
        this.languageRoot = languageRoot;
        return this;
    }

    /**
     * A setter for the version
     *
     * @param version
     * @return this
     */
    public AddProjectVersionRequest withVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * A setter for the createdDateTime
     *
     * @param createdDateTime
     * @return this
     */
    public AddProjectVersionRequest withCreatedDateTime(OffsetDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
        return this;
    }

    /**
     * A setter for the buildSource
     *
     * @param buildSource
     * @return this
     */
    public AddProjectVersionRequest withBuildSource(BuildSource buildSource) {
        this.buildSource = buildSource;
        return this;
    }

    @Override
    public String toString() {
        return "AddProjectVersionRequest{" +
                "groupName='" + groupName + '\'' +
                ", artifactName='" + artifactName + '\'' +
                ", languageRoot=" + languageRoot +
                ", version='" + version + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", buildSource=" + buildSource +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AddProjectVersionRequest)) {
            return false;
        }
        AddProjectVersionRequest request = (AddProjectVersionRequest) o;
        return Objects.equals(groupName, request.groupName) && Objects.equals(artifactName, request.artifactName) && languageRoot == request.languageRoot && Objects.equals(version, request.version) && Objects.equals(createdDateTime, request.createdDateTime) && buildSource == request.buildSource;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupName, artifactName, languageRoot, version, createdDateTime, buildSource);
    }
}
