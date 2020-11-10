package com.microservicios.usrprocedimiento.services;

import java.util.List;
import java.util.Optional;

import com.commons.utils.models.entities.Procedimiento;

public interface IUsrProcedimientoService {
   List<Procedimiento> findAll();

   Optional<Procedimiento> findById(Long id);

   Procedimiento save(Procedimiento entity);

   Long count();

   void delete(Procedimiento entity);

   void deleteById(Long id);
}
