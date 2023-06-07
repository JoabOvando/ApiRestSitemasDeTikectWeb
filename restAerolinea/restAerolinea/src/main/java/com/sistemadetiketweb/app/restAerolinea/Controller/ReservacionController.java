package com.sistemadetiketweb.app.restAerolinea.Controller;

import com.sistemadetiketweb.app.restAerolinea.Model.ModelPersona;
import com.sistemadetiketweb.app.restAerolinea.Model.Reservacion;
import com.sistemadetiketweb.app.restAerolinea.Repository.ReservacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservaciones")
public class ReservacionController {
    @Autowired
    private ReservacionRepository reservacionRepository;

    @GetMapping
    public List<Reservacion> getAllPersonas() {
        return reservacionRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservacion> getReservacionById(@PathVariable int id) {
        Optional<Reservacion> reservacion = reservacionRepository.findById(id);
        if (reservacion.isPresent()) {
            return ResponseEntity.ok(reservacion.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Reservacion> insertReservacion(@RequestBody Reservacion reservacion) {
        Reservacion newReservacion = reservacionRepository.save(reservacion);
        return ResponseEntity.ok(newReservacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservacion> updateReservacion(@PathVariable int id, @RequestBody Reservacion reservacionDetails) {
        Optional<Reservacion> optionalReservacion = reservacionRepository.findById(id);
        if (optionalReservacion.isPresent()) {
            Reservacion reservacion = optionalReservacion.get();
            reservacion.setNumReservacion(reservacionDetails.getNumReservacion());
            reservacion.setNumVuelo(reservacionDetails.getNumVuelo());
            reservacion.setNumSalida(reservacionDetails.getNumSalida());
            reservacion.setDestino(reservacionDetails.getDestino());
            reservacion.setHoraSalida(reservacionDetails.getHoraSalida());
            reservacion.setHoraLlegada(reservacionDetails.getHoraLlegada());
            reservacion.setFechaSalida(reservacionDetails.getFechaSalida());
            reservacion.setFechaLlegada(reservacionDetails.getFechaLlegada());
            Reservacion updatedReservacion = reservacionRepository.save(reservacion);
            return ResponseEntity.ok(updatedReservacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservacion(@PathVariable int id) {
        Optional<Reservacion> reservacion = reservacionRepository.findById(id);
        if (reservacion.isPresent()) {
            reservacionRepository.deleteById(id);
            return ResponseEntity.ok("Reservacion deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
