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
@Table(name = "SidtefimProcNac")
@Data
@EqualsAndHashCode(of = { "idProcNac" })
public class ProcNacionalizacion implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "nIdProcNac")
   private Long idProcNac;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sIdDocumento")
   private Documento documento;

   @Column(name = "sNumeroDocumento")
   private String sNumeroDocumento;

   @Column(name = "sNumeroTramite", length = 15, nullable = false)
   private String numeroTramite;

   @Temporal(TemporalType.DATE)
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   @Column(name = "dFechaInicioTramite")
   private Date fechaInicioTramite;

   @Column(length = 55)
   private String sAdministrado;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sIdNacionalidad")
   private Pais nacionalidad;

   @Column(name = "sDomicilio", length = 300)
   private String domicilio;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sIdDistrito")
   private Distrito distrito;

   @Column(name = "sCorreo", length = 55, nullable = false)
   private String correo;

   @Column(name = "nTelefono", length = 15)
   private Long telefono;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sIdTipoSolicitud")
   private TipoSolicitud tipoSolicitud;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sIdTipoTramite")
   private TipoTramite tipoTramite;

   @Temporal(TemporalType.TIMESTAMP)
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   @Column(name = "dFechaRegistro", nullable = false)
   private Date fechaRegistro;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sUsrEvaluador")
   private Usuario evaluador;

   @Temporal(TemporalType.TIMESTAMP)
   @Column(name = "dFechaAsignacionTramite")
   private Date fechaAsignacionTramite;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sEstadoActual")
   private Estado estadoActual;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "nIdEtapaActualProcNac")
   private Etapa etapaActualProcNac;

   @Column(name = "bCompleto")
   private boolean completo;

   @PrePersist
   private void prePersist() {
      this.fechaRegistro = new Date();
   }

   /**
   *
   */
   private static final long serialVersionUID = 1L;

}
