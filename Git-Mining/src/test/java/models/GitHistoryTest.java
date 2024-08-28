package models;

import com.team1.git.mining.persistence.models.GitHistory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class GitHistoryTest {

    static GitHistory gitHistory;

    @BeforeAll
    static void init (){
        gitHistory = new GitHistory("1", "2", "3", 4, 5,
        6, 7, 8, 9, 10,
        11, 12, 13, 14);
    }
    @Test
    public void DefaultConstructor(){
        GitHistory g = new GitHistory();
        assertInstanceOf(GitHistory.class, g);
    }

    @Test
    public void FullyParameterConstructor(){
        GitHistory g = new GitHistory("1", "2", "3", 4, 5,
                6, 7, 8, 9, 10,
                11, 12, 13, 14);
        assertInstanceOf(GitHistory.class, g);
        assertEquals("1", g.getProjectName());
    }

    @Test
    public void SemiParameterConstructor(){
        GitHistory g = new GitHistory("1");
        assertInstanceOf(GitHistory.class, g);
        assertEquals("1", g.getProjectName());
    }



    @Test
    public void getId() {
        gitHistory.setId("get");
        assertEquals("get", gitHistory.getId());
    }

    @Test
    public void setId() {
        gitHistory.setId("set");
        assertEquals("set", gitHistory.getId());
    }

    @Test
    public void isActive() {
        assertEquals(true, gitHistory.isActive());
    }

    @Test
    public void setActive() {
        gitHistory.setActive(false);
        assertEquals(false, gitHistory.isActive());
    }

    @Test
    public void getProjectName() {
        assertEquals("1", gitHistory.getProjectName());
    }

    @Test
    public void setProjectName() {
        gitHistory.setProjectName("project");
        assertEquals("project", gitHistory.getProjectName());
    }


    @Test
    public void getInitialCommit() {
        assertEquals("2", gitHistory.getInitialCommit());
    }

    @Test
    public void setInitialCommit() {
        gitHistory.setInitialCommit("init");
        assertEquals("init", gitHistory.getInitialCommit());
    }

    @Test
    public void getLatestCommit() {
        gitHistory.setLatestCommit("3");
        assertEquals("3", gitHistory.getLatestCommit());
    }

    @Test
    public void setLatestCommit() {
        gitHistory.setLatestCommit("latest");
        assertEquals("latest", gitHistory.getLatestCommit());
    }

    @Test
    public void getCommitsNum() {
        assertEquals(4, gitHistory.getCommitsNum());
    }

    @Test
    public void setCommitsNum() {
        gitHistory.setCommitsNum(5138008);
        assertEquals(5138008, gitHistory.getCommitsNum());
    }

    @Test
    public void getLinesAdded() {
        assertEquals(5, gitHistory.getLinesAdded());
    }

    @Test
    public void setLinesAdded() {
        gitHistory.setLinesAdded(5138008);
        assertEquals(5138008, gitHistory.getLinesAdded());
    }

    @Test
    public void getLinesRemoved() {
        gitHistory.setLinesRemoved(6);
        assertEquals(6, gitHistory.getLinesRemoved());
    }

    @Test
    public void setLinesRemoved() {
        gitHistory.setLinesRemoved(5138008);
        assertEquals(5138008, gitHistory.getLinesRemoved());
    }

    @Test
    public void getChangeSetAvg() {
        gitHistory.setChangeSetAvg(7);
        assertEquals(7, gitHistory.getChangeSetAvg());
    }

    @Test
    public void setChangeSetAvg() {
        gitHistory.setChangeSetAvg(5138008);
        assertEquals(5138008, gitHistory.getChangeSetAvg());
    }

    @Test
    public void getChangeSetMax() {
        gitHistory.setChangeSetMax(8);
        assertEquals(8, gitHistory.getChangeSetMax());
    }

    @Test
    public void setChangeSetMax() {
        gitHistory.setChangeSetMax(5138008);
        assertEquals(5138008, gitHistory.getChangeSetMax());
    }

    @Test
    public void getChurnCount() {
        gitHistory.setChurnCount(9);
        assertEquals(9, gitHistory.getChurnCount());
    }

    @Test
    public void setChurnCount() {
        gitHistory.setChurnCount(5138008);
        assertEquals(5138008, gitHistory.getChurnCount());
    }

    @Test
    public void getChurnAvg() {
        gitHistory.setChurnAvg(10);
        assertEquals(10, gitHistory.getChurnAvg());
    }

    @Test
    public void setChurnAvg() {
        gitHistory.setChurnAvg(5138008);
        assertEquals(5138008, gitHistory.getChurnAvg());
    }

    @Test
    public void getChurnMax() {
        gitHistory.setChurnMax(11);
        assertEquals(11, gitHistory.getChurnMax());
    }

    @Test
    public void setChurnMax() {
        gitHistory.setChurnMax(5138008);
        assertEquals(5138008, gitHistory.getChurnMax());
    }

    @Test
    public void getContributorsCount() {
        gitHistory.setContributorsCount(12);
        assertEquals(12, gitHistory.getContributorsCount());
    }

    @Test
    public void setContributorsCount() {
        gitHistory.setContributorsCount(5138008);
        assertEquals(5138008, gitHistory.getContributorsCount());
    }

    @Test
    public void getContributorsMinor() {
        gitHistory.setContributorsMinor(13);
        assertEquals(13, gitHistory.getContributorsMinor());
    }

    @Test
    public void setContributorsMinor() {
        gitHistory.setContributorsMinor(5138008);
        assertEquals(5138008, gitHistory.getContributorsMinor());
    }

    @Test
    public void getHunks() {
        gitHistory.setHunks(14);
        assertEquals(14, gitHistory.getHunks());
    }

    @Test
    public void setHunks() {
        gitHistory.setHunks(5138008);
        assertEquals(5138008, gitHistory.getHunks());
    }


}
