import java.util.List;
import java.util.ArrayList;

public class ListaAlunos {
  // Atributos
  private int size;
  private List<Aluno> alunos;

  // Construtor
  public ListaAlunos() {
    this.alunos = new ArrayList<Aluno>();
    this.size = 0;
  }

  // Métodos
  public void adicionarAlunos(String nome, String curso) {
    Aluno aluno = new Aluno(nome, curso);
    this.alunos.add(aluno);
    this.size += 1;
  }

  public void adicionarObjetoAluno(Aluno aluno) {
    this.alunos.add(aluno);
    this.size += 1;
  }

  public void removerAlunos(Aluno aluno) {
    this.alunos.remove(aluno);
    this.size -= 1;
  }

  public int getSize() {
    return this.size;
  }

  public List<Aluno> getAlunos() {
    return this.alunos;
  }

}