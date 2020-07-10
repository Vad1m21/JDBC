package com.povar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProject {

   private Long id;
   private Long customerId;
   private Long projectId;

}
