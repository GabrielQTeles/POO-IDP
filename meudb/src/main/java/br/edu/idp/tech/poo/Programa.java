package br.edu.idp.tech.poo;

import br.edu.idp.tech.poo.dao.CarroDao;
import br.edu.idp.tech.poo.dao.CarroJdbcDao;
import br.edu.idp.tech.poo.dao.CarroJpaDao;
import br.edu.idp.tech.poo.entidade.Carro;
import br.edu.idp.tech.poo.ui.CliIavel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Programa {

    private String sufixo;
    private CliIavel ui;

    public Programa(CliIavel cli) {
        this.ui = cli;
    }

    public void executar() {
        // passo 1 - criando a "marca" da execução

        // marca criada para diferenciar o que é cadastrado em cada execução
        sufixo = " /" + gerarLetraAletoria();
        ui.exibirInformacao("Sufixo da execução: " + sufixo);

        // passo 2 - criação do banco de dados

        // criação da tabela
        prepararBD();

        // passo 3 - várias operações com JDBC
        ui.exibirInformacao("execução via JDBC - início");
        executarPersistencia(new CarroJdbcDao(), 3);
        ui.exibirInformacao("execução via JDBC - término");

        // passo 4 - várias operações com JPA
        ui.exibirInformacao("execução via JPA - início");
        executarPersistencia(new CarroJpaDao(), 4);
        ui.exibirInformacao("execução via JPA - término");

        // cada execução termina com 7 carros inseridos
    }

    private void executarPersistencia(CarroDao dao, int quantidadeCarros) {
        criarRegistros(dao, quantidadeCarros);

        List<Carro> carros = dao.findAll();
        ui.exibirListaCarros(carros);
    }

    private void criarRegistros(CarroDao dao, int quantidadeCarros) {
        // gerador aleatório de carros para "economizar" a inclusão de dados pelo usuário
        CarregadorDados carregador = new CarregadorDados(sufixo);

        Carro novoCarro = carregador.gerarCarro();
        // salvar carro criado
        dao.salvar(novoCarro);

        List<Carro> novosCarros = new ArrayList<>();
        novosCarros.addAll(carregador.gerarListaCarros(quantidadeCarros - 1));
        // salvar coleção de carros
        dao.salvar(novosCarros);
    }

    private void prepararBD() {
        try {
            CarroJdbcDao.criarTabela();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private char gerarLetraAletoria() {
        final int NUM_LETRA_BASE = 97;
        final int QUANTIDADE_LETRAS = 25;

        int numero = GeradorNumAletorio.gerarInt(QUANTIDADE_LETRAS);

        return (char) (NUM_LETRA_BASE + numero);
    }
}
