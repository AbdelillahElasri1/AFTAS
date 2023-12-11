package com.elasri.aftas.Ranking;

import com.elasri.aftas.Hunting.HuntingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rankings")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    @PostMapping
    public ResponseEntity<RankingRequest> saveRanking(@RequestBody RankingRequest rankingRequest){
        RankingRequest savedRanking = rankingService.saveRanking(rankingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRanking);
    }

    @GetMapping
    public ResponseEntity<List<RankingResponse>> getAllRankings(){
        List<RankingResponse> rankingResponseList = rankingService.getAllRankings();
        return ResponseEntity.ok(rankingResponseList);
    }

    @GetMapping("{id}")
    public ResponseEntity<RankingResponse> getRanking(@PathVariable("id") Long id){
        RankingResponse rankingResponse = rankingService.getRanking(id);
        if (rankingResponse != null){
            return ResponseEntity.ok(rankingResponse);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public String deleteRanking(@PathVariable("id") Long id){
        rankingService.deleteRanking(id);
        return "ranking deleted with success";
    }
}
