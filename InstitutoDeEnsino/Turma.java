public class Turma {
  // Atributos
  private Professor professor;
  private ListaAlunos alunos;
  private Disciplina disciplina;

  // Construtor
  public Turma() {
    this.alunos = new ListaAlunos();
  }

  // Métodos
  public void adicionarProfessor(Professor professor) {
    this.professor = professor;
  }

  public void adicionarAlunos(Aluno aluno) {
    this.alunos.adicionarObjetoAluno(aluno);
  }

  public void adicionarDisciplina(Disciplina disciplina) {
    this.disciplina = disciplina;
  }

  public Professor getProfessor() {
    return this.professor;
  }

  public ListaAlunos getAlunos() {
    return this.alunos;
  }

  public Disciplina getDisciplina() {
    return this.disciplina;
  }

  public void printTurma() {
    // Mostrar disciplina
    System.out.println("Disciplina: ");
    System.out.println("    " + this.disciplina.getNome());
    System.out.println();

    // Mostrar professor
    System.out.println("Professor: ");
    System.out.println("    " + this.professor.getNome());
    System.out.println();

    // Mostrar alunos
    System.out.println("Alunos: ");
    for (Aluno a : this.alunos.getAlunos()) {
      System.out.println("    " + a.getNome());
    }
    System.out.println();
  }

}