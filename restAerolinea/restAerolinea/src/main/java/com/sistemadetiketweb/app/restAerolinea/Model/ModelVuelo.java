package com.sistemadetiketweb.app.restAerolinea.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_vuelo")
public class ModelVuelo {
    @Id
    @Column(name = "id_vuelo")
    private int idVuelo;

    @Column(name = "id_reservacion")
    private int idReservacion;

    @Column(name = "id_identificacion")
    private int idIdentificacion;

    @Column(name = "asiento")
    private String asiento;

    @Column(name = "hora_abordaje")
    private Date horaAbordaje;

    @Column(name = "tiempo_vuelo")
    private int tiempoVuelo;

    @Column(name = "no_ticket")
    private String noTicket;

    // Getters y Setters

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

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

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Date getHoraAbordaje() {
        return horaAbordaje;
    }

    public void setHoraAbordaje(Date horaAbordaje) {
        this.horaAbordaje = horaAbordaje;
    }

    public int getTiempoVuelo() {
        return tiempoVuelo;
    }

    public void setTiempoVuelo(int tiempoVuelo) {
        this.tiempoVuelo = tiempoVuelo;
    }

    public String getNoTicket() {
        return noTicket;
    }

    public void setNoTicket(String noTicket) {
        this.noTicket = noTicket;
    }
}
