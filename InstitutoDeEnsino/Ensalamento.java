public class Ensalamento {

  public static void ensalamento() {

    // Criando listas
    // Lista de cursos
    ListaCursos cursos = new ListaCursos();
    cursos.adicionarCurso("TI");
    cursos.adicionarCurso("ADM");

    // Lista de disciplinas
    ListaDisciplinas disciplinas = new ListaDisciplinas();
    disciplinas.adicionarDisciplina("POO", "TI");
    disciplinas.adicionarDisciplina("BI", "ADM");
    disciplinas.adicionarDisciplina("Estrutura de Dados", "TI");

    // Lista de professores
    ListaProfessores professores = new ListaProfessores();
    professores.adicionarProfessor("Mia", "POO");
    professores.adicionarProfessor("Saulo", "Estrutura de Dados");
    professores.adicionarProfessor("Paula", "BI");

    // Lista de alunos
    ListaAlunos alunos = new ListaAlunos();
    alunos.adicionarAlunos("Alfredo", "TI");
    alunos.adicionarAlunos("Amélia", "TI");
    alunos.adicionarAlunos("Bruno", "TI");
    alunos.adicionarAlunos("Capitú", "TI");
    alunos.adicionarAlunos("Debra", "TI");
    alunos.adicionarAlunos("Iracema", "TI");
    alunos.adicionarAlunos("Julieta", "TI");
    alunos.adicionarAlunos("Luciana", "TI");
    alunos.adicionarAlunos("Norberto", "TI");
    alunos.adicionarAlunos("Wendel", "TI");
    alunos.adicionarAlunos("Zoey", "TI");
    alunos.adicionarAlunos("Ana", "ADM");
    alunos.adicionarAlunos("BenADMnho", "ADM");
    alunos.adicionarAlunos("Ian", "ADM");
    alunos.adicionarAlunos("Joelmir", "ADM");
    alunos.adicionarAlunos("Luana", "ADM");
    alunos.adicionarAlunos("Majô", "ADM");
    alunos.adicionarAlunos("Maria", "ADM");
    alunos.adicionarAlunos("Paulo", "ADM");
    alunos.adicionarAlunos("Romeu", "ADM");

    // Criar turmas
    ListaTurmas turmas = new ListaTurmas();

    // Criar turmas e adicionar uma disciplina a cada uma delas
    for (Disciplina disciplina : disciplinas.getDisciplinas()) {
      turmas.adicionarTurma();
      turmas.getTurmas().get(turmas.getSize() - 1).adicionarDisciplina(disciplina);
    }

    // Adicionar o respectivo professor a cada turma
    for (Professor professor : professores.getProfessores()) {
      for (Turma turma : turmas.getTurmas()) {
        if (turma.getDisciplina().getNome().equals(professor.getDisciplina())) {
          turma.adicionarProfessor(professor);
          break;
        }
      }
    }

    // Adicionar cada aluno a sua respectiva turma
    for (Aluno aluno : alunos.getAlunos()) {
      for (Turma turma : turmas.getTurmas()) {
        if (turma.getDisciplina().getCurso().equals(aluno.getCurso())) {
          turma.adicionarAlunos(aluno);
        }
      }
    }

    // Mostra resultado final
    System.out.println("=============================================");
    for (Turma turma : turmas.getTurmas()) {
      System.out.println();
      turma.printTurma();
      System.out.println("=============================================");
    }

  }

}