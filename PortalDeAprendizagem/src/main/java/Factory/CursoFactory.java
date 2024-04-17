/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;

/**
 *
 * @author Gabriel
 */
public class CursoFactory extends MinhaCurso {
    @Override
    public Curso criarCurso(String tipo) {
        if (tipo.equalsIgnoreCase("Java")) {
            return new CursoComConteudoExtra(new CursoJava());
        } else if (tipo.equalsIgnoreCase("Python")) {
            return new CursoComConteudoExtra(new CursoPython());
        }
        return null;
    }
}