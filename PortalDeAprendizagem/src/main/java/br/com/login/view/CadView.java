package br.com.login.view;

import br.com.login.controller.LoginController;
import java.sql.SQLException;
import javax.swing.*;

public class CadView extends javax.swing.JFrame {
    
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelNome; // Adicionando o JLabel para o nome
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome; // Adicionando o JTextField para o nome
    private javax.swing.JPasswordField jPasswordFieldSenha;

    public CadView() {
        initComponents();
    }

    private void initComponents() {
        jLabelEmail = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabelSenha = new javax.swing.JLabel();
        jPasswordFieldSenha = new javax.swing.JPasswordField();
        jButtonCadastrar = new javax.swing.JButton();
        jLabelNome = new javax.swing.JLabel(); // Inicializando o JLabel para o nome
        jTextFieldNome = new javax.swing.JTextField(); // Inicializando o JTextField para o nome

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelEmail.setText("Email:");

        jLabelSenha.setText("Senha:");

        jLabelNome.setText("Nome:"); // Definindo o texto do JLabel para o nome

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
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
                        .addComponent(jLabelNome) // Adicionando o JLabel para o nome
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonCadastrar))
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
                    .addComponent(jLabelNome) // Adicionando o JLabel para o nome
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonCadastrar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }
    public String getEmail() {
        return jTextFieldEmail.getText();
    }

    // Setter para o email
    public void setEmail(String email) {
        jTextFieldEmail.setText(email);
    }

    // Getter para a senha
    public String getSenha() {
        return new String(jPasswordFieldSenha.getPassword());
    }

    // Setter para a senha
    public void setSenha(String senha) {
        jPasswordFieldSenha.setText(senha);
    }

    // Getter para o nome
    public String getNome() {
        return jTextFieldNome.getText();
    }

    // Setter para o nome
    public void setNome(String nome) {
        jTextFieldNome.setText(nome);
    }

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {
        String email = getEmail(); // Usando o getter para obter o email
        String senha = getSenha(); // Usando o getter para obter a senha
        String nome = getNome(); // Usando o getter para obter o nome
           
        if(email.matches("") || senha.matches("") || nome.matches("")){
             JOptionPane.showMessageDialog(this, "Preencha todos os campos");
       }else{
             LoginController cadastro = new LoginController();
            try {
        cadastro.cadasrtoUsuario(this); // Corrigindo o nome do método para "cadastroUsuario"
        JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
        this.setVisible(false);
    } catch (SQLException e) {
        // Tratamento da exceção SQLException
        JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário: " + e.getMessage());
        
    }
            
           this.setVisible(false);
        }   
        
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadView().setVisible(true);
            }
        });
    }
}
