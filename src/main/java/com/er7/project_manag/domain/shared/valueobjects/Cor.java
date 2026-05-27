package com.er7.project_manag.domain.shared.valueobjects;

public record Cor(String valor) {

    public Cor {
        if (valor == null || !valor.matches("#[0-9a-fA-F]{6}"))
            throw new IllegalArgumentException(
                "Cor inválida. O código deve estar no formato Hexadecimal (Ex: #RRGGBB).");
    }
}
