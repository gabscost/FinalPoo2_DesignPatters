/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Gabriel
 */
public class LoginSubject {
    private List<LoginObserver> observers = new ArrayList<>();

    public void addObserver(LoginObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LoginObserver observer) {
        observers.remove(observer);
    }

    public void notifyLoginSuccess() throws SQLException {
        for (LoginObserver observer : observers) {
            observer.onLoginSuccess();
        }
    }

    public void notifyLoginFailure(String errorMessage) {
        for (LoginObserver observer : observers) {
            observer.onLoginFailure(errorMessage);
        }
    }
}
