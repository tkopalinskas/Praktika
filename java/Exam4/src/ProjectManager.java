import lt.itakademija.exam.Issue;
import lt.itakademija.exam.Project;

import java.util.ArrayList;
import java.util.Collection;

public class ProjectManager implements lt.itakademija.exam.ProjectManager {

    Collection<Project> projects = new ArrayList<>();

    @Override
    public Project createProject(String id, String summary) {
        if (id.isEmpty() || summary.isEmpty()){
            throw new IllegalArgumentException();
        }
        Project newProject = new Project(id, summary);
        projects.add(newProject);

        return newProject;
    }

    @Override
    public Collection<Project> getProjects() {
        return projects;
    }

    @Override
    public Project getProjectById(String id) {
        Project projectToReturn = null;

        for (Project project : projects) {
            if (project.getId().equals(id)) {
                projectToReturn = project;
            }
        }

        return projectToReturn;
    }

    @Override
    public Issue createIssue(Project project, String summary) {

        if (project== null || summary == null){
            throw new NullPointerException();
        } else if (summary.isEmpty()){
            throw new IllegalArgumentException();
        }

        Issue newIssue = new Issue(project,summary);
       project.addIssue(newIssue);
        return newIssue;
    }

    @Override
    public Issue createIssue(String projectId, String issueSummary) {

        if (projectId == null || issueSummary == null){
            throw new NullPointerException();
        } else if ( projectId.isEmpty() || issueSummary.isEmpty()){
            throw new IllegalArgumentException();
        }

        return new Issue(getProjectById(projectId),issueSummary);
    }

    @Override
    public Collection<Issue> getIssues(Project project) {
        return project.getIssues();
    }

    @Override
    public Collection<Issue> getIssues(String s) {
        return getProjectById(s).getIssues();
    }
}
