package com.example.demo.persistence.entity;

import com.example.demo.persistence.entity.common.AbstractEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
