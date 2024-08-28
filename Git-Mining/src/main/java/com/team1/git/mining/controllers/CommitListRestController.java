package com.team1.git.mining.controllers;


import com.team1.git.mining.persistence.models.CommitList;
import com.team1.git.mining.persistence.repository.CommitListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


@Controller
@RequestMapping("/commitList")
@CrossOrigin
public class CommitListRestController {
    @Autowired
    private CommitListRepository repository;

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<CommitList> get(@PathVariable String id) {
        CommitList cl = repository.findById(id).get();
        if(cl!=null){
            return ResponseEntity.ok().body(cl);
        }else{
            return ResponseEntity.unprocessableEntity().body(cl);
        }
    }

    @PutMapping(value = "/update/{id}")
    public void /*FOR NOW*/ update(@RequestBody String id) {

    }
}
