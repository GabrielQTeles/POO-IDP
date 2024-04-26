class Aluno extends Pessoas {
  // Atributos
  private String curso;

  // Construtor
  public Aluno(String nome, String curso) {
    super(nome);
    this.curso = curso;
  }

  // Métodos
  public String getCurso() {
    return this.curso;
  }

}