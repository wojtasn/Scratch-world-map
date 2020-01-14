package com.example.demo.common.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTO {
    private Long id;
    private String email;
    private String password;
    private Long levelId;
    private Long points;
    private List<Long> countries = new ArrayList<>();

    public List<Long> getCountries(){
        return countries;
    }
}
