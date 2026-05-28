package com.er7.project_manag.domain.models.kanban;

import com.er7.project_manag.domain.shared.valueobjects.Cor;

import java.util.Objects;

public class Lista {

    private Long id;
    private String nome;
    private Cor cor;
    private String descricao;
    private int ordem;

    public Lista() {}

    public Lista(String nome, Cor cor, String descricao, int ordem) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        if (descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("Descrição não pode ser vazia.");
        if (ordem < 0)
            throw new IllegalArgumentException("A ordem não pode ser negativa.");

        this.nome = nome;
        this.cor = cor;
        this.descricao = descricao;
        this.ordem = ordem;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Cor getCor() {
        return cor;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getOrdem() {
        return ordem;
    }

    public void alterarNome(String nome) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        this.nome = nome;
    }

    public void alterarCor(Cor cor) {
        if (cor == null)
            throw new IllegalArgumentException("A cor não pode ser nula.");
        this.cor = cor;
    }

    public void alterarDescricao(String descricao) {
        if (descricao == null || descricao.isBlank())
            throw new IllegalArgumentException("Descrição não pode ser vazia.");
        this.descricao = descricao;
    }

    public void alterarOrdem(int ordem) {
        if (ordem < 0)
            throw new IllegalArgumentException("A ordem não pode ser negativa.");
        this.ordem = ordem;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lista lista = (Lista) o;
        return Objects.equals(id, lista.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
