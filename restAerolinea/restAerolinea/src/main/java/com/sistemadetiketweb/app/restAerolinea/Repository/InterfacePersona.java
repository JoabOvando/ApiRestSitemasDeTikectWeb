package com.sistemadetiketweb.app.restAerolinea.Repository;

import com.sistemadetiketweb.app.restAerolinea.Model.ModelPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface InterfacePersona extends JpaRepository<ModelPersona, Long> {
    Optional<ModelPersona> findByIdIdentificacion(Integer idIdentificacion);
}
