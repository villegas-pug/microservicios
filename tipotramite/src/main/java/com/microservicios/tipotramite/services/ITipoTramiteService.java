package com.microservicios.tipotramite.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import com.commons.utils.models.entities.TipoTramite;
import net.sf.jasperreports.engine.JRException;

public interface ITipoTramiteService {
   List<TipoTramite> findAll();

   Optional<TipoTramite> finddById(Long id);

   TipoTramite save(TipoTramite entity);

   Long count();

   void delete(TipoTramite entity);

   void deleteById(Long id);

   String generateRpt(int id, HttpServletResponse response) throws JRException, IOException;
}
