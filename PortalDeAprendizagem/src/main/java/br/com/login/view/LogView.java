package br.com.login.view;

import br.com.login.controller.LoginController;
import dotcom.portaldeaprendizagem.Home;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LogView extends javax.swing.JFrame {
    
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonCadastro; // Adicionando o botão de cadastro
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JPasswordField jPasswordFieldSenha;

    public LogView() {
        initComponents();
    }

    private void initComponents() {
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonEntrar = new javax.swing.JButton();
        jButtonCadastro = new javax.swing.JButton(); // Inicializando o botão de cadastro

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelEmail.setText("Email:");

        jLabelSenha.setText("Senha:");

        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jButtonCadastro.setText("Cadastrar");
        jButtonCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonEntrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCadastro))) // Adicionando o botão de cadastro
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEmail)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSenha)
                    .addComponent(jPasswordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEntrar)
                    .addComponent(jButtonCadastro)) // Adicionando o botão de cadastro
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    public JTextField getjTextFieldEmail() {
        return jTextFieldEmail;
    }

    public void setjTextFieldEmail(JTextField jTextFieldEmail) {
        this.jTextFieldEmail = jTextFieldEmail;
    }

    public JPasswordField getjPasswordFieldSenha() {
        return jPasswordFieldSenha;
    }

    public void setjPasswordFieldSenha(JPasswordField jPasswordFieldSenha) {
        this.jPasswordFieldSenha = jPasswordFieldSenha;
    }


    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {
      String email = getjTextFieldEmail().getText();
    String senha = new String(getjPasswordFieldSenha().getPassword());
    
       
        
        LoginController login = new LoginController();
          try {
        login.loginUsuario(this);
        
        this.setVisible(false);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Criar e exibir a tela Home
                Home home = new Home();
                home.setVisible(true);
            }
        });
        
        
    } catch (SQLException e) {
       
        JOptionPane.showMessageDialog(this, "Erro ao logar usuário: " + e.getMessage());
    }
       
        JOptionPane.showMessageDialog(this, "Login bem-sucedido!");
        
    }

    private void jButtonCadastroActionPerformed(java.awt.event.ActionEvent evt) {
        // Criar uma instância da tela de cadastro e torná-la visível
        CadView cadastro = new CadView();
        cadastro.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogView().setVisible(true);
                
                
            }
        });
    }
    
}
