package com.team1.git.mining.persistence.models;

public class Commit{
    private String date;
    private String contributorName;
    private String contributorEmail;
    private long linesAdded;

    private long linesRemoved;
    private long filesCommitted;
    private String hash;

    public Commit() {
    }

    public Commit(String date, String contributorName, String contributorEmail, long linesAdded, long linesRemoved, long filesCommitted, String hash) {
        this.date = date;
        this.contributorName = contributorName;
        this.contributorEmail = contributorEmail;
        this.linesAdded = linesAdded;
        this.linesRemoved = linesRemoved;
        this.filesCommitted = filesCommitted;
        this.hash = hash;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContributorName() {
        return contributorName;
    }

    public void setContributorName(String contributorName) {
        this.contributorName = contributorName;
    }

    public String getContributorEmail() {
        return contributorEmail;
    }

    public void setContributorEmail(String contributorEmail) {
        this.contributorEmail = contributorEmail;
    }

    public long getLinesAdded() {
        return linesAdded;
    }

    public void setLinesAdded(long linesAdded) {
        this.linesAdded = linesAdded;
    }

    public long getLinesRemoved() {
        return linesRemoved;
    }

    public void setLinesRemoved(long linesRemoved) {
        this.linesRemoved = linesRemoved;
    }

    public long getFilesCommitted() {
        return filesCommitted;
    }

    public void setFilesCommitted(long filesCommitted) {
        this.filesCommitted = filesCommitted;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
