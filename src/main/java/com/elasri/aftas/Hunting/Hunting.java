package com.elasri.aftas.Hunting;

import com.elasri.aftas.Competition.Competition;
import com.elasri.aftas.Level.Level;
import com.elasri.aftas.Member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_hunting")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Hunting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numberOfFish;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "num_member")
    private Member participant;

    @OneToOne
    @JoinColumn(name = "competition_id")
    private Competition competition;

    @OneToOne
    @JoinColumn(name = "level_id")
    private Level level;
}
