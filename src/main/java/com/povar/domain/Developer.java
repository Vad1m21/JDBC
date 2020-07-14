package com.povar.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Developer {
   private Long id;
   private String name;
   private Gender gender;
   private Integer age;
   private BigDecimal salary;

   public Developer(String name, Gender gender, Integer age, BigDecimal salary) {
      this.name = name;
      this.gender = gender;
      this.age = age;
      this.salary = salary;
   }

}
