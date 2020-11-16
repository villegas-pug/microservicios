package com.commons.utils.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidtefimProcedimiento")
@Data
@EqualsAndHashCode(of = { "idProcedimiento" })
public class Procedimiento implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "nIdProcedimiento", length = 2)
   private Long idProcedimiento;

   @Column(name = "sNombre", nullable = false)
   private String nombre;

   @Column(name = "sComponente", nullable = false)
   private String componente;

   @Column(name = "sIcono", nullable = false)
   private String icono;

   @Column(name = "sRuta", nullable = false)
   private String ruta;

   @Column(name = "bActivo", nullable = false)
   private boolean activo;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sIdModulo", nullable = false)
   private Modulo modulo;

   @PrePersist
   private void prePersist() {
      this.activo = true;
   }

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
