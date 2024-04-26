public class Disciplina {
  // Atributos
  private String nome;
  private String curso;

  // Construtor
  public Disciplina(String nome, String curso) {
    this.nome = nome;
    this.curso = curso;
  }

  // Métodos
  public String getNome() {
    return this.nome;
  }

  public String getCurso() {
    return this.curso;
  }

}