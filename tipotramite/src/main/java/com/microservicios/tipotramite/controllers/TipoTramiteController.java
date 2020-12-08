package com.microservicios.tipotramite.controllers;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import net.sf.jasperreports.engine.JRException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

   @GetMapping(path = "/rpt/{id}")
   public String generateRpt(@PathVariable int id, HttpServletResponse response) throws JRException, IOException {
      return service.generateRpt(id, response);
   }
}
