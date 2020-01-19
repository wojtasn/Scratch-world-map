package com.example.demo.persistence.entity.common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @Column
    private LocalDateTime createDate;

    @Column
    private LocalDateTime updateDate;

    public void setVersion(Long version) {
        this.version = version;
    }

    @PrePersist
    public void generateCreateDate() {
        this.createDate = LocalDateTime.now();
    }

    @PreUpdate
    public void generateUpdateDate() {
        this.updateDate = LocalDateTime.now();
    }

}
