package com.povar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {



   private Long id;
   private String name;
   private String email;


   public Long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public String getEmail() {
      return email;
   }
}
