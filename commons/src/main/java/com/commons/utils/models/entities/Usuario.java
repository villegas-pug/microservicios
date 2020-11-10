package com.commons.utils.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidtefimUsuario")
@Data
@EqualsAndHashCode(of = { "sLogin" })
public class Usuario implements Serializable {

   @Id
   private String sLogin;
   private String xPassword;
   private String sNombre;
   private String sSiglas;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sIdDependencia")
   private Dependencia dependencia;

   private String sGrupoControl;
   private String sCodigoArea;

   @Column(length = 8)
   private int sDni;

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
