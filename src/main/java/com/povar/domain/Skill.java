package com.povar.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {

   private Long id;
   private String name;
   private LevelOfProgramingLanguages levelOfProgramingLanguages;
}
