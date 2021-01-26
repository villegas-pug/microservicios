package com.microservicios.interpol.services;

import com.commons.utils.services.CommonService;
import com.microservicios.interpol.models.entity.Interpol;
import com.microservicios.interpol.models.repository.InterpolRepository;
import org.springframework.stereotype.Service;

@Service
public class InterpolService extends CommonService<Interpol, InterpolRepository> implements IInterpolService {

}