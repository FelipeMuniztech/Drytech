package view;

import dao.RecursoDAO;
import model.Usuario;
import model.Recurso;
import javax.swing.*;
import java.awt.*;
import java.util.List;

import model.SessaoUsuario;

public class FeedFrame extends JFrame {

    private JPanel panelConteudoFeed;
    public FeedFrame() {
        // Configurações da janela
        setTitle("Feed de Posts");
        setSize(800, 600);
        setLayout(null); // Ou o layout que você tiver usando
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Usuario UsuarioEncontrado = SessaoUsuario.getUsuarioLogado();
        JLabel lblBemVindo = new JLabel();
        lblBemVindo.setBounds(20, 20, 300, 30);
        lblBemVindo.setFont(new Font("Arial", Font.BOLD, 16));

        if (UsuarioEncontrado != null) {
            lblBemVindo.setText("Fala, " + UsuarioEncontrado.getUsername() + "! (" + UsuarioEncontrado.getTipo() + ")");
        } else {
            lblBemVindo.setText("Usuário Desconhecido");
        }
        lblBemVindo.setBounds(20, 20, 500, 30);
        lblBemVindo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblBemVindo);

        panelConteudoFeed = new JPanel();
        panelConteudoFeed.setLayout(new BoxLayout(panelConteudoFeed, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(panelConteudoFeed);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBounds(20, 60, 740, 480);

        add(scrollPane);

        carregarPosts();
    }
        // Posiciona na tela (exemplo)





        private void carregarPosts(){
            RecursoDAO dao = new RecursoDAO();
            List<Recurso> post = dao.listarTodos();

                panelConteudoFeed.removeAll();

            for (Recurso recurso : post) {
                JPanel card = new JPanel();
                card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
                card.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder(recurso.getTitulo()),
                        BorderFactory.createEmptyBorder(10,10,10,10)
                ));
                card.setBackground(Color.WHITE);
                card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150)); // Altura fixa, largura estica

                // Adiciona a descrição
                JTextArea txtDesc = new JTextArea(recurso.getDescricao());
                txtDesc.setWrapStyleWord(true);
                txtDesc.setLineWrap(true);
                txtDesc.setEditable(false); // Só leitura
                txtDesc.setBackground(null); // Cor do fundo transparente

                // Adiciona a URL (simples)
                JLabel lblLink = new JLabel("Link: " + recurso.getUrl());
                lblLink.setForeground(Color.BLUE);

                JLabel lblAutor = new JLabel("Autor: " + recurso.getAutor());
                lblAutor.setForeground(Color.BLACK);

                // Monta o card
                card.add(txtDesc);
                card.add(Box.createRigidArea(new Dimension(0, 10))); // Espacinho
                card.add(lblLink);
                card.add(lblAutor);

                // --- ADICIONA O CARD NO FEED ---
                panelConteudoFeed.add(card);
                // Espaço entre um post e outro
                panelConteudoFeed.add(Box.createRigidArea(new Dimension(0, 15)));

                // Atualiza a tela (Obrigatório no Swing depois de adicionar coisas dinamicamente)
                panelConteudoFeed.revalidate();
                panelConteudoFeed.repaint();
            }
            }


        }
/*
        //--- NA HORA DE CRIAR UM POST ---
        // 1. Cria o campo onde o usuário vai digitar o título
        JTextField txtTitulo = new JTextField(20); // 20 é a largura visual
// Se tiver descrição/conteúdo, cria um JTextArea também

        JButton btnPostar = new JButton("Postar");

        btnPostar.addActionListener(e -> {
            // A. VALIDAÇÃO: Não deixa postar vazio
            String tituloDigitado = txtTitulo.getText();

            if (tituloDigitado.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Escreve alguma coisa aí, pai!");
                return; // Para o código aqui
            }

            try {
                // B. MONTA O OBJETO
                // Passa o ID do usuário da Sessão
                Recurso novoPost = new Recurso(UsuarioEncontrado.getId());
                novoPost.setUsuarioId(SessaoUsuario.getUsuarioLogado().getId());

                // Passa o texto que veio da caixinha
                novoPost.setTitulo(tituloDigitado);
                // novoPost.setConteudo(txtConteudo.getText()); // Se tiver conteúdo

                // C. MANDA PRO BANCO
                RecursoDAO recDAO = new RecursoDAO();
                recDAO.inserir(novoPost);

                // D. SUCESSO E LIMPEZA
                JOptionPane.showMessageDialog(null, "Postado com sucesso!");
                txtTitulo.setText(""); // Limpa o campo pro próximo post

                // Dica: Aqui você chamaria um método atualizarFeed() pra o post aparecer na hora

            } catch (Exception ex) {
                // E. TRATAMENTO DE ERRO
                JOptionPane.showMessageDialog(null, "Erro ao postar: " + ex.getMessage());
                ex.printStackTrace(); // Mostra o erro no console pra você corrigir
            }
        });

// Adiciona os componentes na tela
        add(new JLabel("Título do Post:"));
        add(txtTitulo);
        add(btnPostar);
        */



