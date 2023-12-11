package com.elasri.aftas.Fish;

import com.elasri.aftas.Level.Level;
import com.elasri.aftas.Level.LevelResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FishResponse {
    private Long id;
    private String name;
    private Double averageWeight;
    private LevelResponse level;
}
