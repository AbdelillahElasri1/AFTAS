package com.elasri.aftas.Competition;

import org.springframework.data.domain.Page;

import java.util.List;

public interface CompetitionService {
    CompetitionRequest createCompetition(CompetitionRequest competitionRequest);
    CompetitionRequest updateCompetition(CompetitionRequest competitionRequest);
    void deleteCompetition(Long id);
    List<CompetitionResponse> getAllCompetition();

    Page<CompetitionResponse> findPaginated(int page, int size);

    CompetitionResponse getCompetition(Long id);
}
