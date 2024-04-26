import java.util.List;
import java.util.ArrayList;

public class ListaDisciplinas {
  // Atributos
  private int size;
  private List<Disciplina> disciplinas;

  // Construtor
  public ListaDisciplinas() {
    this.disciplinas = new ArrayList<Disciplina>();
    this.size = 0;
  }

  // Métodos
  public void adicionarDisciplina(String nome, String curso) {
    Disciplina disciplina = new Disciplina(nome, curso);
    this.disciplinas.add(disciplina);
    this.size += 1;
  }

  public void removerDisciplina(Disciplina disciplina) {
    this.disciplinas.remove(disciplina);
    this.size -= 1;
  }

  public int getSize() {
    return this.size;
  }

  public List<Disciplina> getDisciplinas() {
    return this.disciplinas;
  }

}