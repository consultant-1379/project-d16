package com.team1.git.mining.persistence.repository;

import com.team1.git.mining.persistence.models.GitHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GitHistoryRepository extends MongoRepository<GitHistory, String> {
    List<GitHistory> findByProjectName(String projectName);
}
