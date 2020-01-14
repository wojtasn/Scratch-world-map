package com.example.demo.persistence.entity;

import com.example.demo.persistence.entity.common.AbstractEntity;
import lombok.*;

import javax.persistence.*;
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
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "LEVEL_ID", nullable = true)
    private Long levelId;
    @Column(name = "POINTS", nullable = true)
    private Long points;

    @ManyToMany(cascade = CascadeType.ALL,
    fetch = FetchType.LAZY)
    @JoinTable(name = "USER_TO_COUNTRY", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "COUNTRY_ID"))
    private List<CountryEntity> countries;
}
