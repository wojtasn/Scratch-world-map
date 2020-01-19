package com.example.demo.common.domain;

import com.example.demo.common.domain.common.AbstractTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTO extends AbstractTO {
    private Long id;
    private String email;
    private String password;
    private Long levelId;
    private Long points;
    private List<Long> journeys = new ArrayList<>();

    public boolean hasJourneys(){
        return journeys != null && !journeys.isEmpty();
    }
}
