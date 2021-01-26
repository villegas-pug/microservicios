package com.microservicios.test.models.repository;

import com.commons.utils.models.entities.Pais;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Pais, Long> {

}
