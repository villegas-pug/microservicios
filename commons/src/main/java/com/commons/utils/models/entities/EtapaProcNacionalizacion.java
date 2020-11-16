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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidtefimEtapaProcNac")
@Data
@EqualsAndHashCode(of = { "idEtapaProcNac" })
public class EtapaProcNacionalizacion implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "nIdEtapaProcNac")
   private Long idEtapaProcNac;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "nIdProcNac", nullable = false)
   private ProcNacionalizacion procNac;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "nIdEtapa")
   private Etapa etapa;

   @Temporal(TemporalType.TIMESTAMP)
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   @Column(name = "dFechaHoraInicio", nullable = false)
   private Date fechaHoraInicio;

   @Temporal(TemporalType.TIMESTAMP)
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   @Column(name = "dFechaHoraFin")
   private Date fechaHoraFin;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "nIdUsrInicia", nullable = false)
   private Usuario usuarioInicia;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "nIdUsrFinaliza")
   private Usuario usuarioFinaliza;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "nIdEtapaAnterior")
   private Etapa etapaAnterior;

   @Column(name = "sNumeroTramite", nullable = false)
   private String numeroTramite;

   @Column(name = "bActivo", nullable = false)
   private boolean activo;

   @PrePersist
   private void prePersist() {
      this.fechaHoraInicio = new Date();
      this.activo = true;
   }

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}