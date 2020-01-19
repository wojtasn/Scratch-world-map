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
@Table(name = "COUNTRY")
public class CountryEntity extends AbstractEntity {

    @Column(name = "COUNTRY", nullable = false)
    private String name;

}
