package com.commons.utils.models.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidtefimEstado")
@Data
@EqualsAndHashCode(of = { "sIdEstado" })
public class Estado implements Serializable {

   @Id
   private String sIdEstado;
   private String sNombre;
   private String sDescripcion;

   /**
    *
    */
   private static final long serialVersionUID = 1L;
}
