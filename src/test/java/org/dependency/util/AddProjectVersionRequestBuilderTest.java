package org.dependency.util;

import org.dependency.domain.AddProjectVersionRequest;
import org.dependency.domain.LanguageRoot;
import org.dependency.domain.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddProjectVersionRequestBuilderTest {
    public static final String GROUP_ID = "com.test.groupid";
    public static final String ARTIFACT_ID = "test-artifact";
    public static final LanguageRoot LANGUAGE_ROOT = LanguageRoot.JAVA;

    private AddProjectVersionRequestBuilder builder;
    private AddProjectVersionRequest goodRequest;

    @BeforeEach
    public void setUp() {
        builder = new AddProjectVersionRequestBuilder();

        goodRequest = new AddProjectVersionRequest()
                .withGroupName(GROUP_ID)
                .withArtifactName(ARTIFACT_ID)
                .withLanguageRoot(LANGUAGE_ROOT);
    }

    @DisplayName("Can create a Project from an AddProjectVersionRequest")
    @Test
    public void buildProject() {
        Project project = builder.buildProject(goodRequest);
        assertEquals(GROUP_ID, project.getGroupName());
        assertEquals(ARTIFACT_ID, project.getArtifactName());
        assertEquals(LANGUAGE_ROOT, project.getLanguageRoot());
        assertTrue(project.getVersionList().isEmpty());
        assertFalse(project.isProjectSunset());
    }

    @DisplayName("Can convert Project to AddProjectVersionRequest and back again.")
    @Test
    public void buildAddProjectVersionRequest() {
        Project project = builder.buildProject(goodRequest);
        AddProjectVersionRequest request = builder.buildAddProjectVersionRequest(project);
        assertEquals(goodRequest, request);
    }
}
