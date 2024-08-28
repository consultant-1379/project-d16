package models;

import com.team1.git.mining.persistence.models.GitRepoList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class GitRepoListTest {

    static GitRepoList gitRepoList;

    @BeforeAll
    static void init (){
        gitRepoList = new GitRepoList("1","2","3","4","5");
    }



    @Test
    public void DefaultConstructor(){
        GitRepoList g = new GitRepoList();
        assertInstanceOf(GitRepoList.class, g);
    }

    @Test
    public void FullyParameterConstructor(){
        GitRepoList g = new GitRepoList("1","2","3","4","5");
        assertInstanceOf(GitRepoList.class, g);
        assertEquals("1", g.getProjectName());
    }

    @Test
    public void SemiParameterConstructor(){
        GitRepoList g = new GitRepoList("1","2","3","4");
        assertInstanceOf(GitRepoList.class, g);
        assertEquals("1", g.getLink());
    }


    @Test
    public void getId() {
        gitRepoList.setId("get");
        assertEquals("get", gitRepoList.getId());
    }

    @Test
    public void setId() {
        gitRepoList.setId("set");
        assertEquals("set", gitRepoList.getId());
    }


    @Test
    public void getProjectName() {
        assertEquals("1", gitRepoList.getProjectName());
    }

    @Test
    public void setProjectName() {
        gitRepoList.setProjectName("project");
        assertEquals("project", gitRepoList.getProjectName());
    }

    @Test
    public void getLink() {
        assertEquals("2", gitRepoList.getLink());
    }

    @Test
    public void setLink() {
        gitRepoList.setLink("link");
        assertEquals("link", gitRepoList.getLink());
    }

    @Test
    public void getStartDate() {
        assertEquals("3", gitRepoList.getStartDate());
    }

    @Test
    public void setStartDate() {
        gitRepoList.setStartDate("start");
        assertEquals("start", gitRepoList.getStartDate());
    }

    @Test
    public void getEndDate() {
        assertEquals("4", gitRepoList.getEndDate());
    }

    @Test
    public void setEndDate() {
        gitRepoList.setEndDate("end");
        assertEquals("end", gitRepoList.getEndDate());
    }

    @Test
    public void getLastUpdated() {
        gitRepoList.setLastUpdated("5");
        assertEquals("5", gitRepoList.getLastUpdated());
    }

    @Test
    public void setLastUpdated() {
        gitRepoList.setLastUpdated("last");
        assertEquals("last", gitRepoList.getLastUpdated());
    }

}
