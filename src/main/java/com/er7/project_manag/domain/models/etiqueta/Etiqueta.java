package com.er7.project_manag.domain.models.etiqueta;

import com.er7.project_manag.domain.shared.valueobjects.Cor;

public class Etiqueta {

    private Long id;
    private String nome;
    private Cor cor;
    private boolean ativo = true;

    public Etiqueta() {}

    public Etiqueta(String nome, Cor cor) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("O nome da etiqueta é obrigatório e não pode ser vazio.");
        if (cor == null)
            throw new IllegalArgumentException("A cor da etiqueta não pode ser nula.");

        this.nome = nome;
        this.cor = cor;
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

    public void alterarNome(String novoNome) {
        if (novoNome == null || novoNome.isBlank())
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        if (this.isInativa())
            throw new IllegalArgumentException("Não é possível alterar o nome de uma etiqueta inativa.");
        this.nome = novoNome;
    }

    public void alterarCor(Cor novaCor) {
        if (novaCor == null)
            throw new IllegalArgumentException("A cor da etiqueta não pode ser nula.");
        if (this.isInativa())
            throw new IllegalArgumentException("Não é possível alterar a cor de uma etiqueta inativa.");
        this.cor = novaCor;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public boolean isInativa() {
        return !isAtivo();
    }

    public void desativar() {
        this.ativo = false;
    }

    public void ativar() {
        this.ativo = true;
    }

}
