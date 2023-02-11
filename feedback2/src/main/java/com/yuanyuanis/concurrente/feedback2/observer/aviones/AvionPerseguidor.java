package com.yuanyuanis.concurrente.feedback2.observer.aviones;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


public class AvionPerseguidor extends Avion implements PropertyChangeListener {

    public AvionPerseguidor(int altura, int velocidad, TipoMovimiento.Direccion direccion) {

        super(altura, velocidad, direccion);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        TipoMovimiento tipoMovimiento = (TipoMovimiento) evt.getNewValue();

        System.out.println("Avión perseguidor tratando de perseguir ... nombre del thread: " + Thread.currentThread().getName());

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        switch (tipoMovimiento.getAccion()) {
            case SUBIR:
                subir();
                System.out.println("El perseguidor sube");
                break;
            case BAJAR:
                bajar();
                System.out.println("El perseguidor baja");
                break;
            case ACELERAR:
                acelerar();
                System.out.println("El perseguidor acelera");
                break;
            case FRENAR:
                frenar();
                System.out.println("El perseguidor frena");
                break;
            case GIRAR:
                girar(tipoMovimiento.getDireccion());
                System.out.println("El perseguidor gira");
                break;
            default:
        }
    }
}
