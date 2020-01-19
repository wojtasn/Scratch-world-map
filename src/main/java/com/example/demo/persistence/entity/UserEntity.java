package com.example.demo.persistence.entity;

import com.example.demo.persistence.entity.common.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "USER")
public class UserEntity extends AbstractEntity {

    @Column(name = "EMAIL", nullable = false)
    private String email;
    @Column(name = "PASSWORD", nullable = true)
    private String password;
    @Column(name = "LEVEL_ID", nullable = true)
    private Long levelId;
    @Column(name = "POINTS", nullable = true)
    private Long points;
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "USER_ID")
    private List<JourneyEntity> journeys;

    public boolean hasJourneys(){
        return journeys != null && !journeys.isEmpty();
    }

    public void addJourney(JourneyEntity journey){
        if(journeys == null){
            journeys = new ArrayList<>();
        }
        journeys.add(journey);
    }
}
