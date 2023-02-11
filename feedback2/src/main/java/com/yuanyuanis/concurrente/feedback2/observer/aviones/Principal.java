package com.yuanyuanis.concurrente.feedback2.observer.aviones;

/**
 * Clase Principal
 */
public class Principal {

    public static void main(String args[]) {


        Avion avion = new Avion(1000, 100, TipoMovimiento.Direccion.DERECHA);
        AvionPerseguidor perseguidor = new AvionPerseguidor(2000, 200, TipoMovimiento.Direccion.IZQUIERDA);
        avion.addObserver(perseguidor);

        /* Para cada cambio que hace el avión se podrá comprobar en pantalla
         * cómo ha ido reaccionando el avión perseguidor
         */
        avion.subir();
        avion.bajar();
        avion.bajar();
        avion.girar(TipoMovimiento.Direccion.IZQUIERDA);
        avion.girar(TipoMovimiento.Direccion.DERECHA);
        avion.acelerar();

        System.out.println();
        System.out.println("Altura perseguidor " + perseguidor.getAltura());
        System.out.println("Velocidad perseguidor " + perseguidor.getVelocidad());
        System.out.println("Dirección perseguidor " + perseguidor.getDirection().toString());
    }
}

