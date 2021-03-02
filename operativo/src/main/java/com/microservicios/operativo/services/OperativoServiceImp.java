package com.microservicios.operativo.services;

import java.util.Optional;

import com.commons.utils.models.entities.Pais;
import com.commons.utils.services.CommonServiceImp;
import com.microservicios.operativo.clients.PaisClient;
import com.microservicios.operativo.models.entities.Operativo;
import com.microservicios.operativo.models.repository.OperativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OperativoServiceImp extends CommonServiceImp<Operativo, OperativoRepository> implements OperativoService {

   @Autowired
   private PaisClient paisClient;

   @Override
   public Optional<Pais> findByNacionalidad(String nacionalidad) {
      return paisClient.findByNacionalidad(nacionalidad);
   }

}