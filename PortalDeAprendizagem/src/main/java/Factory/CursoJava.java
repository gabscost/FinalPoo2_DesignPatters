package Factory;

public class CursoJava implements Curso {
    @Override
    public void exibirDetalhes() {
        System.out.println("Curso de JAVA Spring");
    }

    @Override
    public String getTipo() {
        return "Java";
    }
}
