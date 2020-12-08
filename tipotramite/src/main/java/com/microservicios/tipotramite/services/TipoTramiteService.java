package com.microservicios.tipotramite.services;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import com.commons.utils.models.entities.TipoTramite;
import com.microservicios.tipotramite.models.repository.TipoTramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class TipoTramiteService implements ITipoTramiteService {

   @Autowired
   private TipoTramiteRepository repository;

   @Override
   @Transactional(readOnly = true)
   public List<TipoTramite> findAll() {
      return repository.findAll();
   }

   @Override
   public Optional<TipoTramite> finddById(Long id) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public TipoTramite save(TipoTramite entity) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Long count() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void delete(TipoTramite entity) {
      // TODO Auto-generated method stub

   }

   @Override
   public void deleteById(Long id) {
      // TODO Auto-generated method stub

   }

   @Override
   public String generateRpt(int id, HttpServletResponse response) throws JRException, IOException {

      List<TipoTramite> tipoTramiteDb = new ArrayList<>();
      tipoTramiteDb.add(repository.findById(id).get());

      File file = ResourceUtils.getFile("classpath:RptTest.jrxml");

      JasperReport jpRpt = JasperCompileManager.compileReport(file.getAbsolutePath());
      JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(tipoTramiteDb);

      JasperPrint jpPrint = JasperFillManager.fillReport(jpRpt, null, ds);

      response.setContentType("application/x-pdf");
      final OutputStream output = response.getOutputStream();

      JasperExportManager.exportReportToPdfStream(jpPrint, output);

      return "Reporte generado exitosamente!!!";
   }

}
