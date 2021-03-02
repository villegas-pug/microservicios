package com.microservicios.operativo.models.entities;

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
import com.commons.utils.models.entities.Distrito;
import com.commons.utils.models.entities.Empresa;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "SidOperativo")
@Data
@EqualsAndHashCode(of = { "idOperativo" })
public class Operativo implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "nIdOperativo")
   private Long idOperativo;

   @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "operativo", orphanRemoval = true)
   @JsonIgnoreProperties(value = { "operativo" }, allowSetters = true)
   private List<DetalleOperativo> detOperativo;

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "sIdDistrito", nullable = true)
   private Distrito distrito;

   @Temporal(TemporalType.DATE)
   @Column(name = "dFechaOperativo", length = 55, nullable = false)
   private Date fechaOperativo;

   @Column(name = "nNumeroOperativo")
   private String numeroOperativo;

   @Column(name = "sTipoOperativo", length = 55, nullable = false)
   private String tipoOperativo;

   @Column(name = "sNumeroInforme", length = 55, nullable = false)
   private String numeroInforme;

   @JoinColumn(name = "nIdEmpresa", nullable = false)
   @ManyToOne(fetch = FetchType.EAGER)
   private Empresa entidadSolicitaOperativo;

   @Column(name = "dFechaRegistro", nullable = false)
   @Temporal(TemporalType.TIME)
   private Date fechaRegistro;

   @PrePersist
   private void prePersist() {
      this.fechaRegistro = new Date();
   }

   public Operativo() {
      this.detOperativo = new ArrayList<>();
   }

   public void setDetOperativo(List<DetalleOperativo> detOperativos) {
      detOperativos.forEach(this::addDetOperativo);
   }

   public void addDetOperativo(DetalleOperativo detOperativo) {
      detOperativo.setOperativo(this);
      this.detOperativo.add(detOperativo);
   }

   /**
   *
   */
   private static final long serialVersionUID = 1L;

}