import java.util.List;
import java.util.ArrayList;

public class ListaCursos {
  // Atributos
  private int size;
  private List<Curso> cursos;

  // Construtor
  public ListaCursos() {
    this.cursos = new ArrayList<Curso>();
    this.size = 0;
  }

  // Métodos
  public void adicionarCurso(String nome) {
    Curso curso = new Curso(nome);
    this.cursos.add(curso);
    this.size += 1;
  }

  public void removerCurso(Curso curso) {
    this.cursos.remove(curso);
    this.size -= 1;
  }

  public int getSize() {
    return this.size;
  }

  public List<Curso> getCursos() {
    return this.cursos;
  }

}