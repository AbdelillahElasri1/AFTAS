package com.elasri.aftas.Level;

import com.elasri.aftas.Fish.Fish;
import com.elasri.aftas.Hunting.HuntingResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LevelResponse {
    private Integer code;
    private String description;
    private Integer points;
    private List<Fish> fish;
    private HuntingResponse hunting;
}
