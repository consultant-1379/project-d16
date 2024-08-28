package com.team1.git.mining.persistence.repository;

import com.team1.git.mining.persistence.models.GitRepoList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GitRepoListRepository extends MongoRepository<GitRepoList, String> {
    //GitRepoList findByLink(String link);
    List<GitRepoList> findByLink(String link);
}
