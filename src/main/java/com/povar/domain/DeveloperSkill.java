package com.povar.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperSkill {

   private Long id;
   private Long developerId;
   private Long skillId;

}
