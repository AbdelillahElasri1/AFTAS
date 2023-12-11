package com.elasri.aftas.Ranking;

import java.util.List;

public interface RankingService {
    RankingRequest saveRanking(RankingRequest rankingRequest);
    RankingRequest updateRanking(RankingRequest rankingRequest);
    List<RankingResponse> getAllRankings();
    RankingResponse getRanking(Long id);
    void deleteRanking(Long id);
}
