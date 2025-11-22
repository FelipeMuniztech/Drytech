package model;

public class SessaoUsuario {
    // Essa variável vai guardar o usuário logado
    private static Usuario usuarioLogado;

    // para salvar o usuário quando ele logar
    public static void setUsuarioLogado(Usuario usuario) {
        usuarioLogado = usuario;
    }

    // Metodopra mostrar o nome, pegar ID, etc
    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    //pra limpar quando fizer logout
    public static void logout() {
        usuarioLogado = null;
    }
}