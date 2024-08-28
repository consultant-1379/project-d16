package com.team1.git.mining.persistence.repository;

import com.team1.git.mining.persistence.models.CommitList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommitListRepository extends MongoRepository<CommitList, String> {

}
