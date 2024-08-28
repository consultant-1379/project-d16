package com.team1.git.mining.persistence.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class CommitList {

    @Id
    private String id;
    private List<Commit> commitList;


    public CommitList() {
    }

    public CommitList(List<Commit> commitList) {
        this.commitList = commitList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Commit> getCommitList() {
        return commitList;
    }

    public void setCommitList(List<Commit> commitList) {
        this.commitList = commitList;
    }
}
