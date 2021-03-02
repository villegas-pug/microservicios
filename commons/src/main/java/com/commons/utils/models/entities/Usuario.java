package com.commons.utils.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidUsuario")
@Data
@EqualsAndHashCode(of = { "login" })
public class Usuario implements Serializable {

   @Id
   @Column(name = "sLogin")
   private String login;

   @Column(name = "xPassword", nullable = false)
   private String password;

   @Column(name = "sNombre", nullable = false)
   private String nombre;

   @Column(name = "sIdDependencia", nullable = false)
   private String dependencia;

   @Column(name = "sCodigoArea", nullable = false)
   private String codigoArea;

   @Column(name = "sDni", length = 8, nullable = false)
   private String dni;

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
