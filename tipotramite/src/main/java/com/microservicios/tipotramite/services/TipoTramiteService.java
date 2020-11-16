package com.microservicios.tipotramite.services;

import java.util.List;
import java.util.Optional;

import com.commons.utils.models.entities.TipoTramite;
import com.microservicios.tipotramite.models.repository.TipoTramiteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoTramiteService implements ITipoTramiteService {

   @Autowired
   private TipoTramiteRepository repository;

   @Override
   @Transactional(readOnly = true)
   public List<TipoTramite> findAll() {
      return repository.findAll();
   }

   @Override
   public Optional<TipoTramite> finddById(Long id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public TipoTramite save(TipoTramite entity) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Long count() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void delete(TipoTramite entity) {
      // TODO Auto-generated method stub

   }

   @Override
   public void deleteById(Long id) {
      // TODO Auto-generated method stub

   }

}
