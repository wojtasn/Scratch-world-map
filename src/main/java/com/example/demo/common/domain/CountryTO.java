package com.example.demo.common.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryTO {
    private Long id;
    private String name;
}
