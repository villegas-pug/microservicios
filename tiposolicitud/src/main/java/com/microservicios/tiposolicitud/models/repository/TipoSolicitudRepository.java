package com.microservicios.tiposolicitud.models.repository;

import com.commons.utils.models.entities.TipoSolicitud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoSolicitudRepository extends JpaRepository<TipoSolicitud, String> {

}
