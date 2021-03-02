package com.microservicios.distrito.services;

import com.commons.utils.models.entities.Distrito;
import com.commons.utils.services.CommonServiceImp;
import com.microservicios.distrito.models.repository.DistritoRepository;
import org.springframework.stereotype.Service;

@Service
public class DistritoServiceImp extends CommonServiceImp<Distrito, DistritoRepository> implements DistritoService {

}