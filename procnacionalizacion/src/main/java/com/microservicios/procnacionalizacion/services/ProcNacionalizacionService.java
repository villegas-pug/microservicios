package com.microservicios.procnacionalizacion.services;

import java.util.List;
import java.util.Optional;
import com.commons.utils.models.entities.ProcNacionalizacion;
import com.microservicios.procnacionalizacion.models.repository.ProcNacionalizacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcNacionalizacionService implements IProcNacionalizacionService {

   @Autowired
   private ProcNacionalizacionRepository repository;

   @Override
   @Transactional(readOnly = true)
   public List<ProcNacionalizacion> findAll() {
      return null;
   }

   @Override
   @Transactional(readOnly = true)
   public Optional<ProcNacionalizacion> findById(Long id) {
      return null;
   }

   @Override
   @Transactional(readOnly = false)
   public ProcNacionalizacion save(ProcNacionalizacion entity) {
      return repository.save(entity);
   }

   @Override
   @Transactional(readOnly = true)
   public Long count() {
      return null;
   }

   @Override
   @Transactional
   public void delete(ProcNacionalizacion entity) {

   }

   @Override
   @Transactional
   public void deleteById(Long id) {

   }

}
