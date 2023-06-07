package com.sistemadetiketweb.app.restAerolinea.Controller;

import com.sistemadetiketweb.app.restAerolinea.Model.ModelVuelo;
import com.sistemadetiketweb.app.restAerolinea.Repository.InterfaceVuelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vuelos")
@CrossOrigin(origins = "http://localhost:4200") //permitir solicitudes desde tu aplicación Angular
public class VueloController {
    @Autowired
    private InterfaceVuelo vueloRepository;

    @GetMapping
    public List<ModelVuelo> getAllVuelos() {
        return vueloRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelVuelo> getVueloById(@PathVariable Integer id) {
        Optional<ModelVuelo> vuelo = vueloRepository.findById(id);
        if (vuelo.isPresent()) {
            return ResponseEntity.ok(vuelo.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelVuelo> insertVuelo(@RequestBody ModelVuelo vuelo) {
        ModelVuelo newVuelo = vueloRepository.save(vuelo);
        return ResponseEntity.ok(newVuelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelVuelo> updateVuelo(@PathVariable Integer id, @RequestBody ModelVuelo vuelo) {
        Optional<ModelVuelo> vueloOptional = vueloRepository.findById(id);

        if (vueloOptional.isPresent()) {
            ModelVuelo existingVuelo = vueloOptional.get();
            existingVuelo.setIdReservacion(vuelo.getIdReservacion());
            existingVuelo.setIdIdentificacion(vuelo.getIdIdentificacion());
            existingVuelo.setAsiento(vuelo.getAsiento());
            existingVuelo.setHoraAbordaje(vuelo.getHoraAbordaje());
            existingVuelo.setTiempoVuelo(vuelo.getTiempoVuelo());
            existingVuelo.setNoTicket(vuelo.getNoTicket());

            ModelVuelo updatedVuelo = vueloRepository.save(existingVuelo);
            return ResponseEntity.ok(updatedVuelo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVueloById(@PathVariable Integer id) {
        Optional<ModelVuelo> vuelo = vueloRepository.findById(id);
        if (vuelo.isPresent()) {
            vueloRepository.delete(vuelo.get());
            return ResponseEntity.ok("Vuelo deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
