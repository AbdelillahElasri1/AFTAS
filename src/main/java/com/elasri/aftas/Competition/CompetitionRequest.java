package com.elasri.aftas.Competition;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class CompetitionRequest {
    private String code;
    private LocalDate date;
    @JsonFormat(pattern = "HH:mm:ss")
    private String startTime;
    @JsonFormat(pattern = "HH:mm:ss")
    private String endTime;
    private Integer numberOfParticipants;
    private String location;
    private double amount;
}
