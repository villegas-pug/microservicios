package com.commons.utils.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

   @JsonIgnoreProperties({ "procNac" })
   @OneToMany(mappedBy = "procNac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   private List<EtapaProcNacionalizacion> etapasProcNacionalizacion;

   @Column(name = "sDocumento", nullable = true, length = 55)
   private String documento;

   @Column(name = "sNumeroDocumento", nullable = true)
   private String numeroDocumento;

   @Column(name = "sNumeroTramite", length = 15, nullable = false)
   private String numeroTramite;

   @Temporal(TemporalType.DATE)
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   @Column(name = "dFechaInicioTramite", nullable = true)
   private Date fechaInicioTramite;

   @Column(name = "sAdministrado", length = 55, nullable = true)
   private String administrado;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sIdNacionalidad", nullable = true)
   private Pais nacionalidad;

   @Column(name = "sDomicilio", length = 300, nullable = true)
   private String domicilio;

   @Column(name = "sDistrito", nullable = true)
   private String distrito;

   @Column(name = "sCorreo", length = 55, nullable = false)
   private String correo;

   @Column(name = "nTelefono", length = 15)
   private Long telefono;

   @Column(name = "sIdTipoSolicitud", nullable = false, length = 3)
   private String tipoSolicitud;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sIdTipoTramite", nullable = false)
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

   @Column(name = "sEstado", nullable = false, length = 1)
   private String estado;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "nIdEtapaActualProcNac")
   private Etapa etapaActualProcNac;

   @Column(name = "bCompleto")
   private boolean completo;

   public ProcNacionalizacion() {
      this.etapasProcNacionalizacion = new ArrayList<>();
   }

   @PrePersist
   private void prePersist() {
      this.fechaRegistro = new Date();
      this.completo = false;
   }

   public void addEtapaProcNacionalizacion(EtapaProcNacionalizacion etapaProcNacionalizacion) {
      this.etapasProcNacionalizacion.add(etapaProcNacionalizacion);
      etapaProcNacionalizacion.setProcNac(this);
   }

   /**
   *
   */
   private static final long serialVersionUID = 1L;

}
