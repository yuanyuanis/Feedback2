package com.yuanyuanis.concurrente.javafx.listview;


public class Pelicula {

    private String anio;
    private String titulo;

    public Pelicula(String anio, String titulo) {
        this.anio = anio;
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
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
