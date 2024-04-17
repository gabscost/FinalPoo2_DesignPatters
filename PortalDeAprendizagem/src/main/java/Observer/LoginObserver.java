/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

/**
 */
 import java.sql.SQLException;

public interface LoginObserver {
    void onLoginSuccess() throws SQLException;
    void onLoginFailure(String errorMessage);
}

