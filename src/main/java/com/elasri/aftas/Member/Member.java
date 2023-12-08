package com.elasri.aftas.Member;

import com.elasri.aftas.Hunting.Hunting;
import com.elasri.aftas.Ranking.Ranking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "t_member")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;
    private String name;
    private String familyName;
    private LocalDate accessionDate;
    private String nationality;
    @Enumerated(EnumType.STRING)
    private IdentifyDocumentType identifyDocumentType;
    private String identifyNumber;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Ranking> rankings;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.ALL)
    private List<Hunting> huntings;
}
