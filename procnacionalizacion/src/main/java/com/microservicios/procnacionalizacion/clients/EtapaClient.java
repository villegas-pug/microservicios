package com.microservicios.procnacionalizacion.clients;

import java.util.List;
import com.commons.utils.models.entities.Etapa;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservicio-etapa")
public interface EtapaClient {
   @GetMapping(path = "/findAll")
   List<Etapa> findAllEtapa();

   @GetMapping(path = "/findById")
   Etapa findByIdEtapa(@RequestParam Long id);

}
