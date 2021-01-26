package com.microservicios.interpol.controllers;

import com.commons.utils.controllers.CommonController;
import com.microservicios.interpol.models.entity.Interpol;
import com.microservicios.interpol.services.IInterpolService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterpolController extends CommonController<Interpol, IInterpolService> {

}
