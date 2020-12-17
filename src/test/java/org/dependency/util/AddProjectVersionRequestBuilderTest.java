package org.dependency.util;

import org.dependency.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AddProjectVersionRequestBuilderTest {
    public static final String GROUP_ID = "com.test.groupid";
    public static final String ARTIFACT_ID = "test-artifact";
    public static final LanguageRoot LANGUAGE_ROOT = LanguageRoot.JAVA;
    public static final String VERSION = "0.0.1-SNAPSHOT";
    public static final OffsetDateTime BUILD_DATE_TIME = OffsetDateTime.now();
    public static final BuildSource BUILD_SOURCE = BuildSource.PERSONAL;

    private AddProjectVersionRequestBuilder builder;
    private AddProjectVersionRequest goodRequest;

    @BeforeEach
    public void setUp() {
        builder = new AddProjectVersionRequestBuilder();

        goodRequest = new AddProjectVersionRequest()
                .withGroupName(GROUP_ID)
                .withArtifactName(ARTIFACT_ID)
                .withLanguageRoot(LANGUAGE_ROOT)
                .withVersion(VERSION)
                .withCreatedDateTime(BUILD_DATE_TIME)
                .withBuildSource(BUILD_SOURCE);
    }

    @DisplayName("Can create a Project from an AddProjectVersionRequest")
    @Test
    public void buildProject() {
        Project project = builder.buildProject(goodRequest);
        assertEquals(GROUP_ID, project.getGroupName());
        assertEquals(ARTIFACT_ID, project.getArtifactName());
        assertEquals(LANGUAGE_ROOT, project.getLanguageRoot());
        assertFalse(project.isProjectSunset());

        List<ProjectVersion> versionList = project.getVersionList();
        assertEquals(1, versionList.size());
        ProjectVersion version = versionList.get(0);

        assertEquals(VERSION, version.getVersion());
        assertEquals(BUILD_DATE_TIME, version.getCreatedDateTime());
        assertEquals(BUILD_SOURCE, version.getBuildSource());
        assertFalse(version.isVersionSunset());
        assertTrue(version.getDependencyList().isEmpty());
    }

    @DisplayName("Can convert Project to AddProjectVersionRequest and back again.")
    @Test
    public void buildAddProjectVersionRequest() {
        Project project = builder.buildProject(goodRequest);
        AddProjectVersionRequest request = builder.buildAddProjectVersionRequest(project);
        assertEquals(goodRequest, request);
    }
}
