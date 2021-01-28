package com.microservicios.interpol.services;

import java.util.List;
import com.commons.utils.services.CommonService;
import com.microservicios.interpol.models.entity.Interpol;
import com.microservicios.interpol.models.repository.InterpolRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InterpolService extends CommonService<Interpol, InterpolRepository> implements IInterpolService {

   @Transactional(readOnly = true)
   @Override
   public List<Interpol> findByAppox(String nombres, String apellidos, String cedula, String pasaporte) {
      return super.repository.findByAppox(nombres, apellidos, cedula, pasaporte);

   }

}