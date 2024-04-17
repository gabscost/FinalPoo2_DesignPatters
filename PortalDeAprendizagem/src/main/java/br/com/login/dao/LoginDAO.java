/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.dao;

import Observer.LoginObserver;
import Observer.LoginSubject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gabriel
 */
public class LoginDAO {
    
     private LoginObserver loginObserver;

    public void setLoginObserver(LoginObserver observer) {
        this.loginObserver = observer;
    }
    
    public void cadastrarUsuario(String nome, String email, String senha) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "INSERT INTO login (nome, email,senha) VALUES('"+nome+"','"+email+"','"+senha+"')";
        PreparedStatement statment = conexao.prepareStatement(sql);
        statment.execute();
        conexao.close();
        
    }
    
    public void login(String email,String senha)throws SQLException{
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT email,senha FROM login WHERE email = '"+email+"' AND senha='"+senha+"'";
        PreparedStatement statment = conexao.prepareStatement(sql);
        ResultSet rs = statment.executeQuery();
        
        if(rs.next()){
            System.out.println("possui");
            // loginObserver.onLoginSuccess();
        }else{
            System.out.println("Nao possui usuario");
            // loginObserver.onLoginFailure("Credenciais inválidas");
        }
        
        
        conexao.close();
        
    }
}
   /*public void login(String email, String senha) throws SQLException {
        Connection conexao = new Conexao().getConnection();
        String sql = "SELECT email, senha FROM login WHERE email = ? AND senha = ?";
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            System.out.println("Login bem-sucedido!");
                loginObserver.onLoginSuccess();
            
        } else {
            System.out.println("Credenciais inválidas");
          
               
            
        }

        conexao.close();
    }
}*/
