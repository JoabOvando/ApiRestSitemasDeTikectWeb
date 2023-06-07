package com.sistemadetiketweb.app.restAerolinea.Repository;

import com.sistemadetiketweb.app.restAerolinea.Model.ModelUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface InterfaceUsuario extends JpaRepository<ModelUsuario, Integer> {
    Optional<ModelUsuario> findByNombreUsuarioAndContraseña(String nombreUsuario, String contraseña);

}
