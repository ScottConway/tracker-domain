package org.dependency.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Contains the main information about a project.
 *
 * @author Scott Conway
 */
public class Project implements Serializable {

    private long projectId;
    @NotBlank
    private String groupName;
    @NotBlank
    private String artifactName;
    @NotBlank
    private boolean projectSunset;
    @NotNull
    private List<ProjectVersion> versionList;

    /**
     * Default constructor.
     */
    public Project() {
    }

    /**
     * @return the id of the project that is used by the database.
     */
    public long getProjectId() {
        return projectId;
    }

    /**
     * Setter for the project id.
     *
     * @param projectId
     */
    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    /**
     * @return the maven groupId of the Project - for example the groupId of this application is "org.dependency".
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Setter for the group name.
     *
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return the maven artifactId of the dependency - for example the artifactId for
     * this application is "tracker-server".
     */
    public String getArtifactName() {
        return artifactName;
    }

    /**
     * Setter for the artifact name.
     *
     * @param artifactName
     */
    public void setArtifactName(String artifactName) {
        this.artifactName = artifactName;
    }

    /**
     * @return - If a project is sunset.  The only reason an entire project is sunset is that it is
     * no longer deployed on any servers.
     */
    public boolean isProjectSunset() {
        return projectSunset;
    }

    /**
     * Setter for the sunset.
     *
     * @param projectSunset
     */
    public void setProjectSunset(boolean projectSunset) {
        this.projectSunset = projectSunset;
    }

    /**
     * @return a list of ProjectVersion for the project.
     */
    public List<ProjectVersion> getVersionList() {
        return versionList;
    }

    /**
     * Setter for the project version list.
     *
     * @param versionList
     */
    public void setVersionList(List<ProjectVersion> versionList) {
        this.versionList = versionList;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + projectId +
                ", groupName='" + groupName + '\'' +
                ", artifactName='" + artifactName + '\'' +
                ", projectSunset=" + projectSunset +
                ", versionList=" + versionList +
                '}';
    }
}
