package com.povar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
   private Long id;
   private String name;
   private String specification;

   public Long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public String getSpecification() {
      return specification;
   }

}
