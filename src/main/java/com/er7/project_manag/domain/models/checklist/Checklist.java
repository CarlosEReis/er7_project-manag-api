package com.er7.project_manag.domain.models.checklist;

import com.er7.project_manag.domain.exception.ChecklistNaoEncontradoException;
import com.er7.project_manag.domain.exception.DomainException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Checklist {

    private Long id;
    private String nome;
    private List<ChecklistItem> itens = new ArrayList<>();

    protected Checklist() {}

    public Checklist(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void alterarNome(String novoNome) {
        if (novoNome == null || novoNome.isBlank())
            throw new IllegalArgumentException("O nome do checklist não pode ser vazio.");

        this.nome = novoNome;
    }

    public void adicionarItem(ChecklistItem item) {
        this.itens.add(item);
    }

    public void concluirItem(Long id) {
        buscarItemOuFalhar(id).marcarComoConcluido();
    }

    public void marcarItemComoPendente(Long id) {
        buscarItemOuFalhar(id).marcarComoPendente();
    }

    public void removerItem(ChecklistItem item) {
        this.itens.remove(item);
    }

    public void alterarNomeDoItem(Long itemId, String novoNome) {
        var item = buscarItemOuFalhar(itemId);
        if(this.isConcluido())
            throw new DomainException("Não pode editar itens de um checklist concluído.");

        item.alterarNome(novoNome);
    }

    public List<ChecklistItem> getItens() {
        return Collections.unmodifiableList(itens);
    }

    private ChecklistItem buscarItemOuFalhar(Long id) {
        return this.itens
            .stream()
                .filter(item -> item.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ChecklistNaoEncontradoException(id));
    }

    private boolean isConcluido() {
        if (this.itens.isEmpty()) return false;
        return this.itens.stream().allMatch(ChecklistItem::isConcluido);
    }

}
