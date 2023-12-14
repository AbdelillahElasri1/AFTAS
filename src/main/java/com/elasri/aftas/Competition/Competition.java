package com.elasri.aftas.Competition;

import com.elasri.aftas.Hunting.Hunting;
import com.elasri.aftas.Level.Level;
import com.elasri.aftas.Ranking.Ranking;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "t_competition")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Competition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private LocalDate date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private String startTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private String endTime;
    private Integer numberOfParticipants;
    private String location;
    private double amount;


//    @OneToOne(mappedBy = "competition")
//    private Hunting hunting;

    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL)
    private List<Hunting> huntings;

    @OneToMany(mappedBy = "competition", cascade = CascadeType.ALL)
    private List<Ranking> rankings;
}
