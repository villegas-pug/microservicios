package com.microservicios.pais.services;

import java.util.List;
import java.util.Optional;
import com.commons.utils.models.entities.Pais;

public interface IPaisService {
   List<Pais> findAll();

   Optional<Pais> findById(String id);

   Pais save(Pais entity);

   Long count();

   void delete(Pais entity);

   void deleteById(String id);
}
