package com.microservicios.tipodocumento.service;

import java.util.List;
import java.util.Optional;

import com.commons.utils.models.entities.Documento;
import com.microservicios.tipodocumento.model.repository.TipoDocumentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoDocumentoService implements ITipoDocumentoService {

   @Autowired
   private TipoDocumentoRepository repository;

   @Override
   @Transactional(readOnly = true)
   public List<Documento> findAll() {
      return repository.findAll();
   }

   @Override
   public Optional<Documento> findById(Long id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Documento save(Documento entity) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Long count() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void delete(Documento entity) {
      // TODO Auto-generated method stub

   }

   @Override
   public void deleteById(Long id) {
      // TODO Auto-generated method stub

   }

}
