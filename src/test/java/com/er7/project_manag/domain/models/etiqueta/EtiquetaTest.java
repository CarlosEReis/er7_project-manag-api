package com.er7.project_manag.domain.models.etiqueta;

import com.er7.project_manag.domain.shared.valueobjects.Cor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class EtiquetaTest {

    @Test
    @DisplayName("Alterar nome com sucesso")
    void alterarNomeComSucesso() {
        var etiqueta = new Etiqueta("BugFix", new Cor("#ffffff"));
        etiqueta.alterarNome("Feature");
        assert(etiqueta.getNome().equals("Feature"));
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar criar uma etiqueta com nome inválido")
    void deveLancarExcecaoAoCriarComNomeInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Etiqueta(null, new Cor("#ffffff")));
        assertThrows(IllegalArgumentException.class, () -> new Etiqueta("", new Cor("#ffffff")));
    }

    @Test
    @DisplayName("Lançar exceção ao atribuir nome inválido")
    void lancarExcecaoAoAtribuitNomeInvalido() {
        var etiqueta = new Etiqueta("BugFix", new Cor("#ffffff"));
        assertThrows(IllegalArgumentException.class, () -> etiqueta.alterarNome(null));
        assertThrows(IllegalArgumentException.class, () -> etiqueta.alterarNome(""));
    }

    @Test
    @DisplayName("Lançar exceção ao atribuir nome válido para etiqueta desativada")
    void lancarExcecaoAoAtribuirNomeParaEtiquetaDesativada() {
        var etiqueta = new Etiqueta("BugFix", new Cor("#ffffff"));
        etiqueta.desativar();
        assertThrows(IllegalArgumentException.class, () -> etiqueta.alterarNome("Feature")) ;
    }

    @Test
    @DisplayName("Alterar cor com sucesso")
    void alterarCorComSucesso() {
        var etiqueta = new Etiqueta("BugFix", new Cor("#ffffff"));
        etiqueta.alterarCor(new Cor("#ffff00"));
        assert(etiqueta.getCor().equals(new Cor("#ffff00")));
    }

    @Test
    @DisplayName("Lançar exceção ao adicionar cor com etiqueta inativa")
    void lancarExcecaoAoAdicionarCorParaEtiquetaInativa() {
        var etiqueta = new Etiqueta("BugFix", new Cor("#ffffff"));
        etiqueta.desativar();
        assertThrows(IllegalArgumentException.class, () -> etiqueta.alterarCor(new Cor("#ffff00")));
    }

    @Test
    @DisplayName("Deve verificar se ao criar etiqueta a mesma esta ativa")
    void verificaSeAoCriarEtiquetaEstaAtivo() {
        var etiqueta = new Etiqueta("BugFix", new Cor("#ffffff"));
        assert(etiqueta.isAtivo());
    }

    @Test
    @DisplayName("Deve desativar a etiqueta")
    void verificaSeEstaInativo() {
        var etiqueta = new Etiqueta("BugFix", new Cor("#ffffff"));
        etiqueta.desativar();
        assert(etiqueta.isInativa());
    }

    @Test
    @DisplayName("Deve ativar a etiqueta")
    void ativaEtiqueta() {
        var etiqueta = new Etiqueta("BugFix", new Cor("#ffffff"));
        etiqueta.desativar();
        assert(etiqueta.isInativa());
        etiqueta.ativar();
        assert(etiqueta.isAtivo());
    }

}
