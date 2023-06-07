package com.sistemadetiketweb.app.restAerolinea.Model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_rol")
public class ModelRol {
    @Id
    @Column(name = "id_rol")
    private int idRol;

    @Column(name = "nombre_rol")
    private String nombreRol;

    // Getters y Setters

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
