package br.com.drytech;
import dao.Conexao;
import view.LoginUsuario;

import javax.swing.*;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Conexao.iniciarBanco();
        System.out.println("Iniciando Banco...");

        try (Connection conn = Conexao.getConnection()) {
            SwingUtilities.invokeLater(() -> new LoginUsuario(conn).setVisible(true));
        } catch (Exception e) {
            System.out.println("ERRO:" + e.getMessage());
        }

    }
}

