package com.er7.project_manag.domain.models.usuario;

public record Senha(String valor) {

    public Senha {
        if (valor == null || valor.isBlank())
            throw new IllegalArgumentException("A senha não pode ser vazia.");
    }
}
