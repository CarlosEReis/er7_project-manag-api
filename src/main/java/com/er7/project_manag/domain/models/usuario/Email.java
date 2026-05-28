package com.er7.project_manag.domain.models.usuario;

public record Email(String email) {

    public Email {
        if (email == null || email.isBlank())
            throw new IllegalArgumentException("O e-mail não pode ser vazio.");
    }
}
