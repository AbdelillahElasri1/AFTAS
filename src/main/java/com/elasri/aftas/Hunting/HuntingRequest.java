package com.elasri.aftas.Hunting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HuntingRequest {
    private Integer numberOfFish;
    private Integer num_member;
    private Long competition_id;
    private Long fish_id;
}
