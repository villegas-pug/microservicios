package com.microservicios.test.models.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Persona implements Serializable {

   private int id;
   private String name;
   private int age;

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
