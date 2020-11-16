package com.microservicios.tipotramite.services;

import java.util.List;
import java.util.Optional;

import com.commons.utils.models.entities.TipoTramite;

public interface ITipoTramiteService {
   List<TipoTramite> findAll();

   Optional<TipoTramite> finddById(Long id);

   TipoTramite save(TipoTramite entity);

   Long count();

   void delete(TipoTramite entity);

   void deleteById(Long id);
}
