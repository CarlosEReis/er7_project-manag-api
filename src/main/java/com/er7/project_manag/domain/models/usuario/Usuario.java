package com.er7.project_manag.domain.models.usuario;

public class Usuario {

    private Long id;
    private String nome;
    private Email email;
    private Senha senha;
    private String foto;

    public Usuario() {}

    public Usuario(String nome, Email email, Senha senha) {
        if (nome == null || nome.isBlank())
            throw new IllegalArgumentException("O nome do usuário não pode ser vazio.");
        if (email == null)
            throw new IllegalArgumentException("O e-mail do usuário não pode ser vazio.");
        if (senha == null)
            throw new IllegalArgumentException("A senha do usuário não pode ser vazia.");

        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.email();
    }

    public String getSenha() {
        return senha.valor();
    }

    public String getFoto() {
        return foto;
    }

    public void alterarNome(String novoNome) {
        if (novoNome == null || novoNome.isBlank())
            throw new IllegalArgumentException("O novo nome não pode ser vazio.");
        this.nome = novoNome;
    }

    public void alterarFoto(String novaFoto) {
        if (novaFoto == null || novaFoto.isBlank())
            throw new IllegalArgumentException("Nova foto não pode ser vazia.");
        this.foto = novaFoto;
    }

    public void removerFoto() {
        this.foto = null;
    }

    public void alterarSenha(Senha novaSenha) {
        if (novaSenha == null)
            throw new IllegalArgumentException("A senha não pode ser nula.");
        this.senha = novaSenha;
    }
}
