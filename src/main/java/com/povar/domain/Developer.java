package com.povar.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Developer {
    Long id;
    String name;
    String gender;
    Integer age;
    BigDecimal salary;
}
