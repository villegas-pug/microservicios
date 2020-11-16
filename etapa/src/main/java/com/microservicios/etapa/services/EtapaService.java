package com.microservicios.etapa.services;

import java.util.List;
import java.util.Optional;
import com.commons.utils.models.entities.Etapa;
import com.microservicios.etapa.models.repository.EtapaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EtapaService implements IEtapaService {

   @Autowired
   private EtapaRepository repository;

   @Override
   @Transactional(readOnly = true)
   public List<Etapa> findAll() {
      return repository.findAll();
   }

   @Override
   @Transactional(readOnly = true)
   public Optional<Etapa> finddById(Long id) {
      return repository.findById(id);
   }

   @Override
   public Etapa save(Etapa entity) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Long count() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void delete(Etapa entity) {
      // TODO Auto-generated method stub

   }

   @Override
   public void deleteById(Long id) {
      // TODO Auto-generated method stub

   }

}
