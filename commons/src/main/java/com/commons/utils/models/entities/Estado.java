package com.commons.utils.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidtefimEstado")
@Data
@EqualsAndHashCode(of = { "idEstado" })
public class Estado implements Serializable {

   @Id
   @Column(name = "sIdEstado")
   private String idEstado;

   @Column(name = "sNombre", nullable = false)
   private String nombre;

   @Column(name = "sDescripcion", nullable = false)
   private String descripcion;

   /**
    *
    */
   private static final long serialVersionUID = 1L;
}
