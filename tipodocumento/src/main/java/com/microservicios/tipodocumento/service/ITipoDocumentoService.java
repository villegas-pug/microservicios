package com.microservicios.tipodocumento.service;

import java.util.List;
import java.util.Optional;

import com.commons.utils.models.entities.Documento;

public interface ITipoDocumentoService {
   List<Documento> findAll();

   Optional<Documento> findById(Long id);

   Documento save(Documento entity);

   Long count();

   void delete(Documento entity);

   void deleteById(Long id);
}
