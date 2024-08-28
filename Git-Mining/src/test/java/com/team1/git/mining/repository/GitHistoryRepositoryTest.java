package com.team1.git.mining.repository;

import com.team1.git.mining.persistence.models.GitHistory;
import com.team1.git.mining.persistence.repository.GitHistoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GitHistoryRepositoryTest {
    @Autowired
    GitHistoryRepository repository;

    GitHistory gitHistory, gitHistory1;

    @BeforeEach
    public void init(){
        gitHistory = new GitHistory("Test 1");
        gitHistory1 = new GitHistory("Test 2");
        repository.save(gitHistory);
        repository.save(gitHistory1);
    }

    @AfterEach
    public void close(){
        repository.delete(gitHistory);
        repository.delete(gitHistory1);
    }

    @Test
    public void testFindByProjectName(){
        List<GitHistory> test = repository.findByProjectName("Test 1");
        List<GitHistory> test1 = repository.findByProjectName("Test 2");

        assertThat(gitHistory.equals(test1));
        System.out.println(assertGitHistoryEquals(gitHistory1, test.get(0)));
    }

    private boolean assertGitHistoryEquals(GitHistory expected, GitHistory actual){
        return expected.getId().equals(actual.getId()) && expected.getProjectName().equals(actual.getProjectName());
    }
}
