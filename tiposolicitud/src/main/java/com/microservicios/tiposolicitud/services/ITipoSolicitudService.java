package com.microservicios.tiposolicitud.services;

import java.util.List;
import java.util.Optional;
import com.commons.utils.models.entities.TipoSolicitud;

public interface ITipoSolicitudService {
   List<TipoSolicitud> findAll();

   Optional<TipoSolicitud> finddById(String id);

   TipoSolicitud save(TipoSolicitud entity);

   Long count();

   void delete(TipoSolicitud entity);

   void deleteById(String id);
}
