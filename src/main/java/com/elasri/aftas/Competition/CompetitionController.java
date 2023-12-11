package com.elasri.aftas.Competition;

import com.elasri.aftas.Fish.FishResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/competition")
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;

    @PostMapping
    public ResponseEntity<CompetitionRequest> createCompetition(@RequestBody CompetitionRequest competitionRequest){
        CompetitionRequest savedCompetitionRequest = competitionService.createCompetition(competitionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompetitionRequest);
    }

    @GetMapping
    public ResponseEntity<List<CompetitionResponse>> getAllCompetitions(){
        List<CompetitionResponse> competitionResponseList = competitionService.getAllCompetition();
        return ResponseEntity.ok(competitionResponseList);
    }

    @GetMapping("{id}")
    public ResponseEntity<CompetitionResponse> getCompetition(@PathVariable("id") Long id){
        CompetitionResponse competitionResponse = competitionService.getCompetition(id);
        if (competitionResponse != null){
            return ResponseEntity.ok(competitionResponse);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public String deleteCompetition(@PathVariable("id") Long id){
        competitionService.deleteCompetition(id);
        return "Competition deleted with success";
    }
}
