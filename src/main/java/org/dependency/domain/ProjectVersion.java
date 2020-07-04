package org.dependency.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Contains the information for each version for a given project.
 */
public class ProjectVersion implements Serializable {
    private long versionId;
    @NotBlank
    private String version;
    @NotNull
    private boolean versionSunset;
    @PastOrPresent
    private LocalDateTime createdDateTime;
    @NotNull
    private List<Dependency> dependencyList;

    /**
     * Default constructor.
     */
    public ProjectVersion() {
    }

    /**
     * @return the id of the version used by the database.
     */
    public long getVersionId() {
        return versionId;
    }

    /**
     * Setter of the version id.
     *
     * @param versionId
     */
    public void setVersionId(long versionId) {
        this.versionId = versionId;
    }

    /**
     * @return version identifier - i.e. 0.0.1-SNAPSHOT
     */
    public String getVersion() {
        return version;
    }

    /**
     * Setter of the version.
     *
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * @return if this version has been sunset.  This should only be true if the particular version is no
     * longer deployed to any of the servers.
     */
    public boolean isVersionSunset() {
        return versionSunset;
    }

    /**
     * Setter for the sunset version.
     *
     * @param versionSunset
     */
    public void setVersionSunset(boolean versionSunset) {
        this.versionSunset = versionSunset;
    }

    /**
     * @return - the LocalDateTime containing when this entry was created.
     */
    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    /**
     * Setter for the createDateTime.
     *
     * @param createdDateTime
     */
    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    /**
     * @return - the list of dependencies that this version has.
     */
    public List<Dependency> getDependencyList() {
        return dependencyList;
    }

    /**
     * Setter for this versions dependency list.
     *
     * @param dependencyList
     */
    public void setDependencyList(List<Dependency> dependencyList) {
        this.dependencyList = dependencyList;
    }
}
