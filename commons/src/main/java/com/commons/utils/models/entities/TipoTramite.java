package com.commons.utils.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidtefimTipoTramite")
@Data
@EqualsAndHashCode(of = { "nIdTipoTramite" })
public class TipoTramite implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(length = 3)
   private int nIdTipoTramite;

   private String sDescripcion;
   private String sTipo;
   private boolean bActivo;
   private String sSigla;

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
