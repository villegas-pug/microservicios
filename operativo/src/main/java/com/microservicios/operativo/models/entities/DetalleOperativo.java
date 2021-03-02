package com.microservicios.operativo.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.commons.utils.models.entities.Pais;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "SidDetOperativo")
@Data
@EqualsAndHashCode(of = { "idDetOperativo" })
@RequiredArgsConstructor
@NoArgsConstructor
public class DetalleOperativo implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "nIdDetOperativo")
   private Long idDetOperativo;

   @JoinColumn(name = "nIdOperativo", nullable = false)
   @JsonIgnoreProperties(value = { "detOperativo" })
   @ManyToOne(fetch = FetchType.EAGER)
   private Operativo operativo;

   @NonNull
   @Column(name = "sNombres", length = 150, nullable = false)
   private String nombres;

   @NonNull
   @Column(name = "sTipoDocumento", length = 55, nullable = false)
   private String tipoDocumento;

   @NonNull
   @Column(name = "sNumeroDocumento", length = 100, nullable = false)
   private String numeroDocumento;

   @NonNull
   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sIdPais", nullable = true)
   private Pais pais;

   @NonNull
   @Column(name = "sSexo", length = 1, nullable = false)
   private String sexo;

   @NonNull
   @Column(name = "sInfraccion", length = 2, nullable = false)
   private String infraccion;

   @NonNull
   @Column(name = "sTipoInfraccion", length = 200, nullable = true)
   private String tipoInfraccion;

   @NonNull
   @Column(name = "sDisposicionPNP", length = 2, nullable = false)
   private String disposicionPNP;

   @NonNull
   @Column(name = "sSituacionMigratoria", length = 55, nullable = false)
   private String situacionMigratoria;

   @NonNull
   @Column(name = "sRefugiado", length = 2, nullable = false)
   private String refugiado;

   @NonNull
   @Column(name = "sConMenor", length = 2, nullable = false)
   private String conMenor;

   @NonNull
   @Column(name = "sDatosMenor", length = 500)
   private String datosMenor;

   @NonNull
   @Column(name = "sObservaciones", length = 500)
   private String observaciones;

   /**
   *
   */
   private static final long serialVersionUID = 1L;

}