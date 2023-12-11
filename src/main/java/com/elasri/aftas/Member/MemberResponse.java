package com.elasri.aftas.Member;

import com.elasri.aftas.Hunting.Hunting;
import com.elasri.aftas.Hunting.HuntingResponse;
import com.elasri.aftas.Ranking.Ranking;
import com.elasri.aftas.Ranking.RankingResponse;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponse {
    private Integer num;
    private String name;
    private String familyName;
    private LocalDate accessionDate;
    private String nationality;
    @Enumerated(EnumType.STRING)
    private IdentifyDocumentType identifyDocumentType;
    private String identifyNumber;

    //private List<RankingResponse> rankings;
    //private List<HuntingResponse> huntings;

}
