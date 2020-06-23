package com.povar.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor

public class Project {

    Long id;
    String name;
    Date date;
    String description;
    BigDecimal cost;



}
