package com.commons.utils.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Data;

@Entity
@Table(name = "SidTipoTramite")
@Data
@EqualsAndHashCode(of = { "idTipoTramite" })
public class TipoTramite implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "nIdTipoTramite", length = 3)
   private int idTipoTramite;

   @Column(name = "sDescripcion", nullable = false)
   private String descripcion;

   @Column(name = "sTipo", nullable = false)
   private String tipo;

   @Column(name = "bActivo", nullable = false)
   private boolean activo;

   @Column(name = "sSigla", nullable = false)
   private String sigla;

   @PrePersist
   private void prePersist() {
      this.activo = true;
   }

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
