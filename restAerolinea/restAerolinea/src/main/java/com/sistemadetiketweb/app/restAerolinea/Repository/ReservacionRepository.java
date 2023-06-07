package com.sistemadetiketweb.app.restAerolinea.Repository;

import com.sistemadetiketweb.app.restAerolinea.Model.ModelPersona;
import com.sistemadetiketweb.app.restAerolinea.Model.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface ReservacionRepository extends JpaRepository<Reservacion, Integer> {
    Optional<Reservacion> findByIdIdentificacion(Integer idIdentificacion);
}
