package com.sistemadetiketweb.app.restAerolinea.Repository;

import com.sistemadetiketweb.app.restAerolinea.Model.ModelPermiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InterfacePermiso extends JpaRepository<ModelPermiso, Integer> {
}
