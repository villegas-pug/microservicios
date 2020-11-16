package com.microservicios.etapa.services;

import java.util.List;
import java.util.Optional;

import com.commons.utils.models.entities.Etapa;

public interface IEtapaService {
   List<Etapa> findAll();

   Optional<Etapa> finddById(Long id);

   Etapa save(Etapa entity);

   Long count();

   void delete(Etapa entity);

   void deleteById(Long id);
}
