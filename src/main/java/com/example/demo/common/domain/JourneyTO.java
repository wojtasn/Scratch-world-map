package com.example.demo.common.domain;

import com.example.demo.common.domain.common.AbstractTO;
import com.example.demo.persistence.entity.CountryEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JourneyTO extends AbstractTO {
    private Long country;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
