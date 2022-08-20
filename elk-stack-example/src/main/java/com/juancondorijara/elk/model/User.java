package com.juancondorijara.elk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class User {

    private int id;
    private String nombre;
    private String apellido;
    private String celular;
}
