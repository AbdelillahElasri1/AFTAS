package com.elasri.aftas.Fish;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FishRequest {
    @NotNull(message = "name is required")
    private String name;
    @Min(value = 1, message = "average weight is grether than 1")
    private double averageWeight;
    @NotNull(message = "level_id is required")
    private Integer level_id;
}
