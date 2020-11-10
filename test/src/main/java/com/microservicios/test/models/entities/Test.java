package com.microservicios.test.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "SidtefimTest")
@Data
public class Test implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long nId;

   private String sMensaje;
   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
