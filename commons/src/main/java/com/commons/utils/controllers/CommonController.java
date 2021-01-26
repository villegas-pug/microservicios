package com.commons.utils.controllers;

import com.commons.utils.services.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class CommonController<E, S extends ICommonService<E>> {

   @Autowired
   protected S service;

   @GetMapping(path = "/findAll")
   public ResponseEntity<?> findAll() {
      return ResponseEntity.ok().body(service.findAll());
   }
}
