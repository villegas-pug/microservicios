package com.microservicios.tipotramite.models.repository;

import com.commons.utils.models.entities.TipoTramite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTramiteRepository extends JpaRepository<TipoTramite, Integer> {

}
