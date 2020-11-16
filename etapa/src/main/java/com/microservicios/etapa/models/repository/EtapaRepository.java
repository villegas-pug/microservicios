package com.microservicios.etapa.models.repository;

import com.commons.utils.models.entities.Etapa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapaRepository extends JpaRepository<Etapa, Long> {

}