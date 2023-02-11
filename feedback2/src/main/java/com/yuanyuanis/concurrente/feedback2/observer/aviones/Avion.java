package com.yuanyuanis.concurrente.feedback2.observer.aviones;


import lombok.Getter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Observable;
import java.util.Observer;

@Getter
public class Avion {

    public enum Direccion {
        DERECHA, IZQUIERDA;
    }

    public enum Accion {
        SUBIR, BAJAR, ACELERAR, FRENAR, GIRAR;
    }

    private int altura;
    private int velocidad;
    private Direccion direccion;

    private Accion accion;
    private PropertyChangeSupport support;


    public Avion(int altura, int velocidad, Direccion direccion) {
        this.altura = altura;
        this.velocidad = velocidad;
        this.direccion = direccion;
    }

    public void addObserver(PropertyChangeListener observer) {
        support.addPropertyChangeListener(observer);
    }



    // Acciones

    public void subir() {
        altura += 100;
        accion = Accion.SUBIR;
        if (this instanceof AvionPerseguidor == false)
            support.firePropertyChange("Accion", null, Accion.SUBIR);
    }

    public void bajar() {
        altura -= 100;
        accion = Accion.BAJAR;
        if (this instanceof AvionPerseguidor == false)
            support.firePropertyChange("Accion", null, Accion.BAJAR);
    }

    public void acelerar() {
        velocidad += 200;
        accion = Accion.ACELERAR;
        if (this instanceof AvionPerseguidor == false)
            support.firePropertyChange("Accion", null, Accion.ACELERAR);
    }

    public void frenar() {
        velocidad -= 200;
        accion = Accion.FRENAR;
        if (this instanceof AvionPerseguidor == false)
            support.firePropertyChange("Accion", null, Accion.FRENAR);
    }

    public void girar(Direccion direccion) {
        this.direccion = direccion;
        accion = Accion.GIRAR;
        if (this instanceof AvionPerseguidor == false)
            support.firePropertyChange("Accion", null, Accion.GIRAR);
    }



}