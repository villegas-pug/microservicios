package com.microservicios.interpol.services;

import java.util.List;
import com.commons.utils.services.ICommonService;
import com.microservicios.interpol.models.entity.Interpol;

public interface IInterpolService extends ICommonService<Interpol> {
   List<Interpol> findByAppox(String nombres, String apellidos, String cedula, String pasaporte);
}
