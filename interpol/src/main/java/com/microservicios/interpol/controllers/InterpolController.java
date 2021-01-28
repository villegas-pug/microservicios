package com.microservicios.interpol.controllers;

import java.util.List;
import com.commons.utils.constants.Messages;
import com.commons.utils.controllers.CommonController;
import com.commons.utils.errors.DataAccessEmptyWarning;
import com.commons.utils.utils.Response;
import com.microservicios.interpol.models.entity.Interpol;
import com.microservicios.interpol.services.IInterpolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = { "*" })
@RestController
public class InterpolController extends CommonController<Interpol, IInterpolService> {

   @PostMapping(path = "/findByApprox")
   public ResponseEntity<?> findByAppox(@RequestBody Interpol interpol) {

      List<Interpol> interpoDb = super.service.findByAppox(interpol.getNombres(), interpol.getApellidos(),
            interpol.getCedula(), interpol.getPasaporte());

      if (interpoDb.size() == 0)
         throw new DataAccessEmptyWarning();

      return ResponseEntity.ok()
            .body(Response.builder().message(Messages.GET_MESSAGE_SUCCESS_LIST_ENTITY()).data(interpoDb).build());

   }

}
