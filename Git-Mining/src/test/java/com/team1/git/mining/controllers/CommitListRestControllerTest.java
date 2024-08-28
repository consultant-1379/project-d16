package com.team1.Git.Mining.controllers;

import com.team1.git.mining.persistence.models.CommitList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CommitListRestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;



//    @Test
//    public void get_CommitList_By_ID()	 {
//        ResponseEntity<CommitList> responseEntity = restTemplate.getForEntity("/commitList/get/633c38acacd410617cc27a60", CommitList.class);
//        assertEquals(2, responseEntity.getBody().getCommitList().size());
//        assertEquals("Kitara Stew", responseEntity.getBody().getCommitList().get(1).getContributorName());
//    }
}
