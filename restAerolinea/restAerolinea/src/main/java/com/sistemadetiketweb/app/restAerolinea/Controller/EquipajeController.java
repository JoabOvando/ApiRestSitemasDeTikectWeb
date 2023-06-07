package com.sistemadetiketweb.app.restAerolinea.Controller;

import com.sistemadetiketweb.app.restAerolinea.Model.ModelEquipaje;
import com.sistemadetiketweb.app.restAerolinea.Repository.InterfaceEquipaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipajes")
public class EquipajeController {
    @Autowired
    private InterfaceEquipaje equipajeRepository;

    @GetMapping
    public List<ModelEquipaje> getAllEquipajes() {
        return equipajeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelEquipaje> getEquipajeById(@PathVariable Integer id) {
        Optional<ModelEquipaje> equipaje = equipajeRepository.findById(id);
        if (equipaje.isPresent()) {
            return ResponseEntity.ok(equipaje.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelEquipaje> insertEquipaje(@RequestBody ModelEquipaje equipaje) {
        ModelEquipaje newEquipaje = equipajeRepository.save(equipaje);
        return ResponseEntity.ok(newEquipaje);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelEquipaje> updateEquipaje(@PathVariable Integer id, @RequestBody ModelEquipaje equipaje) {
        Optional<ModelEquipaje> equipajeOptional = equipajeRepository.findById(id);

        if (equipajeOptional.isPresent()) {
            ModelEquipaje existingEquipaje = equipajeOptional.get();
            existingEquipaje.setIdVuelo(equipaje.getIdVuelo());
            existingEquipaje.setIdReservacion(equipaje.getIdReservacion());
            existingEquipaje.setIdIdentificacion(equipaje.getIdIdentificacion());
            existingEquipaje.setNoEquipaje(equipaje.getNoEquipaje());
            existingEquipaje.setPesoEquipaje(equipaje.getPesoEquipaje());
            existingEquipaje.setValidacion(equipaje.getValidacion());
            existingEquipaje.setHoraReservacion(equipaje.getHoraReservacion());

            ModelEquipaje updatedEquipaje = equipajeRepository.save(existingEquipaje);
            return ResponseEntity.ok(updatedEquipaje);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEquipajeById(@PathVariable Integer id) {
        Optional<ModelEquipaje> equipaje = equipajeRepository.findById(id);
        if (equipaje.isPresent()) {
            equipajeRepository.delete(equipaje.get());
            return ResponseEntity.ok("Equipaje deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
