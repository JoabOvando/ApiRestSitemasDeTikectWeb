package com.sistemadetiketweb.app.restAerolinea.Model;

import javax.persistence.*;

@Entity
@Table(name = "tbl_permiso")
public class ModelPermiso {
    @Id
    @Column(name = "id_permiso")
    private int idPermiso;

    @Column(name = "nombre_permiso")
    private String nombrePermiso;

    // Getters y Setters

    public int getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(int idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }
}
