package com.microservicios.usrprocedimiento.services;

import java.util.List;
import java.util.Optional;

import com.commons.utils.models.entities.Procedimiento;
import com.microservicios.usrprocedimiento.models.repository.UsrProcedimientoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsrProcedimientoService implements IUsrProcedimientoService {

   @Autowired
   private UsrProcedimientoRepository repository;

   @Override
   @Transactional(readOnly = true)
   public List<Procedimiento> findAll() {
      return repository.findAll();
   }

   @Override
   public Optional<Procedimiento> findById(Long id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Procedimiento save(Procedimiento entity) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Long count() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void delete(Procedimiento entity) {
      // TODO Auto-generated method stub

   }

   @Override
   public void deleteById(Long id) {
      // TODO Auto-generated method stub

   }

}
