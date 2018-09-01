package com.example.worldskills.tsppspmobile.models;

public class DefectLog {
    private String injected;
    private String removed;
    private int idProject;

    public DefectLog() {
    }

    public String getInjected() {
        return injected;
    }

    public void setInjected(String injected) {
        this.injected = injected;
    }

    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }
}
