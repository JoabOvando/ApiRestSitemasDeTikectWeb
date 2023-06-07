package com.sistemadetiketweb.app.restAerolinea.Controller;

import com.sistemadetiketweb.app.restAerolinea.Model.ModelRol;
import com.sistemadetiketweb.app.restAerolinea.Repository.InterfaceRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private InterfaceRol rolRepository;

    @GetMapping
    public List<ModelRol> getAllRoles() {
        return rolRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelRol> getRolById(@PathVariable Integer id) {
        Optional<ModelRol> rol = rolRepository.findById(id);
        if (rol.isPresent()) {
            return ResponseEntity.ok(rol.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<ModelRol> insertRol(@RequestBody ModelRol rol) {
        ModelRol newRol = rolRepository.save(rol);
        return ResponseEntity.ok(newRol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelRol> updateRol(@PathVariable Integer id, @RequestBody ModelRol rol) {
        Optional<ModelRol> rolOptional = rolRepository.findById(id);

        if (rolOptional.isPresent()) {
            ModelRol existingRol = rolOptional.get();
            existingRol.setNombreRol(rol.getNombreRol());

            ModelRol updatedRol = rolRepository.save(existingRol);
            return ResponseEntity.ok(updatedRol);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRolById(@PathVariable Integer id) {
        Optional<ModelRol> rol = rolRepository.findById(id);
        if (rol.isPresent()) {
            rolRepository.delete(rol.get());
            return ResponseEntity.ok("Rol deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
