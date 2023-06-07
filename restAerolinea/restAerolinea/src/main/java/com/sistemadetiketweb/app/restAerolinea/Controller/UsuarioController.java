package com.sistemadetiketweb.app.restAerolinea.Controller;

import com.sistemadetiketweb.app.restAerolinea.Model.ModelUsuario;
import com.sistemadetiketweb.app.restAerolinea.Repository.InterfaceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "http://localhost:4200") //permitir solicitudes desde tu aplicación Angular
public class UsuarioController {
    @Autowired
    private InterfaceUsuario usuarioRepository;

    @GetMapping
    public List<ModelUsuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{nombreUsuario}/{contraseña}")
    public ResponseEntity<Integer> validarCredenciales(@PathVariable String nombreUsuario, @PathVariable String contraseña) {
        // Lógica para validar las credenciales
        Optional<ModelUsuario> usuario = usuarioRepository.findByNombreUsuarioAndContraseña(nombreUsuario, contraseña);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(1); // Credenciales válidas
        } else {
            return ResponseEntity.ok(0); // Credenciales inválidas
        }
    }


    @PostMapping("/")
    public ResponseEntity<ModelUsuario> insertUsuario(@RequestBody ModelUsuario usuario) {
        ModelUsuario newUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.ok(newUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelUsuario> updateUsuario(@PathVariable Integer id, @RequestBody ModelUsuario usuario) {
        Optional<ModelUsuario> usuarioOptional = usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            ModelUsuario existingUsuario = usuarioOptional.get();
            existingUsuario.setIdIdentificacion(usuario.getIdIdentificacion());
            existingUsuario.setNombreUsuario(usuario.getNombreUsuario());
            existingUsuario.setContraseña(usuario.getContraseña());
            existingUsuario.setNombre(usuario.getNombre());
            existingUsuario.setApellido(usuario.getApellido());
            existingUsuario.setIdRol(usuario.getIdRol());

            ModelUsuario updatedUsuario = usuarioRepository.save(existingUsuario);
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuarioById(@PathVariable Integer id) {
        Optional<ModelUsuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioRepository.delete(usuario.get());
            return ResponseEntity.ok("Usuario deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
