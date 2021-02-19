package com.microservicios.interpol.models.repository;

import java.util.List;
import com.microservicios.interpol.models.entity.Interpol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InterpolRepository extends JpaRepository<Interpol, Long> {

   /* @Query("SELECT i FROM Interpol i WHERE i.fechaEmision = :fechaEmision") */
   @Query("SELECT i FROM Interpol i WHERE i.nombres LIKE %:nombres% AND i.apellidos LIKE %:apellidos% AND i.cedula LIKE %:cedula% AND i.pasaporte LIKE %:pasaporte% ORDER BY i.fechaEmision DESC")
   List<Interpol> findByAppox(@Param("nombres") String nombres, @Param("apellidos") String apellidos,
         @Param("cedula") String cedula, @Param("pasaporte") String pasaporte);

}
