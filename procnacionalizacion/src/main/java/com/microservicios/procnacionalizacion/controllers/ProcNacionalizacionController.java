package com.microservicios.procnacionalizacion.controllers;

import com.commons.utils.models.entities.ProcNacionalizacion;
import com.microservicios.procnacionalizacion.services.IProcNacionalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" }, allowedHeaders = { "*" })
@RestController
public class ProcNacionalizacionController {

   @Autowired
   private IProcNacionalizacionService service;

   @GetMapping(path = "/getAll")
   public ResponseEntity<?> getAll() {
      return ResponseEntity.ok().body(service.findAll());
   }

   @PostMapping(path = "/registrar")
   public ResponseEntity<?> registrarProcNacionalizacion(@RequestBody ProcNacionalizacion procNacionalizacion) {
      return ResponseEntity.ok().body(service.save(procNacionalizacion));
   }

   @GetMapping(path = "/test")
   public String test(@Value("${spring.datasource.url}") String ds) {
      /* throw new DataAccessEmptyWarning(); */
      return ds;
   }
}
