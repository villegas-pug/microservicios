package com.commons.utils.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidtefimPais")
@Data
@EqualsAndHashCode(of = { "idPais" })
public class Pais implements Serializable {

   @Id
   @Column(name = "sIdPais")
   private String idPais;

   @Column(name = "sNombre", nullable = false)
   private String nombre;

   @Column(name = "sNacionalidad", nullable = false)
   private String nacionalidad;

   @Column(name = "bActivo", nullable = false)
   private boolean activo;

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
