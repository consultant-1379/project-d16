package com.team1.git.mining.controllers;

import com.team1.git.mining.persistence.models.GitHistory;
import com.team1.git.mining.persistence.models.GitRepoList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GitHistoryRestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private GitHistory history;
    private  GitRepoList repoList;

    @BeforeAll
    static void init(){

    }





    @Test
    public void add_GitHistory()	 {
        ResponseEntity<GitRepoList> responseEntity = restTemplate.postForEntity("/gitHistory/add/kitara.com_06-12-1998_14-06-2000", GitRepoList.class, GitRepoList.class);
        assertEquals("kitara.com", responseEntity.getBody().getLink());
    }


    /*@Test
    public void delete_GitHistory()	 {
        ResponseEntity<GitRepoList> responseEntity = restTemplate.postForEntity("/gitHistory/delete/kitara.com_06-12-1998_14-06-2000", GitRepoList.class, GitRepoList.class);
        assertEquals("kitara.com", responseEntity.getBody().getLink());
    }

    @Test
    public void get_GitHistory_By_ID()	 {
        ///ResponseEntity<GitHistory> responseEntity = restTemplate.getForEntity("/gitHistory/get/https://ebeisea@gerrit.ericsson.se/a/OSS/ENM-Parent/SQ-Gate/com.ericsson.graduates/project-d16", GitHistory.class);
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("/gitHistory/get", "gg", String.class);
        assertEquals('"' + "gg" + '"', responseEntity.getBody());
    }*/

}
