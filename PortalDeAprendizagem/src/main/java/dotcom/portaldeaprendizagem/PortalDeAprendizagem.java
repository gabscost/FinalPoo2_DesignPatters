package dotcom.portaldeaprendizagem;

import Singleton.GerenciadorCursos;
import br.com.login.view.LogView;
import javax.swing.SwingUtilities;


public class PortalDeAprendizagem {

    public static void main(String[] args) {
          LogView loginView = new LogView();
        
        // Tornar a tela de login visível
        loginView.setVisible(true);
         
        // 1. Usando o Singleton
        /*GerenciadorCursos gerenciadorCursos = GerenciadorCursos.getInstance();
        
        // 2. Usando a Factory
        gerenciadorCursos.adicionarCurso("Java");
        gerenciadorCursos.adicionarCurso("Python");*/
        
        
        /* SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Criar e exibir a tela Home
                Home home = new Home();
                home.setVisible(true);
            }
        });*/
     
    }
}
