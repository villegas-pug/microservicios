package com.microservicios.operativo.services;

import java.util.Optional;

import com.commons.utils.models.entities.Pais;
import com.commons.utils.services.CommonService;
import com.microservicios.operativo.models.entities.Operativo;

public interface OperativoService extends CommonService<Operativo> {

   Optional<Pais> findByNacionalidad(String nacionalidad);

}