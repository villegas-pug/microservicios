package com.microservicios.interpol.models.repository;

import java.util.List;
import com.microservicios.interpol.models.entity.Interpol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InterpolRepository extends JpaRepository<Interpol, Long> {

   /* @Query("SELECT i FROM Interpol i WHERE i.fechaEmision = :fechaEmision") */
   @Query("SELECT i FROM Interpol i WHERE i.nombres LIKE %?1% AND i.apellidos LIKE %?2% AND i.cedula LIKE %?3% AND i.pasaporte LIKE %?4% ORDER BY i.fechaEmision DESC")
   List<Interpol> findByAppox(String nombres, String apellidos, String cedula, String pasaporte);

}
