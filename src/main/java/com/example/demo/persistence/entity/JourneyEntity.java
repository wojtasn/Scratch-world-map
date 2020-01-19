package com.example.demo.persistence.entity;

import com.example.demo.persistence.entity.common.AbstractEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "JOURNEY")
public class JourneyEntity extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "COUNTRY_ID", nullable = false)
    private CountryEntity country;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "START_DATE", nullable = false)
    private LocalDateTime startDate;
    @Column(name = "END_DATE", nullable = false)
    private LocalDateTime endDate;

}
