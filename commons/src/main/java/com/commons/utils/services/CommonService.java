package com.commons.utils.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class CommonService<E, R extends JpaRepository<E, Long>> implements ICommonService<E> {

   @Autowired
   protected R repository;

   @Transactional(readOnly = true)
   public List<E> findAll() {
      return repository.findAll();
   }

   @Transactional(readOnly = true)
   public Optional<E> findById(Long id) {
      return repository.findById(id);
   }

   @Transactional
   public E save(E entity) {
      return repository.save(entity);
   }

   @Transactional
   public void deleteById(Long id) {
      repository.deleteById(id);
   }
}
