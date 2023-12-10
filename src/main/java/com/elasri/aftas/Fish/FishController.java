package com.elasri.aftas.Fish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fish")
public class FishController {
    @Autowired
    private FishService fishService;

    @PostMapping
    public ResponseEntity<FishRequest> saveFish(@RequestBody FishRequest fishRequest){
        FishRequest savedFish = fishService.saveFish(fishRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFish);
    }

    @GetMapping
    public ResponseEntity<List<FishResponse>> getAllFish(){
        List<FishResponse> fishResponseList = fishService.getAllFish();
        return ResponseEntity.ok(fishResponseList);
    }

    @GetMapping("{id}")
    public ResponseEntity<FishResponse> getFish(@PathVariable("id") Long id){
        FishResponse fishResponse = fishService.getFish(id);
        if (fishResponse != null){
            return ResponseEntity.ok(fishResponse);
        }else {
            return ResponseEntity.notFound().build();
        }
    }



    @DeleteMapping("{id}")
    public String deleteFish(@PathVariable("id") Long id){
        fishService.deleteFish(id);
        return "fish deleted successfully";
    }
}
