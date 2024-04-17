/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

/**
 *
 * @author Gabriel
 */
public abstract class MinhaCurso {
    public abstract Curso criarCurso(String tipo);

    public Curso criarCursoComConteudoExtra(String tipo) {
        Curso curso = criarCurso(tipo);
        return new CursoComConteudoExtra(curso);
    }
}
