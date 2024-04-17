/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

/**
 *
 * @author Gabriel
 */
public class CursoComConteudoExtra implements CursoDecorator {
    private Curso curso;

    public CursoComConteudoExtra(Curso curso) {
        this.curso = curso;
    }

    @Override
    public void exibirDetalhes() {
        curso.exibirDetalhes();
        adicionarConteudoExtra();
    }

    @Override
    public String getTipo() {
        return curso.getTipo();
    }

    @Override
    public void adicionarConteudoExtra() {
        System.out.println(" - Conteúdo extra adicionado");
    }
}
