package com.elasri.aftas.Competition;

import java.util.List;

public interface CompetitionService {
    CompetitionRequest createCompetition(CompetitionRequest competitionRequest);
    CompetitionRequest updateCompetition(CompetitionRequest competitionRequest);
    void deleteCompetition(Long id);
    List<CompetitionResponse> getAllCompetition();
    CompetitionResponse getCompetition(Long id);
}
