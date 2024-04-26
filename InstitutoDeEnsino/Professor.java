class Professor extends Pessoas {
  // Atributos
  private String disciplina;

  // Construtor
  public Professor(String nome, String disciplina) {
    super(nome);
    this.disciplina = disciplina;
  }

  // Métodos
  public String getDisciplina() {
    return this.disciplina;
  }

}