package com.commons.utils.models.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "SidUsuarioProcedimiento", uniqueConstraints = @UniqueConstraint(columnNames = { "sLogin",
      "nIdProcedimiento" }))
@Data
public class UsuarioProcedimiento implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "nIdUsrProc")
   private Long idUsrProc;

   @Column(name = "bDenegado", nullable = false)
   private boolean denegado;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sLogin", nullable = false)
   private Usuario usuario;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "nIdProcedimiento", nullable = false)
   private Procedimiento procedimiento;

   @Column(name = "dFecha", nullable = false)
   private Date fecha;

   @PrePersist
   private void prePersint() {
      this.denegado = false;
      this.fecha = new Date();
   }

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}
