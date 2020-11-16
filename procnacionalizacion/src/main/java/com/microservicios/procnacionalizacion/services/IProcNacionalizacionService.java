package com.microservicios.procnacionalizacion.services;

import java.util.List;
import java.util.Optional;
import com.commons.utils.models.entities.Etapa;
import com.commons.utils.models.entities.ProcNacionalizacion;

public interface IProcNacionalizacionService {

   List<ProcNacionalizacion> findAll();

   Optional<ProcNacionalizacion> findById(Long id);

   ProcNacionalizacion save(ProcNacionalizacion entity);

   Long count();

   void delete(ProcNacionalizacion entity);

   void deleteById(Long id);

   List<Etapa> findAllEtapa();

   Etapa findByIdEtapa(Long id);

}
