package com.microservicios.etapa.controllers;

import java.util.List;
import java.util.Optional;
import com.commons.utils.errors.DataAccessEmptyWarning;
import com.commons.utils.errors.EntityFindByIdWarning;
import com.commons.utils.models.entities.Etapa;
import com.microservicios.etapa.services.IEtapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = { "*" }, allowedHeaders = { "*" })
@RestController
public class EtapaController {

   @Autowired
   private IEtapaService service;

   @GetMapping(path = "/findAll")
   public List<Etapa> findAll() {
      List<Etapa> etapaDb = service.findAll();
      if (etapaDb.size() == 0)
         throw new DataAccessEmptyWarning();

      return etapaDb;
   }

   @GetMapping(path = "/findById")
   public Etapa findById(@RequestParam Long id) {
      Optional<Etapa> etapa = service.finddById(id);
      if (etapa.isEmpty())
         throw new EntityFindByIdWarning(id.toString());

      return etapa.get();
   }

   @GetMapping(path = "/test")
   public String test() {
      String microservicio = System.getProperty("microservicio");
      return microservicio;
   }

}
