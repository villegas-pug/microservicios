package com.microservicios.operativo.models.repository;

import com.microservicios.operativo.models.entities.Operativo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OperativoRepository extends JpaRepository<Operativo, Long> {

}