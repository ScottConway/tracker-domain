package org.dependency.domain;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

/**
 * Currently this is the dependency information of an artifact as stored in the database.
 * Not sure if this will be used by the UI or if a different class will be used.
 *
 * @author Scott Conway
 */
public class Dependency implements Serializable {

    private long dependencyId;

    @NotBlank
    private String groupName;
    @NotBlank
    private String artifactName;
    @NotBlank
    private String dependencyVersion;
    @NotBlank
    private String type;
    @NotBlank
    private String scope;

    /**
     * Default constructor.
     */
    public Dependency() {
    }

    /**
     * @return The unique dependency id used by the database
     */
    public long getDependencyId() {
        return dependencyId;
    }

    /**
     * Setter of the dependencyId, required by mybatis.
     *
     * @param dependencyId
     */
    public void setDependencyId(long dependencyId) {
        this.dependencyId = dependencyId;
    }

    /**
     * @return the maven groupId of the dependency - for example the groupId of this application is "org.dependency".
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Setter of the maven group name.
     *
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return return the maven artifactId of the dependency - for example the artifactId for
     * this application is "tracker-server".
     */
    public String getArtifactName() {
        return artifactName;
    }

    /**
     * Setter for the artifact name
     *
     * @param artifactName
     */
    public void setArtifactName(String artifactName) {
        this.artifactName = artifactName;
    }

    /**
     * @return the version of the dependency
     */
    public String getDependencyVersion() {
        return dependencyVersion;
    }

    /**
     * Setter for the dependency version.
     *
     * @param dependencyVersion
     */
    public void setDependencyVersion(String dependencyVersion) {
        this.dependencyVersion = dependencyVersion;
    }

    /**
     * @return the maven type of the dependency - pom, jar, war, etc.
     */
    public String getType() {
        return type;
    }

    /**
     * Setter of the maven type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the maven scope of the dependency - compile, runtime, test, etc.
     */
    public String getScope() {
        return scope;
    }

    /**
     * Setter of the maven scope.
     *
     * @param scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "Dependency{" +
                "dependencyId=" + dependencyId +
                ", groupName='" + groupName + '\'' +
                ", artifactName='" + artifactName + '\'' +
                ", dependencyVersion='" + dependencyVersion + '\'' +
                ", type='" + type + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Dependency)) {
            return false;
        }
        Dependency that = (Dependency) o;
        return dependencyId == that.dependencyId && Objects.equals(groupName, that.groupName) && Objects.equals(artifactName, that.artifactName) && Objects.equals(dependencyVersion, that.dependencyVersion) && Objects.equals(type, that.type) && Objects.equals(scope, that.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dependencyId, groupName, artifactName, dependencyVersion, type, scope);
    }
}
