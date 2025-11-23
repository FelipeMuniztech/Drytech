package view;
import dao.Conexao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicial extends JFrame {

    public TelaInicial() {
        // 1. Configurações da Janela
        setTitle("Sistema Curadoria - Início");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza na tela
        setLayout(null); // Layout manual pra ser fácil de entender

        // 2. Título ou Logo
        JLabel lblTitulo = new JLabel("Bem-vindo ao Sistema");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(50, 30, 300, 30);
        add(lblTitulo);

        // 3. Botão de Login
        JButton btnLogin = new JButton("Já tenho uma conta");
        btnLogin.setBounds(80, 100, 240, 40);
        btnLogin.setBackground(new Color(100, 162, 237)); // Um azulzinho
        btnLogin.setForeground(Color.WHITE);

        btnLogin.addActionListener(e -> {
            // AQUI É O PULO DO GATO
            LoginUsuario telaLogin = new LoginUsuario();
            telaLogin.setVisible(true);
            dispose();
        });
        add(btnLogin);

        // 4. Botão de Cadastro
        JButton btnCadastro = new JButton("Criar nova conta");
        btnCadastro.setBounds(80, 160, 240, 40);

        btnCadastro.addActionListener(e -> {
            // ROTEAMENTO PARA CADASTRO
            CadastroUsuario telaCadastro = new CadastroUsuario();
            telaCadastro.setVisible(true);
            dispose();
        });
        add(btnCadastro);
    }


    public static void main(String[] args) {
        new TelaInicial().setVisible(true);
    }
}