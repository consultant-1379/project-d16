package com.team1.git.mining.persistence.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class GitRepoList {
    @Id
    String id;
    String projectName;
    String link;
    String startDate;
    String endDate;
    String lastUpdated;

    public GitRepoList() {
    }

    public GitRepoList(String projectName, String link, String startDate, String endDate, String lastUpdated) {
        this.projectName = projectName;
        this.link = link;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastUpdated = lastUpdated;
    }

    public GitRepoList(String link, String startDate, String endDate, String lastUpdated) {
        this.projectName = projectName;
        this.link = link;
        this.startDate = startDate;
        this.endDate = endDate;
        this.lastUpdated = lastUpdated;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
