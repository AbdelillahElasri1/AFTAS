package com.elasri.aftas.Ranking;

import com.elasri.aftas.Competition.Competition;
import com.elasri.aftas.Competition.CompetitionRepository;
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
public class RankingServiceImpl implements RankingService{
    @Autowired
    private RankingRepository rankingRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private CompetitionRepository competitionRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public RankingRequest saveRanking(RankingRequest rankingRequest) {
        Ranking ranking = modelMapper.map(rankingRequest, Ranking.class);
        Member member = memberRepository.findById(rankingRequest.getNum_member())
                .orElseThrow(()-> new ResourceNotFoundException("member id : " + rankingRequest.getNum_member()));
        Competition competition = competitionRepository.findById(rankingRequest.getCompetition_id())
                .orElseThrow(()-> new ResourceNotFoundException("competition id " + rankingRequest.getCompetition_id()));
        ranking.setMember(member);
        ranking.setCompetition(competition);
        Ranking savedRanking = rankingRepository.save(ranking);
        return modelMapper.map(savedRanking, RankingRequest.class);
    }

    @Override
    public RankingRequest updateRanking(RankingRequest rankingRequest) {
        return null;
    }

    @Override
    public List<RankingResponse> getAllRankings() {
        List<Ranking> rankingList = rankingRepository.findAll();
        return rankingList.stream().map(ranking -> modelMapper.map(ranking, RankingResponse.class)).collect(Collectors.toList());
    }

    @Override
    public RankingResponse getRanking(Long id) {
        Optional<Ranking> optionalRanking = rankingRepository.findById(id);
        return optionalRanking.map(ranking -> modelMapper.map(ranking, RankingResponse.class)).orElseThrow(()-> new ResourceNotFoundException("ranking id : " + id));
    }

    @Override
    public void deleteRanking(Long id) {
        rankingRepository.deleteById(id);
    }
}
