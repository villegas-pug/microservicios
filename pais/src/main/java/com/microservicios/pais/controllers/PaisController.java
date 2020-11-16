package com.microservicios.pais.controllers;

import java.util.List;

import com.commons.utils.constants.Messages;
import com.commons.utils.errors.DataAccessEmptyWarning;
import com.commons.utils.models.entities.Pais;
import com.commons.utils.utils.Response;
import com.microservicios.pais.services.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" }, allowedHeaders = { "*" })
@RestController
public class PaisController {

   @Autowired
   private IPaisService service;

   @GetMapping(path = "/findAll")
   public ResponseEntity<?> findAll() {
      List<Pais> paisDb = service.findAll();
      if (paisDb.size() == 0)
         throw new DataAccessEmptyWarning();

      return ResponseEntity.ok()
            .body(Response.builder().message(Messages.GET_MESSAGE_SUCCESS_LIST_ENTITY()).data(paisDb).build());
   }

   @GetMapping(path = "/test")
   public String test(@Value("${spring.datasource.url}") String ds) {
      String microservicio = System.getProperty("microservicio");
      return microservicio;
   }
}
