package com.microservicios.interpol.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidInterpol")
@Data
@EqualsAndHashCode(of = { "idInterpol" })
public class Interpol implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "nIdInterpol")
   private Long idInterpol;

   @Column(name = "sOrigen", length = 55)
   private String origen;

   @Column(name = "sNombres", length = 255)
   private String nombres;

   @Column(name = "sSexo", length = 10)
   private String sexo;

   @Column(name = "sCedula", length = 55)
   private String cedula;

   @Column(name = "sPasaporte", length = 15)
   private String pasaporte;

   @Column(name = "sNacionalidad", length = 55, nullable = true)
   private String nacionalidad;

   @Temporal(TemporalType.DATE)
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   @Column(name = "dFechaEmision")
   private Date fechaEmision;

   @Column(name = "dFechaLugarNacimiento", length = 100)
   private String fechaLugarNacimiento;

   @Column(name = "sMotivo", length = 15)
   private String motivo;

   /**
   *
   */
   private static final long serialVersionUID = 1L;

}
