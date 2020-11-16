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
@Table(name = "SidtefimTipoSolicitud")
@Data
@EqualsAndHashCode(of = { "idTipoSolicitud" })
public class TipoSolicitud implements Serializable {

   @Id
   @Column(name = "sIdTipoSolicitud")
   private String idTipoSolicitud;

   @Column(name = "sDescripcion", nullable = false)
   private String descripcion;

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
