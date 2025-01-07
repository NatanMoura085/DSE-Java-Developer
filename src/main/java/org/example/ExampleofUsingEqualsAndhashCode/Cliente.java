package org.example.ExampleofUsingEqualsAndhashCode;

import org.example.ExampleofUsingEqualsAndhashCode.model.Produto;

public class Cliente {
    public static void main(String[] args) {

            Produto p1 = new Produto(1, "Celular");
            Produto p2 = new Produto(1, "Celular");

            System.out.println(p1.equals(p2)); // true

    }
}
