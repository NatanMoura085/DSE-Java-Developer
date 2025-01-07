package org.example.ExampleofUsingEqualsAndhashCode.model;

import java.util.Objects;

public class Produto {
    private int id;
    private String nome;

    public Produto(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id && nome.equals(produto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }


}

