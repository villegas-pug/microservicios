package com.microservicios.test.controllers;

import com.commons.utils.errors.DataAccessEmptyWarning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
   @GetMapping(path = "/test")
   public String test() {
      throw new DataAccessEmptyWarning();
      /*
       * return System.getProperty("entity") + " : " +
       * System.getProperty("microservicio");
       */
   }
}
