package com.elasri.aftas.Member;

import com.elasri.aftas.Fish.Fish;
import com.elasri.aftas.Fish.FishResponse;
import com.elasri.aftas.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public MemberRequest saveMember(MemberRequest memberRequest) {
        Member member = modelMapper.map(memberRequest, Member.class);
        Member savedMember = memberRepository.save(member);
        return modelMapper.map(savedMember, MemberRequest.class);
    }

    @Override
    public MemberRequest updateMember(MemberRequest memberRequest) {
        return null;
    }

    @Override
    public List<MemberResponse> getAllMembers() {
        List<Member> memberList = memberRepository.findAll();
        return memberList.stream().map(member -> modelMapper.map(member, MemberResponse.class)).collect(Collectors.toList());
    }

    @Override
    public MemberResponse getMember(Integer num) {
        Optional<Member> optionalMember = memberRepository.findById(num);
        return optionalMember.map(member -> modelMapper.map(member, MemberResponse.class)).orElseThrow(()-> new ResourceNotFoundException("id fish : " + num));
    }

    @Override
    public void deleteMember(Integer num) {
        memberRepository.deleteById(num);
    }
}
