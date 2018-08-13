package com.educomser.domain;

/**
 *
 * @author Hugo Montes
 */
public class Departamento {

    private long id;
    private String categoria;
    private String descripcion;

    public Departamento() {
    }

    public Departamento(String categoria, String descripcion) {
        this.categoria = categoria;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Departamento{" + "id=" + id + ", categoria=" + categoria + ", descripcion=" + descripcion + '}';
    }

}
