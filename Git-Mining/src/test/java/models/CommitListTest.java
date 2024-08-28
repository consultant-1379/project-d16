package models;

import com.team1.git.mining.persistence.models.Commit;
import com.team1.git.mining.persistence.models.CommitList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class CommitListTest {

    static CommitList commitList;

    @BeforeAll
    static void init (){
        ArrayList<Commit> list = new ArrayList<>();
        list.add(new Commit());
        list.add(new Commit());
        commitList = new CommitList(list);
    }



    @Test
    public void DefaultConstructor(){
        CommitList c = new CommitList();
        assertInstanceOf(CommitList.class, c);
    }

    @Test
    public void ParameterConstructor(){
        ArrayList<Commit> list = new ArrayList<>();
        list.add(new Commit());
        list.add(new Commit());
        CommitList c = new CommitList(list);
        assertInstanceOf(CommitList.class, c);
        assertEquals(2, c.getCommitList().size());
    }


    @Test
    public void setId() {
        commitList.setId("set");
        assertEquals( "set" , commitList.getId());
    }

    @Test
    public void getId() {
        commitList.setId("get");
        assertEquals( "get" , commitList.getId());
    }

    @Test
    public void getCommitList() {
        assertEquals( 2 , commitList.getCommitList().size());
    }

    @Test
    public void setCommitList() {
        ArrayList<Commit> list = new ArrayList<>();
        commitList.setCommitList(list);
        assertEquals( 0 , commitList.getCommitList().size());
    }

}
