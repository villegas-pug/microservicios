package com.microservicios.interpol.models.repository;

import com.microservicios.interpol.models.entity.Interpol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterpolRepository extends JpaRepository<Interpol, Long> {

}
