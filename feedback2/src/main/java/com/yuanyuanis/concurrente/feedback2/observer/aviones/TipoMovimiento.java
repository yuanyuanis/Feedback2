package com.yuanyuanis.concurrente.feedback2.observer.aviones;

import lombok.Data;

@Data
public class TipoMovimiento {


    public enum Direccion {
        DERECHA, IZQUIERDA;
    }

    public enum Accion {
        SUBIR, BAJAR, ACELERAR, FRENAR, GIRAR;
    }

    private Accion accion;
    private Direccion direccion;
}
