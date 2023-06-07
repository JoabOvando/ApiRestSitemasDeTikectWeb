package com.sistemadetiketweb.app.restAerolinea.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_equipaje")
public class ModelEquipaje {
    @Id
    @Column(name = "id_equipaje")
    private int idEquipaje;

    @Column(name = "id_vuelo")
    private int idVuelo;

    @Column(name = "id_reservacion")
    private int idReservacion;

    @Column(name = "id_identificacion")
    private int idIdentificacion;

    @Column(name = "no_equipaje")
    private String noEquipaje;

    @Column(name = "peso_equipaje")
    private int pesoEquipaje;

    @Column(name = "validacion")
    private String validacion;

    @Column(name = "hora_reservacion")
    private Date horaReservacion;

    // Getters y Setters

    public int getIdEquipaje() {
        return idEquipaje;
    }

    public void setIdEquipaje(int idEquipaje) {
        this.idEquipaje = idEquipaje;
    }

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

    public String getNoEquipaje() {
        return noEquipaje;
    }

    public void setNoEquipaje(String noEquipaje) {
        this.noEquipaje = noEquipaje;
    }

    public int getPesoEquipaje() {
        return pesoEquipaje;
    }

    public void setPesoEquipaje(int pesoEquipaje) {
        this.pesoEquipaje = pesoEquipaje;
    }

    public String getValidacion() {
        return validacion;
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }

    public Date getHoraReservacion() {
        return horaReservacion;
    }

    public void setHoraReservacion(Date horaReservacion) {
        this.horaReservacion = horaReservacion;
    }
}
