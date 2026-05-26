package com.er7.project_manag.domain.models.checklist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChecklistItemTest {

    @Test
    @DisplayName("Deve iniciar o item com o status PENDENTE por padrão")
    void deveIniciarComStatusPendente() {
        var item = new ChecklistItem(1L, "Fazer compras");
        assertEquals(ChecklistItemStatus.PENDENTE, item.getStatus());
        assertFalse(item.isConcluido());
    }

    @Test
    @DisplayName("Deve alterar o nome com sucesso")
    void deveAlterarNomeDoItem() {
        var item = new ChecklistItem(1L, "Nome do item antigo");
        item.alterarNome("Novo nome do item");
        assertEquals("Novo nome do item", item.getNome());
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar alterar o nome do item para nulo ou em branco")
    void deveLancarExcecaoParaNomeInvalido() {
        var item = new ChecklistItem(1L, "Nome do item valido");
        assertThrows(IllegalArgumentException.class, () -> item.alterarNome(null));
        assertThrows(IllegalArgumentException.class, () -> item.alterarNome(""));
    }

    @Test
    @DisplayName("Deve alterar o status do item para CONCLUIDO")
    void deveAlterarStatusDoItemParaConcluido(){
        var item = new ChecklistItem(1L, "Fazer compras");
        item.marcarComoConcluido();
        assertTrue(item.isConcluido());
    }

    @Test
    void deveAlterarStatusDoItemParaPendente(){
        var item = new ChecklistItem(1L, "Fazer compras");
        item.marcarComoPendente();
        assertEquals(ChecklistItemStatus.PENDENTE, item.getStatus());
    }
}
