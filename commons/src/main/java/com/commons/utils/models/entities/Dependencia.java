package com.commons.utils.models.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidtefimDependencia")
@Data
@EqualsAndHashCode(of = { "sIdDependencia" })
public class Dependencia implements Serializable {

   @Id
   private String sIdDependencia;
   private String sNombre;
   private String sSigla;
   private String sTelefono;
   private boolean bActivo;

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
