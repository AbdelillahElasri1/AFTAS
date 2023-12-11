package com.elasri.aftas.Ranking;

import com.elasri.aftas.Competition.CompetitionResponse;
import com.elasri.aftas.Member.Member;
import com.elasri.aftas.Member.MemberResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RankingResponse {
    private Long id;
    private Integer rank;
    private Integer score;

    private MemberResponse member;
    private CompetitionResponse competition;
}
