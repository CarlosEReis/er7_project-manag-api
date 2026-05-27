package com.er7.project_manag.domain.shared.valueobjects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CorTest {

    @ParameterizedTest
    @ValueSource(strings = {"#FFFFFF", "#000000", "#ff0000", "#1a2b3c", "#FF5733"})
    @DisplayName("Deve criar a cor com sucesso quando codigo hexadecimal for válido")
    void deveCriarCorComSucesso(String codigoHexadecimal) {
        var cor = new Cor(codigoHexadecimal);
        assertEquals(codigoHexadecimal, cor.valor());
    }

    @ParameterizedTest
    @ValueSource(strings = {"#FFF", "FF0000", "#GG0000", "#1234567", "azul", "  "})
    @DisplayName("Deve lançar uma exceção ao tentar criar uma cor com formatos hexadecimais inválidos")
    void deveLancarExcecaoParaFormatosInvalidos(String codigoInvalido) {
        var exception = assertThrows(IllegalArgumentException.class, () -> new Cor(codigoInvalido));
        assertTrue(exception.getMessage().contains("Cor inválida"));
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar criar cor passando valor nulo")
    void deveLancarExcecaoParaValorNulo() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Cor(null));
    }

    @Test
    @DisplayName("Deve garantir a igualdade estrutural entre dois objetos Cor com o mesmo valor")
    void deveGarantirIgualdadeEstrutural() {
        var cor1 = new Cor("#FF0000");
        var cor2 = new Cor("#FF0000");
        var corDiferente = new Cor("#00FF00");

        assertEquals(cor1, cor2);
        assertNotEquals(cor1, corDiferente);
        assertEquals(cor1.hashCode(), cor2.hashCode());
        assertNotEquals(cor1.hashCode(), corDiferente.hashCode());
    }
}
