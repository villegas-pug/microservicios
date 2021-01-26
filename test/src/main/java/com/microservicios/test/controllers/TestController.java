package com.microservicios.test.controllers;

import com.commons.utils.controllers.CommonController;
import com.commons.utils.models.entities.Pais;
import com.microservicios.test.services.ITestService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController extends CommonController<Pais, ITestService> {

}
