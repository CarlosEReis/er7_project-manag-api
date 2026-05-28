package com.er7.project_manag.domain.models.usuario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.convert.DataSizeUnit;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsuarioTest {

    @Test
    @DisplayName("Deve criar um usuário com sucesso")
    void deveCriarUsuarioComSucesso() {
        var usuario = new Usuario("Carlos", new Email("carlos@gmail.com"), new Senha("3$#$#DSd1454"));
        assert(usuario.getNome().equals("Carlos"));
        assert(usuario.getEmail().equals("carlos@gmail.com"));
        assert(usuario.getSenha().equals("3$#$#DSd1454"));
    }

    @Test
    @DisplayName("Deve alterar nome com sucesso")
    void deveAlterarNomeComSucesso() {
        var usuario = new Usuario("Carlos", new Email("carlos@gmail.com"), new Senha("3$#$#DSd1454"));
        usuario.alterarNome("Jose");
        assert(usuario.getNome().equals("Jose"));
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar alterar nome inválido")
    void deveLancarExcecaoAoAlterarNomeInvalido() {
        var usuario = new Usuario("Carlos", new Email("carlos@gmail.com"), new Senha("3$#$#DSd1454"));
        assertThrows(IllegalArgumentException.class, () -> usuario.alterarNome(null));
        assertThrows(IllegalArgumentException.class, () -> usuario.alterarNome("")) ;
    }

    @Test
    @DisplayName("Deve alterar foto com sucesso")
    void deveAlterarFotoComSucesso() {
        var usuario = new Usuario("Carlos", new Email("carlos@gmail.com"), new Senha("3$#$#DSd1454"));
        usuario.alterarFoto("foto.jpg");
        assert(usuario.getFoto().equals("foto.jpg"));
    }

    @Test
    @DisplayName("Deve lançar exceção ao tentar alterar foto inválida")
    void deveLancarExcecaoAoAlterarFotoInvalida() {
        var usuario = new Usuario("Carlos", new Email("carlos@gmail.com"), new Senha("3$#$#DSd1454"));
        assertThrows(IllegalArgumentException.class, () -> usuario.alterarFoto(null));
        assertThrows(IllegalArgumentException.class, () -> usuario.alterarFoto(""));
    }

    @Test
    @DisplayName("Deve remover foto com sucesso")
    void deveRemoverFotoComSucesso() {
        var usuario = new Usuario("Carlos", new Email("carlos@gmail.com"), new Senha("3$#$#DSd1454"));
        usuario.alterarFoto("foto.jpg");
        usuario.removerFoto();
        assert(usuario.getFoto() == null);
    }

    @Test
    @DisplayName("Deve deve alterar a senha com sucesso")
    void deveAlterarASenhaComSucesso() {
        var usuario = new Usuario("Carlos", new Email("carlos@gmail.com"), new Senha("3$#$#DSd1454"));
        usuario.alterarSenha(new Senha("3$#$#DSd5555"));
        assert(usuario.getSenha().equals("3$#$#DSd5555"));
    }

    @Test
    @DisplayName("Deve lançar uma exceção ao tentar altera para senha nula")
    void deveLancarExcecaoAoAlterarSenhaNula() {
        var usuario = new Usuario("Carlos", new Email("carlos@gmail.com"), new Senha("3$#$#DSd1454"));
        assertThrows(IllegalArgumentException.class, () -> usuario.alterarSenha(null));
    }

}
