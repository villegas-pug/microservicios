package com.commons.utils.models.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidtefimPais")
@Data
@EqualsAndHashCode(of = { "sIdPais" })
public class Pais implements Serializable {

   @Id
   private String sIdPais;
   private String sNombre;
   private String sNacionalidad;
   private boolean bActivo;

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
