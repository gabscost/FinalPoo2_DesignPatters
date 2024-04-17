package dotcom.portaldeaprendizagem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Singleton.GerenciadorCursos;

public class SeletorDeCusoGUI extends JFrame {
    private JCheckBox chkPython;
    private JCheckBox chkJava;
    private JLabel lblInfoPython;
    private JLabel lblInfoJava;
    private JButton btnPagar; // Novo botão de pagamento
    private GerenciadorCursos gerenciadorCursos;

    public SeletorDeCusoGUI() {
        super("Seletor de Cursos");
        
        // Inicializando o gerenciador de cursos
        gerenciadorCursos = GerenciadorCursos.getInstance();
        gerenciadorCursos.adicionarCursoComConteudoExtra("Java");
        
        
        // Configurando o layout
        setLayout(new GridLayout(4, 2)); // Aumentado para incluir o botão de pagamento
        
        // Criando os componentes
        chkPython = new JCheckBox("Python");
        chkJava = new JCheckBox("Java");
        lblInfoPython = new JLabel("Curso de Python: Este curso aborda os fundamentos da linguagem Python.");
        lblInfoPython.setForeground(Color.GRAY);
        lblInfoJava = new JLabel("Curso de Java: Este curso explora os conceitos básicos e avançados de programação em Java.");
        lblInfoJava.setForeground(Color.GRAY);
        btnPagar = new JButton("Pagar"); // Botão de pagamento
        
        // Adicionando os componentes à janela
        add(chkPython);
        add(lblInfoPython);
        add(chkJava);
        add(lblInfoJava);
        add(new JLabel()); // Espaçamento para alinhar com a coluna dos labels
        add(btnPagar); // Adicionando o botão de pagamento
        
        // Configurando os listeners para os checkboxes
        chkPython.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chkPython.isSelected()) {
                    lblInfoPython.setForeground(Color.BLACK);
                    gerenciadorCursos.adicionarCurso("Python");
                } else {
                    lblInfoPython.setForeground(Color.GRAY);
                    gerenciadorCursos.removerCurso("Python");
                }
            }
        });
        
        chkJava.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (chkJava.isSelected()) {
                    lblInfoJava.setForeground(Color.BLACK);
                    gerenciadorCursos.adicionarCurso("Java");
                   
                } else {
                    lblInfoJava.setForeground(Color.GRAY);
                    gerenciadorCursos.removerCurso("Java");
                }
            }
        });
        
        // Configurando o listener para o botão de pagamento
        btnPagar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Chamar a tela MetodoPagamento
                MetodoPagamento metodoPagamento = new MetodoPagamento();
                metodoPagamento.setVisible(true);
                setVisible(false);
            }
        });
        
        // Configurando o fechamento da janela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Configurando o tamanho e tornando a janela visível
        setSize(400, 250); // Ajustando o tamanho da janela
        setLocationRelativeTo(null); // Centralizando a janela na tela
        setVisible(true);
    }
}

