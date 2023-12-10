package com.elasri.aftas.Competition;

import com.elasri.aftas.Hunting.Hunting;
import com.elasri.aftas.Level.Level;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer numberOfParticipants;
    private String location;
    private double amount;


    @OneToOne(mappedBy = "competition")
    private Hunting hunting;
}
