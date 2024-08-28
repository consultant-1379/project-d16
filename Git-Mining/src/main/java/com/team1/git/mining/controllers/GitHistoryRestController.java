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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.team1.git.mining.utils.UtilsFunctions.writeToGitHistory;

@Controller
@RequestMapping("/gitHistory")
@CrossOrigin("http://localhost:8080")
public class GitHistoryRestController {
    @Autowired
    private GitHistoryRepository repository;
    @Autowired
    private GitRepoListRepository repositoryList;
    @Autowired
    private CommitListRepository listRepository;



    @PostMapping(value="/add/{link}_{startDate}_{endDate}")
    public ResponseEntity<GitRepoList> add(@PathVariable String link, @PathVariable String startDate, @PathVariable String endDate) {
            String timeNow =  LocalDateTime.now().toString();
            GitRepoList grl = new GitRepoList(link, startDate, endDate, timeNow);
            GitRepoList entry = repositoryList.insert(grl);

            if (entry != null) {
                writeToGitHistory(link, startDate, endDate, timeNow);
                return ResponseEntity.ok().body(entry);
            } else {
                return ResponseEntity.unprocessableEntity().body(entry);
            }

    }

    @PostMapping(value = "/delete", consumes={"text/plain;charset=UTF-8","application/json","application/xml", "text/char"})
    public ResponseEntity<?>/*ResponseEntity<GitHistory>*/ delete(@RequestBody String link) {
        link = link.substring(1,link.length() -1 );

        List<GitRepoList> g =  repositoryList.findByLink(link);
        repositoryList.deleteAll(g);
        List<GitHistory> l = repository.findByProjectName(g.get(0).getProjectName());
        repository.deleteAll(l);

        return new ResponseEntity<>(l.get(0), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/get", consumes={"text/plain;charset=UTF-8","application/json","application/xml", "text/char"})
    public ResponseEntity<?>/*ResponseEntity<GitHistory>*/ get(@RequestBody String link) {
        //return ResponseEntity.ok().body(repository.findByProjectName(repositoryList.findByLink(link).getProjectName()).get(0));
        link = link.substring(1,link.length() -1 );



        List<GitRepoList> g =  repositoryList.findByLink(link);
        List<GitHistory> l = repository.findByProjectName(g.get(0).getProjectName());
        //R
        return new ResponseEntity<>(l.get(0), HttpStatus.ACCEPTED);
        //return ResponseEntity.ok().body(repository.findByProjectName(repositoryList.findByLink(link).getProjectName()).get(0));
    }

    @PutMapping(value = "/update/{id}")
    public void /*FOR NOW*/ update(@PathVariable String id) {

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
            repositoryList.save(repoList);
        }
    }


}
