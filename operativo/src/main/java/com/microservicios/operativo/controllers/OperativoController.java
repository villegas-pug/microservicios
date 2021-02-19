package com.microservicios.operativo.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * OperativoController
 */
@RestController
public class OperativoController {

   @GetMapping(path = "/getProperties")
   public String getProperties(@Value("${perfil}") String propertie) {
      return propertie;
   }

}