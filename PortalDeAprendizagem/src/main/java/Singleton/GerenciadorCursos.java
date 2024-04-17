/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singleton;

/**
 *
 * @author Gabriel
 */
import Factory.Curso;
import Factory.CursoFactory;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorCursos {
    private static GerenciadorCursos instancia;
    private List<Curso> listaCursos;
    private CursoFactory factory; // Adicionando a referência para a factory
    
    public void adicionarCursoComConteudoExtra(String tipo) {
        // Criar o curso com conteúdo extra usando a factory
        Curso cursoComConteudoExtra = factory.criarCursoComConteudoExtra(tipo);
        if (cursoComConteudoExtra != null) {
            listaCursos.add(cursoComConteudoExtra);
            System.out.println("Curso " + tipo + " com conteúdo extra adicionado com sucesso.");
        } else {
            System.out.println("Tipo de curso inválido.");
        }
    }

    private GerenciadorCursos() {
        // Construtor privado para evitar instanciação direta
        listaCursos = new ArrayList<>();
        factory = new CursoFactory(); // Inicializando a factory
    }

    public static GerenciadorCursos getInstance() {
        if (instancia == null) {
            instancia = new GerenciadorCursos();
        }
        return instancia;
    }

    public void adicionarCurso(String tipo) {
        // Criar o curso usando a factory
        Curso curso = factory.criarCurso(tipo);
        if (curso != null) {
            listaCursos.add(curso);
            System.out.println("Curso " + tipo + " adicionado com sucesso.");
        } else {
            System.out.println("Tipo de curso inválido.");
        }
    }

    public void removerCurso(String tipo) {
        // Remover o curso da lista (supondo que você possa identificar o curso pelo tipo)
        listaCursos.removeIf(curso -> curso.getTipo().equalsIgnoreCase(tipo));
        System.out.println("Curso " + tipo + " removido com sucesso.");
    }
    public List<String> getCursosDisponiveis() {
    List<String> tiposCursos = new ArrayList<>();
    for (Curso curso : listaCursos) {
        tiposCursos.add(curso.getTipo());
    }
    return tiposCursos;
}


   
}

