package com.sistemadetiketweb.app.restAerolinea.Repository;

import com.sistemadetiketweb.app.restAerolinea.Model.ModelVuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InterfaceVuelo extends JpaRepository<ModelVuelo, Integer> {
}
