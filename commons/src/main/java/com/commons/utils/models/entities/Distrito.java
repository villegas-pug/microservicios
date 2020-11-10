package com.commons.utils.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "Sidtefim")
@Data
@EqualsAndHashCode(of = { "sIdDistrito" })
public class Distrito implements Serializable {
   @Id
   @Column(length = 15)
   private String sIdDistrito;

   private String sNombre;
   private boolean bActivo;

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
