package com.er7.project_manag.domain.models.checklist;

import com.er7.project_manag.domain.exception.ChecklistNaoEncontradoException;
import com.er7.project_manag.domain.exception.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChecklistTest {

    @Test
    @DisplayName("Deve alterar nome do checklist com sucesso para nome válido")
    void deveAlterarNomeDoChecklistComSucesso() {
        var checklist = new Checklist(1L, "Meu primeiro checklist");
        checklist.alterarNome("Meu segundo checklist");
        assertEquals("Meu segundo checklist", checklist.getNome());
    }

    @Test
    @DisplayName("Deve lançar uma exceção para ao alterar nome do checklist com nome inválido")
    void deveLancarExcecaoAoAlterarNomeComNomeInvalido() {
        var checklist = new Checklist(1L, "Meu primeiro checklist");
        Assertions.assertThrows(IllegalArgumentException.class, () -> checklist.alterarNome(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> checklist.alterarNome(""));
    }

    @Test
    @DisplayName("Deve incluir um item específico no checklist")
    void deveIncluirItemNoChecklist() {
        var checklist = new Checklist(1L, "Meu checklist");
        checklist.adicionarItem(new ChecklistItem(1L, "Comprar carvão"));
        assertEquals(1, checklist.getItens().size());
    }

    @Test
    @DisplayName("Deve concluir item específico com sucesso")
    void deveConcluirItemEspecificoComSucesso() {
        var checklist = new Checklist(1L, "Minha checklist");
        checklist.adicionarItem(new ChecklistItem(1L, "Comprar carvão"));
        checklist.concluirItem(1L);
        assertEquals(1, checklist.getItens().size());
        assertTrue(checklist.getItens().getFirst().isConcluido());
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar alterar o nome de item se o checklist já estiver 100% concluído.")
    void deveBloquearAlteracaoDeItemSeChecklistEstiverConcluido() {
        var checklist = new Checklist(1L, "Meu checklist");
        checklist.adicionarItem(new ChecklistItem(10L, "Comprar carvão"));
        checklist.concluirItem(10L);

        assertThrows(DomainException.class, () -> checklist.alterarNomeDoItem(10L, "Novo nome"));
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar operar um item que não existe no checklist")
    void deveLancarExcecaoSeItemNaoExistir() {
        var checklist = new Checklist(1L, "Meu checklist");
        assertThrows(
            ChecklistNaoEncontradoException.class,
                () -> checklist.concluirItem(999L));
    }

    @Test
    @DisplayName("A lista de itens retornada pelo getter deve ser imutável para o mundo externo")
    void deveGarantirImutabilidadeDaListaDeItens() {
        var checklist = new Checklist(1L, "Meu checklist");
        var itens = checklist.getItens();

        assertThrows(
            UnsupportedOperationException.class,
            () -> itens.add(new ChecklistItem(1L, "Novo item")));
    }
}
