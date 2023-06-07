package com.sistemadetiketweb.app.restAerolinea.Repository;

import com.sistemadetiketweb.app.restAerolinea.Model.ModelEquipaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InterfaceEquipaje extends JpaRepository<ModelEquipaje, Integer> {
}
