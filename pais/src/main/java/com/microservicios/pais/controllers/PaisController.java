package com.microservicios.pais.controllers;

import java.util.Arrays;
import java.util.Optional;

import com.commons.utils.constants.Messages;
import com.commons.utils.controllers.CommonController;
import com.commons.utils.errors.DataAccessEmptyWarning;
import com.commons.utils.models.entities.Pais;
import com.commons.utils.utils.Response;
import com.microservicios.pais.services.PaisService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RefreshScope
@CrossOrigin(origins = { "*" }, allowedHeaders = { "*" })
@RestController
public class PaisController extends CommonController<Pais, PaisService> {

   @GetMapping(path = "/findByNacionalidad/{nacionalidad}")
   public ResponseEntity<?> findByNacionalidad(@PathVariable String nacionalidad) {

      Optional<Pais> paisDb = super.service.findByNacionalidad(nacionalidad);

      if (!paisDb.isPresent())
         throw new DataAccessEmptyWarning();

      return ResponseEntity.ok().body(paisDb);
   }

}
