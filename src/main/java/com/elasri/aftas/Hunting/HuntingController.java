package com.elasri.aftas.Hunting;

import com.elasri.aftas.Level.LevelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hunting")
public class HuntingController {
    @Autowired
    private HuntingService huntingService;

    @PostMapping
    public ResponseEntity<HuntingRequest> saveHunting(@RequestBody HuntingRequest huntingRequest){
        HuntingRequest savedHunting = huntingService.createHunting(huntingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHunting);
    }

    @GetMapping
    public ResponseEntity<List<HuntingResponse>> getAllHunting(){
        List<HuntingResponse> huntingResponseList = huntingService.getAllHunting();
        return ResponseEntity.ok(huntingResponseList);
    }

    @GetMapping("{id}")
    public ResponseEntity<HuntingResponse> getHunting(@PathVariable("id") Long id){
        HuntingResponse huntingResponse = huntingService.getHunting(id);
        if (huntingResponse != null){
            return ResponseEntity.ok(huntingResponse);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public String deleteHunting(@PathVariable("id") Long id){
        huntingService.deleteHunting(id);
        return "Hunting deleted with success";
    }
}
