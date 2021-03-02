package com.microservicios.distrito.models.repository;

import com.commons.utils.models.entities.Distrito;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DistritoRepository extends JpaRepository<Distrito, Long> {

}