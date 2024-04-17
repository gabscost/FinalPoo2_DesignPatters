/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Factory;


public class CursoPython implements Curso {
    @Override
    public void exibirDetalhes() {
        System.out.println("Curso de Python API");
    }
     @Override
    public String getTipo() {
        return "Python";
    }
}
