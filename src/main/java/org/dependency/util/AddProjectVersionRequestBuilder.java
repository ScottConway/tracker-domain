package org.dependency.util;

import org.dependency.domain.AddProjectVersionRequest;
import org.dependency.domain.Dependency;
import org.dependency.domain.Project;
import org.dependency.domain.ProjectVersion;

import java.util.ArrayList;
import java.util.List;

public class AddProjectVersionRequestBuilder {
    /**
     * default constructor.
     */
    public AddProjectVersionRequestBuilder() {
    }

    /**
     * Creates a Project from an AddProjectVersionRequst
     *
     * @param request
     * @return Project object populated with values from the AddProjectVersionRequest
     * @see Project
     * @see AddProjectVersionRequest
     */
    public Project buildProject(AddProjectVersionRequest request) {
        Project project = new Project();
        project.setGroupName(request.getGroupName());
        project.setArtifactName(request.getArtifactName());
        project.setLanguageRoot(request.getLanguageRoot());
        project.setVersionList(buildVersionList(request));
        project.setProjectSunset(false);
        return project;
    }

    private List<ProjectVersion> buildVersionList(AddProjectVersionRequest request) {
        List<ProjectVersion> versionList = new ArrayList<>();
        ProjectVersion version = new ProjectVersion();
        version.setVersion(request.getVersion());
        version.setBuildSource(request.getBuildSource());
        version.setCreatedDateTime(request.getCreatedDateTime());
        version.setVersionSunset(false);
        version.setDependencyList(buildDependencyList(request));
        versionList.add(version);
        return versionList;
    }

    //TODO finish building out putting dependency list in AddProjectVersionRequestBuilder.
    private List<Dependency> buildDependencyList(AddProjectVersionRequest request) {
        List<Dependency> dependencyList = new ArrayList<>();
        return dependencyList;
    }

    /**
     * Creates a AddProjectVersionRequest from an Project
     *
     * @param project
     * @return AddProjectVersionRequest populated with values from the Project
     * @see AddProjectVersionRequest
     * @see Project
     */
    public AddProjectVersionRequest buildAddProjectVersionRequest(Project project) {
        ProjectVersion version = project.getVersionList().get(0);

        AddProjectVersionRequest request = new AddProjectVersionRequest()
                .withGroupName(project.getGroupName())
                .withArtifactName(project.getArtifactName())
                .withLanguageRoot(project.getLanguageRoot())
                .withVersion(version.getVersion())
                .withCreatedDateTime(version.getCreatedDateTime())
                .withBuildSource(version.getBuildSource());

        return request;
    }
}
