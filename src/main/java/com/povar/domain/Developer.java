package com.povar.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Developer {
   private Long id;
   private String name;
   private GenderOfDevelopers genderOfDevelopers;
   private Integer age;
   private BigDecimal salary;

   public Developer(String name, GenderOfDevelopers genderOfDevelopers, Integer age, BigDecimal salary) {
      this.name = name;
      this.genderOfDevelopers = genderOfDevelopers;
      this.age = age;
      this.salary = salary;
   }

   public Developer(){

   }



   public String getName() {
      return name;
   }

   public GenderOfDevelopers getGenderOfDevelopers() {
      return genderOfDevelopers;
   }

   public Integer getAge() {
      return age;
   }

   public BigDecimal getSalary() {
      return salary;
   }


}
