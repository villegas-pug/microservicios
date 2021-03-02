package com.microservicios.distrito.controllers;

import com.commons.utils.controllers.CommonController;
import com.commons.utils.models.entities.Distrito;
import com.microservicios.distrito.services.DistritoService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@CrossOrigin(origins = { "*" })
@RestController
public class DistritoController extends CommonController<Distrito, DistritoService> {

}