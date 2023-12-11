package com.elasri.aftas.Member;

import com.elasri.aftas.Fish.FishResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberRequest> saveMember(@RequestBody MemberRequest memberRequest){
        MemberRequest savedMember = memberService.saveMember(memberRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers(){
        List<MemberResponse> memberResponseList = memberService.getAllMembers();
        return ResponseEntity.ok(memberResponseList);
    }

    @GetMapping("{num}")
    public ResponseEntity<MemberResponse> getMember(@PathVariable("num") Integer num){
        MemberResponse memberResponse = memberService.getMember(num);
        if (memberResponse != null){
            return ResponseEntity.ok(memberResponse);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{num}")
    public String deleteMember(@PathVariable("num") Integer num){
        memberService.deleteMember(num);
        return "member deleted with success";
    }
}
