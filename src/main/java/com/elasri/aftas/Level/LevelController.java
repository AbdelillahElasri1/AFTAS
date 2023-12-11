package com.elasri.aftas.Level;

import com.elasri.aftas.Member.MemberResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/level")
public class LevelController {
    @Autowired
    private LevelService levelService;

    @PostMapping
    public ResponseEntity<LevelRequest> createLevel(@RequestBody LevelRequest levelRequest){
        LevelRequest savedLevel = levelService.createLevel(levelRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLevel);
    }
    @GetMapping
    public ResponseEntity<List<LevelResponse>> getAllLevels(){
        List<LevelResponse> levelResponseList = levelService.getAllLevels();
        return ResponseEntity.ok(levelResponseList);
    }
    @GetMapping("{code}")
    public ResponseEntity<LevelResponse> getLevel(@PathVariable("code") Integer code){
        LevelResponse levelResponse = levelService.getLevel(code);
        if (levelResponse != null){
            return ResponseEntity.ok(levelResponse);
        }else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{code}")
    public String deleteLevel(@PathVariable("code") Integer code){
        levelService.deleteLevel(code);
        return "level deleted with success";
    }
}
