package com.microservicios.procnacionalizacion.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.commons.utils.constants.Messages;
import com.commons.utils.errors.DataAccessEmptyWarning;
import com.commons.utils.models.entities.Etapa;
import com.commons.utils.models.entities.EtapaProcNacionalizacion;
import com.commons.utils.models.entities.ProcNacionalizacion;
import com.commons.utils.models.entities.Usuario;
import com.commons.utils.utils.Response;
import com.microservicios.procnacionalizacion.services.IProcNacionalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = { "*" })
@RestController
public class ProcNacionalizacionController {

   @Autowired
   private IProcNacionalizacionService service;

   @GetMapping(path = "/getAll")
   public ResponseEntity<?> getAll() {
      return ResponseEntity.ok().body(service.findAll());
   }

   @PostMapping(path = "/save")
   public ResponseEntity<?> registrarProcNacionalizacion(@RequestBody ProcNacAndUsr procNacAndUsr) {

      /*-> Común...  */
      Usuario usrIniAndFin = procNacAndUsr.usuario;
      Etapa etapaActual = service.findByIdEtapa((long) 3);/*-> Etapa: `Resgistro de Datos` ...*/
      procNacAndUsr.procNacionalizacion.setEstado("P");/*-> Estado: `PENDIENTE`...  */
      procNacAndUsr.procNacionalizacion.setEtapaActualProcNac(etapaActual);

      /*-> Validación: Si...   */
      var idProcNac = procNacAndUsr.procNacionalizacion.getIdProcNac();

      if (idProcNac == null) {/*-> Nuevo...  */
         EtapaProcNacionalizacion newEtapaProcNac = new EtapaProcNacionalizacion();
         newEtapaProcNac.setEtapa(etapaActual);
         newEtapaProcNac.setUsuarioInicia(usrIniAndFin);
         newEtapaProcNac.setUsuarioFinaliza(usrIniAndFin);
         newEtapaProcNac.setNumeroTramite(procNacAndUsr.procNacionalizacion.getNumeroTramite());
         procNacAndUsr.procNacionalizacion.addEtapaProcNacionalizacion(newEtapaProcNac);/*-> Save... */
      } else {/*-> Editar  */

      }

      /* » Save-All: */
      service.save(procNacAndUsr.procNacionalizacion);

      return ResponseEntity.status(HttpStatus.CREATED)
            .body(Response.builder().message(Messages.MESSAGE_SUCCESS_CREATE).data(service.findAll()).build());
   }

   @GetMapping(path = "/findAll")
   public ResponseEntity<?> findAll() {
      List<ProcNacionalizacion> procNacionalizacionDb = service.findAll();
      if (procNacionalizacionDb.size() == 0)
         throw new DataAccessEmptyWarning();

      return ResponseEntity.ok().body(
            Response.builder().message(Messages.GET_MESSAGE_SUCCESS_LIST_ENTITY()).data(procNacionalizacionDb).build());
   }

   @GetMapping(path = "/test")
   public String test(@Value("${spring.datasource.url}") String ds) {
      /* throw new DataAccessEmptyWarning(); */
      return ds;
   }

   static class ProcNacAndUsr {
      public ProcNacionalizacion procNacionalizacion;
      public Usuario usuario;
   }
}
