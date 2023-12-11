package com.elasri.aftas.Hunting;

import com.elasri.aftas.Competition.Competition;
import com.elasri.aftas.Competition.CompetitionResponse;
import com.elasri.aftas.Fish.Fish;
import com.elasri.aftas.Fish.FishResponse;
import com.elasri.aftas.Member.Member;
import com.elasri.aftas.Member.MemberResponse;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HuntingResponse {
    private Long id;
    private Integer numberOfFish;
    private MemberResponse participant;
    private CompetitionResponse competition;
    private FishResponse fish;
}
