package com.elasri.aftas.Level;

import com.elasri.aftas.Competition.Competition;
import com.elasri.aftas.Fish.Fish;
import com.elasri.aftas.Hunting.Hunting;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "t_level")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    private String description;
    private Integer points;

    @OneToMany(mappedBy = "level", cascade = CascadeType.ALL)
    private List<Fish> fish;

    @OneToOne(mappedBy = "level")
    private Hunting hunting;
}
