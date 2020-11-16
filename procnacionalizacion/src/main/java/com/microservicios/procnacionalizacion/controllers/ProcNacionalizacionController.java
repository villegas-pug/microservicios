package com.microservicios.procnacionalizacion.controllers;

import java.util.Date;

import com.commons.utils.models.entities.Etapa;
import com.commons.utils.models.entities.EtapaProcNacionalizacion;
import com.commons.utils.models.entities.ProcNacionalizacion;
import com.commons.utils.models.entities.Usuario;
import com.microservicios.procnacionalizacion.services.IProcNacionalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
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

   @PostMapping(path = "/save")
   public ResponseEntity<?> registrarProcNacionalizacion(
         @RequestBody ProcNacionalizacionAndUsuario procNacAndUsuarios) {

      ProcNacionalizacion newProcNacionalizacion = procNacAndUsuarios.procNacionalizacion;
      EtapaProcNacionalizacion newEtapaProcNac = new EtapaProcNacionalizacion();
      Usuario usrIniAndFin = procNacAndUsuarios.usuario;
      String numeroTramite = procNacAndUsuarios.procNacionalizacion.getNumeroTramite();

      newEtapaProcNac.setEtapa(service.findByIdEtapa((long) 3));
      newEtapaProcNac.setFechaHoraInicio(new Date());
      newEtapaProcNac.setUsuarioInicia(usrIniAndFin);
      newEtapaProcNac.setUsuarioFinaliza(usrIniAndFin);
      newEtapaProcNac.setNumeroTramite(numeroTramite);

      newProcNacionalizacion.addEtapaProcNacionalizacion(newEtapaProcNac);

      service.save(newProcNacionalizacion);

      return null;
      /*
       * etapaProcNac.set return
       * ResponseEntity.ok().body(service.save(procNacionalizacion));
       */
   }

   @GetMapping(path = "/test")
   public String test(@Value("${spring.datasource.url}") String ds) {
      /* throw new DataAccessEmptyWarning(); */
      return ds;
   }

   static class ProcNacionalizacionAndUsuario {
      public ProcNacionalizacion procNacionalizacion;
      public Usuario usuario;
   }
}
