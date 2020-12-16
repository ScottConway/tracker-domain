package org.dependency.util;

import org.dependency.domain.AddProjectVersionRequest;
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
        return versionList;
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
        AddProjectVersionRequest request = new AddProjectVersionRequest()
                .withGroupName(project.getGroupName())
                .withArtifactName(project.getArtifactName())
                .withLanguageRoot(project.getLanguageRoot());
        return request;
    }
}
