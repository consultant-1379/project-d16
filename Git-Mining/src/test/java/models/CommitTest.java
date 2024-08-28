package models;

import com.team1.git.mining.persistence.models.Commit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CommitTest {

    static Commit commit;
    @BeforeAll
    static void init (){
        commit = new Commit("1", "2", "3", 4, 5, 6, "7");
    }

    @Test
    public void DefaultConstructor(){
        Commit c = new Commit();
        assertInstanceOf(Commit.class, c);
    }

    @Test
    public void ParameterConstructor(){
        Commit c = new Commit("1", "2", "3", 4, 5, 6, "7");
        assertInstanceOf(Commit.class, c);
        assertEquals("1", c.getDate());
    }

    @Test
    public void getDate(){
        assertEquals( "1" , commit.getDate());
    }

    @Test
    public void setDate(){
        commit.setDate("date");
        assertEquals( "date" , commit.getDate());
    }

    @Test
    public void getContributorName() {
        assertEquals( "2" , commit.getContributorName());
    }

    @Test
    public void setContributorName() {
        commit.setContributorName("name");
        assertEquals( "name" , commit.getContributorName());
    }

    @Test
    public void getContributorEmail() {
        assertEquals( "3" , commit.getContributorEmail());
    }

    @Test
    public void setContributorEmail() {
        commit.setContributorEmail("email");
        assertEquals( "email" , commit.getContributorEmail());
    }

    @Test
    public void getLinesAdded() {
        assertEquals( 4 , commit.getLinesAdded());
    }

    @Test
    public void setLinesAdded() {
        commit.setLinesAdded(5318008);
        assertEquals( 5318008 , commit.getLinesAdded());
    }

    @Test
    public void getLinesRemoved() {
        commit.setLinesRemoved(5);
        assertEquals( 5 , commit.getLinesRemoved());
    }

    @Test
    public void setLinesRemoved() {
        commit.setLinesRemoved(5318008);
        assertEquals( 5318008 , commit.getLinesRemoved());
    }

    @Test
    public void getFilesCommitted() {
        assertEquals( 6 , commit.getFilesCommitted());
    }

    @Test
    public void setFilesCommitted() {
        commit.setFilesCommitted(5318008);
        assertEquals( 5318008 , commit.getFilesCommitted());
    }

    @Test
    public void getHash() {
        assertEquals( "7" , commit.getHash());
    }

    @Test
    public void setHash() {
        commit.setHash("hash");
        assertEquals( "hash" , commit.getHash());
    }

}
