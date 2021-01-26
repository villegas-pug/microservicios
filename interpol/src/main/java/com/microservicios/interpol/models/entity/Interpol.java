package com.microservicios.interpol.models.entity;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.commons.utils.models.entities.Pais;

import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidInterpol")
/* @Data */
@EqualsAndHashCode(of = { "" })
public class Interpol implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "nIdInterpol")
   private Long idInterpol;

   @Column(length = 5, nullable = true)
   private String sOrigen;

   @Column(length = 5, nullable = true)
   private String sApellido;

   @Column(length = 5, nullable = true)
   private String sNombres;

   @Column(length = 5, nullable = true)
   private String sSexo;

   @Column(length = 5, nullable = true)
   private String sCedula;

   @Column(length = 5, nullable = true)
   private String sPasaporte;

   @Column(length = 5, nullable = true)
   private String sNacionalidad;

   @Temporal(TemporalType.DATE)
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   @Column(name = "dFechaSancion", nullable = true)
   private String dFechaSancion;

   @Column(length = 5, nullable = true)
   private String dFechaNacimiento;

   @Column(length = 5, nullable = true)
   private String sMotivo;

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

   /**
   *
   */
   private static final long serialVersionUID = 1L;

}
