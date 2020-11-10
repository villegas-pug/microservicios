package com.commons.utils.models.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidtefimTipoSolicitud")
@Data
@EqualsAndHashCode(of = { "sIdTipoSolicitud" })
public class TipoSolicitud implements Serializable {

   @Id
   private String sIdTipoSolicitud;
   private String sDescripcion;
   private boolean bActivo;

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
