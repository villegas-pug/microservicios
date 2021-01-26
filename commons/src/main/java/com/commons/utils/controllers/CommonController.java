package com.commons.utils.controllers;

import java.util.List;
import com.commons.utils.constants.Messages;
import com.commons.utils.errors.DataAccessEmptyWarning;
import com.commons.utils.services.ICommonService;
import com.commons.utils.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class CommonController<E, S extends ICommonService<E>> {

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
}
