package com.team1.git.mining.persistence.models;

import java.util.HashMap;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GitHistory {
    @Id
    private String id;
    private boolean active = true;
    private String projectName = "";
    private String initialCommit;
    private String latestCommit;
    private int commitsNum;

    private long linesAdded;
    private long linesRemoved;
    private float changeSetAvg;
    private int changeSetMax;
    private long churnCount;
    private float churnAvg;
    private long churnMax;
    private int contributorsCount;
    private int contributorsMinor;
    private float hunks;
    private HashMap<String, Integer> contributions = new HashMap<>();


    public GitHistory() {
    }

    public GitHistory(String projectName) {
        this.projectName = projectName;
    }

    public GitHistory(String projectName, String initialCommit, String latestCommit, int commitsNum, long linesAdded,
                      long linesRemoved, float changeSetAvg, int changeSetMax, long churnCount, long churnMax,
                      float churnAvg, int contributorsCount, int contributorsMinor, float hunks) {
        this.projectName = projectName;
        this.initialCommit = initialCommit;
        this.latestCommit = latestCommit;
        this.commitsNum = commitsNum;
        this.linesAdded = linesAdded;
        this.linesRemoved = linesRemoved;
        this.changeSetAvg = changeSetAvg;
        this.changeSetMax = changeSetMax;
        this.churnCount = churnCount;
        this.churnMax = churnMax;
        this.churnAvg = churnAvg;
        this.contributorsCount = contributorsCount;
        this.contributorsMinor = contributorsMinor;
        this.hunks = hunks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getInitialCommit() {
        return initialCommit;
    }

    public void setInitialCommit(String initialCommit) {
        this.initialCommit = initialCommit;
    }

    public String getLatestCommit() {
        return latestCommit;
    }

    public void setLatestCommit(String latestCommit) {
        this.latestCommit = latestCommit;
    }

    public int getCommitsNum() {
        return commitsNum;
    }

    public void setCommitsNum(int commitsNum) {
        this.commitsNum = commitsNum;
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

    public float getChangeSetAvg() {
        return changeSetAvg;
    }

    public void setChangeSetAvg(float changeSetAvg) {
        this.changeSetAvg = changeSetAvg;
    }

    public int getChangeSetMax() {
        return changeSetMax;
    }

    public void setChangeSetMax(int changeSetMax) {
        this.changeSetMax = changeSetMax;
    }

    public long getChurnCount() {
        return churnCount;
    }

    public void setChurnCount(long churnCount) {
        this.churnCount = churnCount;
    }

    public float getChurnAvg() {
        return churnAvg;
    }

    public void setChurnAvg(float churnAvg) {
        this.churnAvg = churnAvg;
    }

    public long getChurnMax() {
        return churnMax;
    }

    public void setChurnMax(long churnMax) {
        this.churnMax = churnMax;
    }

    public int getContributorsCount() {
        return contributorsCount;
    }

    public void setContributorsCount(int contributorsCount) {
        this.contributorsCount = contributorsCount;
    }

    public int getContributorsMinor() {
        return contributorsMinor;
    }

    public void setContributorsMinor(int contributorsMinor) {
        this.contributorsMinor = contributorsMinor;
    }

    public float getHunks() {
        return hunks;
    }

    public void setHunks(float hunks) {
        this.hunks = hunks;
    }


}
