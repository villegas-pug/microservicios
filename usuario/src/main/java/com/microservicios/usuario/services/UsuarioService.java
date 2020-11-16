package com.microservicios.usuario.services;

import java.util.List;
import java.util.Optional;
import com.commons.utils.models.entities.Usuario;
import com.microservicios.usuario.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioService implements IUsuarioService {

   @Autowired
   private UsuarioRepository repository;

   @Override
   @Transactional(readOnly = true)
   public List<Usuario> findAll() {
      return repository.findAll();
   }

   @Override
   public Optional<Usuario> findById(String id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Usuario save(Usuario entity) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Long count() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void delete(Usuario entity) {
      // TODO Auto-generated method stub

   }

   @Override
   public void deleteById(Long id) {
      // TODO Auto-generated method stub

   }

}
