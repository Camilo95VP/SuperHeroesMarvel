package org.example.utilities;

import java.util.List;

public class SuperHeroe {
    String nombre;
    String descripcion;

    public SuperHeroe(String nombre, List<List> descripcion) {
        this.nombre = nombre;
        this.descripcion = String.valueOf(descripcion);
    }

    public SuperHeroe(String name, String description) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
