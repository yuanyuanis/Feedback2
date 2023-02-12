package com.yuanyuanis.concurrente.javafx.listview;


public class Pelicula {

    private Integer anio;
    private String titulo;

    public Pelicula(Integer anio, String titulo) {
        this.anio = anio;
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "anio='" + anio + '\'' +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
