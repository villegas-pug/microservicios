package com.microservicios.usrprocedimiento.models.repository;

import com.commons.utils.models.entities.Procedimiento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsrProcedimientoRepository extends JpaRepository<Procedimiento, Long> {

}
