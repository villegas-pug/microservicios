package com.commons.utils.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidModulo")
@Data
@EqualsAndHashCode(of = { "idModulo" })
public class Modulo implements Serializable {

   @Id
   @Column(name = "sIdModulo")
   private String idModulo;

   @Column(name = "sNombre", nullable = false)
   private String nombre;

   @Column(name = "sDescripcion", nullable = false)
   private String descripcion;

   @Column(name = "sVersion", nullable = false)
   private String version;

   @Column(name = "bActivo", nullable = false)
   private boolean activo;

   @PrePersist
   private void prePersist() {
      this.activo = true;
   }

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
