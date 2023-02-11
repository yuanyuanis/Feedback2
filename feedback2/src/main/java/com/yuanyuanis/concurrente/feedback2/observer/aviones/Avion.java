package com.yuanyuanis.concurrente.feedback2.observer.aviones;


import lombok.Getter;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

@Getter
public class Avion {


    private int altura;
    private int velocidad;
    private TipoMovimiento.Direccion direction;

    private TipoMovimiento.Accion action;
    private PropertyChangeSupport support;


    public Avion(int altura, int velocidad, TipoMovimiento.Direccion direction) {
        this.altura = altura;
        this.velocidad = velocidad;
        this.direction = direction;
        this.support = new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener observer) {
        support.addPropertyChangeListener(observer);
    }



    // Acciones

    public void subir() {
        altura += 100;
        action = TipoMovimiento.Accion.SUBIR;
        dispararEventoAObservadores(action, null);
    }

    public void bajar() {
        altura -= 100;
        action = TipoMovimiento.Accion.BAJAR;
        dispararEventoAObservadores(action, null);
    }

    public void acelerar() {
        velocidad += 200;
        action = TipoMovimiento.Accion.ACELERAR;
        dispararEventoAObservadores(action, null);
    }

    public void frenar() {
        velocidad -= 200;
        action = TipoMovimiento.Accion.FRENAR;
        dispararEventoAObservadores(action, null);
    }

    public void girar(TipoMovimiento.Direccion direction) {
        this.direction = direction;
        action = TipoMovimiento.Accion.GIRAR;
        dispararEventoAObservadores(action, direction);
    }



    private  void dispararEventoAObservadores(TipoMovimiento.Accion accion, TipoMovimiento.Direccion direction) {

        if (this instanceof AvionPerseguidor == false) {

            TipoMovimiento tipoMovimiento = new TipoMovimiento();
            tipoMovimiento.setAccion(accion);
            if(accion.equals(TipoMovimiento.Accion.GIRAR)) {
                tipoMovimiento.setDireccion(direction);
            }

            support.firePropertyChange("TipoMovimiento", null, tipoMovimiento);
        }
    }

}