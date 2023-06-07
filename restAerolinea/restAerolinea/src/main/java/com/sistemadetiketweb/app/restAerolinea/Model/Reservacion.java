package com.sistemadetiketweb.app.restAerolinea.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_reservacion")
public class Reservacion {
    @Id
    @Column(name = "id_reservacion")
    private int idReservacion;

    @Column(name = "id_identificacion")
    private int idIdentificacion;

    @Column(name = "num_reservacion")
    private String numReservacion;

    @Column(name = "num_vuelo")
    private String numVuelo;

    @Column(name = "num_salida")
    private String numSalida;

    @Column(name = "destino")
    private String destino;

    @Column(name = "hora_salida")
    private LocalDateTime horaSalida;

    @Column(name = "hora_llegada")
    private LocalDateTime horaLlegada;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;

    @Column(name = "fecha_llegada")
    private LocalDate fechaLlegada;
    //getter y setter
    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public int getIdIdentificacion() {
        return idIdentificacion;
    }

    public void setIdIdentificacion(int idIdentificacion) {
        this.idIdentificacion = idIdentificacion;
    }

    public String getNumReservacion() {
        return numReservacion;
    }

    public void setNumReservacion(String numReservacion) {
        this.numReservacion = numReservacion;
    }

    public String getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(String numVuelo) {
        this.numVuelo = numVuelo;
    }

    public String getNumSalida() {
        return numSalida;
    }

    public void setNumSalida(String numSalida) {
        this.numSalida = numSalida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDate getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(LocalDate fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    // Getters y Setters


}

