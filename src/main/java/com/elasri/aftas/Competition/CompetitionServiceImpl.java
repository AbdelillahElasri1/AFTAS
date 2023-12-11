package com.elasri.aftas.Competition;

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
public class CompetitionServiceImpl implements CompetitionService{

    @Autowired
    private CompetitionRepository competitionRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CompetitionRequest createCompetition(CompetitionRequest competitionRequest) {
        Competition competition = modelMapper.map(competitionRequest, Competition.class);
        Competition savedCompetition = competitionRepository.save(competition);
        return modelMapper.map(savedCompetition, CompetitionRequest.class);
    }

    @Override
    public CompetitionRequest updateCompetition(CompetitionRequest competitionRequest) {
        return null;
    }

    @Override
    public void deleteCompetition(Long id) {
        competitionRepository.deleteById(id);
    }

    @Override
    public List<CompetitionResponse> getAllCompetition() {
        List<Competition> competitionList = competitionRepository.findAll();
        return competitionList.stream().map(competition -> modelMapper.map(competition, CompetitionResponse.class)).collect(Collectors.toList());
    }

    @Override
    public CompetitionResponse getCompetition(Long id) {
        Optional<Competition> optionalCompetition = competitionRepository.findById(id);
        return optionalCompetition.map(competition -> modelMapper.map(competition, CompetitionResponse.class)).orElseThrow(()-> new ResourceNotFoundException("id competition : " + id));
    }
}
