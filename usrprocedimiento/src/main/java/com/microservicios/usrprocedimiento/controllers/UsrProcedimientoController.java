package com.microservicios.usrprocedimiento.controllers;

import com.commons.utils.constants.Messages;
import com.commons.utils.utils.Response;
import com.microservicios.usrprocedimiento.services.IUsrProcedimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" })
@RestController
public class UsrProcedimientoController {

   @Autowired
   private IUsrProcedimientoService service;

   @GetMapping(path = "/test")
   public ResponseEntity<?> test() {
      return ResponseEntity.ok().body(
            Response.builder().message(Messages.GET_MESSAGE_SUCCESS_LIST_ENTITY()).data(service.findAll()).build());
   }
}
