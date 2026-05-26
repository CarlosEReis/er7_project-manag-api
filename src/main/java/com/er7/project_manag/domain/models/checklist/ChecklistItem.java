package com.er7.project_manag.domain.models.checklist;

import java.util.Objects;

public class ChecklistItem {

    private Long id;
    private String nome;
    private ChecklistItemStatus status = ChecklistItemStatus.PENDENTE;

    protected ChecklistItem() {}

    public ChecklistItem(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public ChecklistItemStatus getStatus() {
        return status;
    }

    void marcarComoConcluido() { this.status = ChecklistItemStatus.CONCLUIDO;}
    void marcarComoPendente() { this.status = ChecklistItemStatus.PENDENTE;}
    boolean isConcluido() { return ChecklistItemStatus.CONCLUIDO.equals(status);}
    void alterarNome(String novoNome) {
        if (novoNome == null || novoNome.isBlank())
            throw new IllegalArgumentException("O nome do item não pode ser vazio.");

        this.nome = novoNome;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ChecklistItem that = (ChecklistItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
