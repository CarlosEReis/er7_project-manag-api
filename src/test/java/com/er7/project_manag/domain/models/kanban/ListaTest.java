package com.er7.project_manag.domain.models.kanban;

import com.er7.project_manag.domain.shared.valueobjects.Cor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListaTest {

    @Test
    @DisplayName("Deve lançar uma exceção ao tentar criar uma lista com nome nulo")
    void deveLancarExcecaoAoCriarComNomeInvalido() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Lista(null, new Cor("#ffffff"), "Descrição da lista", 1));
    }

    @Test
    @DisplayName("Deve lançar uma exceção ao tentar criar uma lista com nome vazio")
    void deveLancaExcecaoAoCriarComNomeVazio() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new Lista("", new Cor("#ffffff"), "Descrição da lista", 1));
    }

    @Test
    @DisplayName("Deve alterar o nome com sucesso")
    void deveAlterarNomeComSucesso() {
        var lista = new Lista("A Fazer", new Cor("#ffffff"), "Descrição da lista", 1);
        lista.alterarNome("Nova lista");
        assert(lista.getNome().equals("Nova lista"));
    }

    @Test
    @DisplayName("Deve lançar uma exceção ao alterar para um nome inválido")
    void deveLancarExcecaoAoAlterarNomeInvalido() {
        var lista = new Lista("A Fazer", new Cor("#ffffff"), "Descrição da lista", 1);
        assertThrows(IllegalArgumentException.class, () -> lista.alterarNome(null));
        assertThrows(IllegalArgumentException.class, () -> lista.alterarNome(""));
    }

    @Test
    @DisplayName("Deve lançar uma exceção ao tentar alterar para uma cor nula")
    void deveLancarExcecaoAoAlterarCorNula() {
        var lista = new Lista("A Fazer", new Cor("#ffffff"), "Descrição da lista", 1);
        assertThrows(
            IllegalArgumentException.class,
            () -> lista.alterarCor(null));
    }

    @Test
    @DisplayName("Deve alterar descrição com sucesso")
    void deveAlterarDescricaoComSucesso() {
        var lista = new Lista("A Fazer", new Cor("#ffffff"), "Descrição da lista", 1);
        lista.alterarDescricao("Nova descrição da lista");
        assert(lista.getDescricao().equals("Nova descrição da lista"));
    }

    @Test
    @DisplayName("Deve lancar uma exceção ao tentar alterar para uma descrição inválida")
    void deveLancarExcecaoAoAlterarDescricaoInvalida() {
        var lista = new Lista("A Fazer", new Cor("#ffffff"), "Descrição da lista", 1);
        assertThrows(IllegalArgumentException.class, () -> lista.alterarDescricao(null));
        assertThrows(IllegalArgumentException.class, () -> lista.alterarDescricao(""));
    }

    @Test
    @DisplayName("Deve alterar a ordem com sucesso")
    void deveAlterarOrdemComSucesso() {
        var lista = new Lista("A Fazer", new Cor("#ffffff"), "Descrição da lista", 1);
        lista.alterarOrdem(2);
        assert(lista.getOrdem() == 2);
    }

    @Test
    @DisplayName("Deve lançar uma exeção ao tentar alterar para uma ordem inválida")
    void deveLancarExcecaoAoAlterarOrdemInvalida() {
        var lista = new Lista("A Fazer", new Cor("#ffffff"), "Descrição da lista", 1);
        assertThrows(IllegalArgumentException.class, () -> lista.alterarOrdem(-1));
    }

}
