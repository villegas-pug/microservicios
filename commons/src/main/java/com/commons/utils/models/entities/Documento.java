package com.commons.utils.models.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidtefimDocumento")
@Data
@EqualsAndHashCode(of = { "sIdDocumento" })
public class Documento implements Serializable {

   @Id
   private String sIdDocumento;
   private String sDescripcion;
   private boolean bActivo;

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
