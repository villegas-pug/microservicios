package com.microservicios.usuario.services;

import java.util.List;
import java.util.Optional;

import com.commons.utils.models.entities.Usuario;

public interface IUsuarioService {
   List<Usuario> findAll();

   Optional<Usuario> findById(String id);

   Usuario save(Usuario entity);

   Long count();

   void delete(Usuario entity);

   void deleteById(Long id);

}
