import java.util.List;
import java.util.ArrayList;

public class ListaTurmas {
  // Atributos
  private int size;
  private List<Turma> turmas;

  // Construtor
  public ListaTurmas() {
    this.turmas = new ArrayList<Turma>();
    this.size = 0;
  }

  // Métodos
  public void adicionarTurma() {
    Turma turma = new Turma();
    this.turmas.add(turma);
    this.size += 1;
  }

  public void removerTurma(Turma turma) {
    this.turmas.remove(turma);
    this.size -= 1;
  }

  public int getSize() {
    return this.size;
  }

  public List<Turma> getTurmas() {
    return this.turmas;
  }

}