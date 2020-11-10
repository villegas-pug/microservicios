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
@EqualsAndHashCode(of = { "nIdEtapaProcNac" })
public class EtapaProcNacionalizacion implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long nIdEtapaProcNac;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "nIdEtapa")
   private Etapa etapa;

   @Temporal(TemporalType.TIMESTAMP)
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   private Date dFechaHoraInicio;

   @Temporal(TemporalType.TIMESTAMP)
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   private Date dFechaHoraFin;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "nIdUsrInicia")
   private Usuario usuarioInicia;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "nIdUsrFinaliza")
   private Usuario usuarioFinaliza;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "nIdEtapaAnterior")
   private Etapa etapaAnterior;

   private String sNumeroTramite;

   @Column(length = 500)
   private String sObservaciones;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sEstado")
   private Estado estado;

   private boolean bActivo;

   @PrePersist
   private void prePersist() {
      this.dFechaHoraInicio = new Date();
      this.bActivo = true;
   }

   /**
    *
    */
   private static final long serialVersionUID = 1L;

}