package com.povar.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor

public class Project {

   private Long id;
   private String name;
   private Date date;
   private String description;
   private Integer cost;

   public Long getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public Date getDate() {
      return date;
   }

   public String getDescription() {
      return description;
   }

   public Integer getCost() {
      return cost;
   }





}
