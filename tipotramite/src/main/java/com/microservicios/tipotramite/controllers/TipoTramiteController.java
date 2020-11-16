package com.microservicios.tipotramite.controllers;

import java.util.List;
import com.commons.utils.constants.Messages;
import com.commons.utils.errors.DataAccessEmptyWarning;
import com.commons.utils.models.entities.TipoTramite;
import com.commons.utils.utils.Response;
import com.microservicios.tipotramite.services.ITipoTramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = { "*" }, allowedHeaders = { "*" })
@RestController
public class TipoTramiteController {

   @Autowired
   private ITipoTramiteService service;

   @GetMapping(path = "/findAll")
   public ResponseEntity<?> findAll() {
      List<TipoTramite> tipoTramiteDb = service.findAll();
      if (tipoTramiteDb.size() == 0)
         throw new DataAccessEmptyWarning();

      return ResponseEntity.ok()
            .body(Response.builder().message(Messages.GET_MESSAGE_SUCCESS_LIST_ENTITY()).data(tipoTramiteDb).build());
   }

   @GetMapping(path = "/test")
   public String test(@Value("${spring.datasource.url}") String ds) {
      String microservicio = System.getProperty("microservicio");
      return microservicio;
   }

}
