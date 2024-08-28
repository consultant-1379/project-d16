package com.team1.git.mining.controllers;

import com.team1.git.mining.persistence.models.Commit;
import com.team1.git.mining.persistence.models.CommitList;
import com.team1.git.mining.persistence.models.GitHistory;
import com.team1.git.mining.persistence.models.GitRepoList;
import com.team1.git.mining.persistence.repository.CommitListRepository;
import com.team1.git.mining.persistence.repository.GitHistoryRepository;
import com.team1.git.mining.persistence.repository.GitRepoListRepository;
import com.team1.git.mining.utils.ReadCSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GitHistoryController {

    @Autowired
    private GitHistoryRepository repository;
    @Autowired
    private CommitListRepository listRepository;
    @Autowired
    private GitRepoListRepository repoListRepository;

    public void saveInfoMap(){
        System.out.println();
    }

    @GetMapping(value = "/csv")
    public void get() {
        for(GitHistory g: ReadCSV.gitHistory){
            List<GitHistory> exists =repository.findByProjectName(g.getProjectName());
            if(exists.size() > 0){
                repository.deleteAll(exists);
            }
            repository.save(g);
        }
        for(List<String[]> c: ReadCSV.commits){
            List<Commit> commits = new ArrayList<>();
            for(String[] s: c){
                commits.add(new Commit(s[0],s[1],s[2],Long.valueOf(s[3]),Long.valueOf(s[4]),
                        Long.valueOf(s[5]), s[6]));
            }
            System.out.println(commits);
            listRepository.save(new CommitList(commits));
        }

        for(GitRepoList repoList: ReadCSV.list){
            repoListRepository.save(repoList);
        }
    }



}
