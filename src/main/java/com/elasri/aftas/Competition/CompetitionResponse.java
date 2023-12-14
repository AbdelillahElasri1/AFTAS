package com.elasri.aftas.Competition;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CompetitionResponse {
    private Long id;
    private String code;
    private LocalDate date;
    private String startTime;
    private String endTime;
    private Integer numberOfParticipants;
    private String location;
    private double amount;
}
