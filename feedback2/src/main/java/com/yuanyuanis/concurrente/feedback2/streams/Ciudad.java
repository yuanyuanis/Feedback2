package com.yuanyuanis.concurrente.feedback2.streams;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@Builder
@ToString
@EqualsAndHashCode
public class Ciudad {

    private String nombre;
    private String provincia;
    private int personas;

    Ciudad(String provincia, String nombre, int personas) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.personas = personas;
    }
}
