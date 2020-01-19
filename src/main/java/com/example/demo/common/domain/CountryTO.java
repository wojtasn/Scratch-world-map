package com.example.demo.common.domain;

import com.example.demo.common.domain.common.AbstractTO;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryTO extends AbstractTO {
    private String name;
}
