package com.microservicios.procnacionalizacion.models.repository;

import com.commons.utils.models.entities.ProcNacionalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcNacionalizacionRepository extends JpaRepository<ProcNacionalizacion, Long> {

}
