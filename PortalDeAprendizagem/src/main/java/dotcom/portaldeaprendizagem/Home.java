package dotcom.portaldeaprendizagem;
import Singleton.GerenciadorCursos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class Home extends JFrame {
    private JButton btnCadastrarCurso;
    private JButton btnVerCursos;
    private JTextArea txtAreaCursos;
    private GerenciadorCursos gerenciadorCursos;

    public Home() {
        super("Portal de Aprendizagem");

        // Inicializando o gerenciador de cursos
        gerenciadorCursos = GerenciadorCursos.getInstance();

        // Configurando o layout
        setLayout(new BorderLayout());

        // Criando os componentes da interface
        btnCadastrarCurso = new JButton("Cadastrar Curso");
        btnVerCursos = new JButton("Ver Cursos");
        txtAreaCursos = new JTextArea(20, 40);
        txtAreaCursos.setEditable(false);

        // Adicionando os componentes à janela
        JPanel panelBotoes = new JPanel();
        panelBotoes.add(btnCadastrarCurso);
        panelBotoes.add(btnVerCursos);
        add(panelBotoes, BorderLayout.NORTH);
        add(new JScrollPane(txtAreaCursos), BorderLayout.CENTER);

        // Configurando ações dos botões
        btnCadastrarCurso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // Abre a janela de seleção de cursos
        SeletorDeCusoGUI seletorDeCursosGui = new SeletorDeCusoGUI();
        seletorDeCursosGui.setVisible(true);
            }
        });

        btnVerCursos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Atualiza a lista de cursos
                atualizarListaCursos();
            }
        });

        // Configurando o fechamento da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configurando o tamanho e tornando a janela visível
        pack();
        setLocationRelativeTo(null); // Centralizando a janela na tela
        setVisible(true);
    }

    // Método para abrir a janela de cadastro de curso
    private void abrirCadastroCurso() {
        // Aqui você pode abrir uma nova janela para o cadastro de curso
        // Por exemplo: CadastroCursoGUI cadastroCursoGUI = new CadastroCursoGUI();
    }

    // Método para atualizar a lista de cursos
    private void atualizarListaCursos() {
        List<String> cursosDisponiveis = gerenciadorCursos.getCursosDisponiveis();
        StringBuilder sb = new StringBuilder();
        for (String curso : cursosDisponiveis) {
            sb.append(curso).append("\n");
        }
        txtAreaCursos.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Home();
            }
        });
    }
}