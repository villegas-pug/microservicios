package com.commons.utils.controllers;

import java.util.Arrays;
import java.util.List;
import com.commons.utils.constants.Messages;
import com.commons.utils.errors.DataAccessEmptyWarning;
import com.commons.utils.services.CommonService;
import com.commons.utils.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CommonController<E, S extends CommonService<E>> {

   @Autowired
   protected S service;

   @GetMapping(path = "/findAll")
   public ResponseEntity<?> findAll() {

      List<E> entityDb = service.findAll();

      if (entityDb.size() == 0)
         throw new DataAccessEmptyWarning();

      return ResponseEntity.ok()
            .body(Response.builder().message(Messages.GET_MESSAGE_SUCCESS_LIST_ENTITY()).data(entityDb).build());
   }

   @PostMapping(path = "/save")
   public ResponseEntity<?> save(@RequestBody E entity) {
      return ResponseEntity.ok().body(Response.builder().message(Messages.GET_MESSAGE_SUCCESS_CREATE())
            .data(Arrays.asList(service.save(entity))).build());
   }

}