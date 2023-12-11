package com.elasri.aftas.Hunting;

import com.elasri.aftas.Competition.Competition;
import com.elasri.aftas.Competition.CompetitionRepository;
import com.elasri.aftas.Fish.Fish;
import com.elasri.aftas.Fish.FishRepository;
import com.elasri.aftas.Member.Member;
import com.elasri.aftas.Member.MemberRepository;
import com.elasri.aftas.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HuntingServiceImpl implements HuntingService{
    @Autowired
    private HuntingRepository huntingRepository;
    @Autowired
    private FishRepository fishRepository;
    @Autowired
    private CompetitionRepository competitionRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public HuntingRequest createHunting(HuntingRequest huntingRequest) {
        Hunting hunting = modelMapper.map(huntingRequest, Hunting.class);
        Fish fish = fishRepository.findById(huntingRequest.getFish_id()).orElseThrow(()-> new ResourceNotFoundException("fish id " + huntingRequest.getFish_id()));
        Member member = memberRepository.findById(huntingRequest.getNum_member()).orElseThrow(()-> new ResourceNotFoundException("Member id " + huntingRequest.getNum_member()));
        Competition competition = competitionRepository.findById(huntingRequest.getCompetition_id()).orElseThrow(()-> new ResourceNotFoundException("Competition id " + huntingRequest.getCompetition_id()));
        hunting.setCompetition(competition);
        hunting.setFish(fish);
        hunting.setParticipant(member);
        Hunting savedHunting = huntingRepository.save(hunting);
        return modelMapper.map(savedHunting, HuntingRequest.class);
    }

    @Override
    public HuntingRequest updateHunting(HuntingRequest huntingRequest) {
        return null;
    }

    @Override
    public List<HuntingResponse> getAllHunting() {
        List<Hunting> huntingList = huntingRepository.findAll();
        return huntingList.stream().map(hunting -> modelMapper.map(hunting, HuntingResponse.class)).collect(Collectors.toList());
    }

    @Override
    public HuntingResponse getHunting(Long id) {
        Optional<Hunting> optionalHunting = huntingRepository.findById(id);
        return optionalHunting.map(hunting -> modelMapper.map(hunting, HuntingResponse.class)).orElseThrow(()-> new ResourceNotFoundException("hunting id " + id));
    }

    @Override
    public void deleteHunting(Long id) {
        huntingRepository.deleteById(id);
    }
}
