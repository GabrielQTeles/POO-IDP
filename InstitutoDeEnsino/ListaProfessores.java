import java.util.List;
import java.util.ArrayList;

public class ListaProfessores {
  // Atributos
  private int size;
  private List<Professor> professores;

  // Construtor
  public ListaProfessores() {
    this.professores = new ArrayList<Professor>();
    this.size = 0;
  }

  // Métodos
  public void adicionarProfessor(String nome, String disciplina) {
    Professor professor = new Professor(nome, disciplina);
    this.professores.add(professor);
    this.size += 1;
  }

  public void removerProfessor(Professor professor) {
    this.professores.remove(professor);
    this.size -= 1;
  }

  public int getSize() {
    return this.size;
  }

  public List<Professor> getProfessores() {
    return this.professores;
  }

}