package com.elasri.aftas.Level;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LevelResponse {
    private Integer code;
    private String description;
    private Integer points;
}
