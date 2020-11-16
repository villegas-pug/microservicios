package com.microservicios.tipodocumento.model.repository;

import com.commons.utils.models.entities.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDocumentoRepository extends JpaRepository<Documento, Long> {

}
