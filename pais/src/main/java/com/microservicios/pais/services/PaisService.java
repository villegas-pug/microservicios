package com.microservicios.pais.services;

import java.util.List;
import java.util.Optional;

import com.commons.utils.models.entities.Pais;
import com.microservicios.pais.models.repository.PaisRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaisService implements IPaisService {

   @Autowired
   private PaisRepository repository;

   @Override
   @Transactional(readOnly = true)
   public List<Pais> findAll() {
      return repository.findAll();
   }

   @Override
   public Optional<Pais> findById(String id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Pais save(Pais entity) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Long count() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void delete(Pais entity) {
      // TODO Auto-generated method stub

   }

   @Override
   public void deleteById(String id) {
      // TODO Auto-generated method stub

   }

}
