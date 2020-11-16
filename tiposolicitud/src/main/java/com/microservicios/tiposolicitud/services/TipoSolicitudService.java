package com.microservicios.tiposolicitud.services;

import java.util.List;
import java.util.Optional;
import com.commons.utils.models.entities.TipoSolicitud;
import com.microservicios.tiposolicitud.models.repository.TipoSolicitudRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TipoSolicitudService implements ITipoSolicitudService {

   @Autowired
   private TipoSolicitudRepository repository;

   @Override
   @Transactional(readOnly = true)
   public List<TipoSolicitud> findAll() {
      return repository.findAll();
   }

   @Override
   public Optional<TipoSolicitud> finddById(String id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public TipoSolicitud save(TipoSolicitud entity) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Long count() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void delete(TipoSolicitud entity) {
      // TODO Auto-generated method stub

   }

   @Override
   public void deleteById(String id) {
      // TODO Auto-generated method stub

   }

}
