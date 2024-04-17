/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.login.controller;

import br.com.login.dao.Conexao;
import br.com.login.dao.LoginDAO;
import br.com.login.view.CadView;
import br.com.login.view.LogView;
import java.sql.Connection;
import java.sql.SQLException;


public class LoginController {
    
    public void cadasrtoUsuario(CadView view) throws SQLException{
       Connection conexao = new Conexao().getConnection();
       LoginDAO cadastro = new LoginDAO();
       
       cadastro.cadastrarUsuario(view.getNome(), view.getEmail(), view.getSenha());
       
    }
    
    
    
     public void loginUsuario(LogView v) throws SQLException{
       Connection conexao = new Conexao().getConnection();
       LoginDAO login = new LoginDAO();
       
       login.login(v.getjTextFieldEmail().getText(),v.getjPasswordFieldSenha().getText());
       
    }
}
