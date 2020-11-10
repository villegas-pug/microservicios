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
@Table(name = "SidtefimEtapa")
@Data
@EqualsAndHashCode(of = { "nIdEtapa" })
public class Etapa implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(length = 1)
   private Long nIdEtapa;
   private String sDescripcion;
   private boolean bActivo;

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
