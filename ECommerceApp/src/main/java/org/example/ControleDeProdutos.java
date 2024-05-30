package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ControleDeProdutos {
    private static final String URL = "jdbc:h2:~/ecommerce";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public ControleDeProdutos() {
        try {
            Class.forName("org.h2.Driver");  // Carrega o driver do H2
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS produto (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY," +
                    "tipo VARCHAR(255)," +
                    "descricao VARCHAR(255)," +
                    "peso DOUBLE," +
                    "quantidade INT," +
                    "unidadeDeMedida VARCHAR(20))";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarProduto(Produto produto) {
        String sql = "INSERT INTO produto (tipo, descricao, peso, quantidade, unidadeDeMedida) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produto.getTipo());
            pstmt.setString(2, produto.getDescricao());
            pstmt.setDouble(3, produto.getPeso());
            pstmt.setInt(4, produto.getQuantidade());
            pstmt.setString(5, produto.getUnidadeDeMedida().name());
            pstmt.executeUpdate();
            System.out.println("Produto cadastrado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produto pesquisarProduto(String descricao) {
        String sql = "SELECT * FROM produto WHERE descricao = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, descricao);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Produto(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("descricao"),
                        rs.getDouble("peso"),
                        rs.getInt("quantidade"),
                        UnidadeDeMedida.valueOf(rs.getString("unidadeDeMedida"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void alterarProduto(String descricao, Produto produtoAlterado) {
        String sql = "UPDATE produto SET tipo = ?, descricao = ?, peso = ?, quantidade = ?, unidadeDeMedida = ? WHERE descricao = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, produtoAlterado.getTipo());
            pstmt.setString(2, produtoAlterado.getDescricao());
            pstmt.setDouble(3, produtoAlterado.getPeso());
            pstmt.setInt(4, produtoAlterado.getQuantidade());
            pstmt.setString(5, produtoAlterado.getUnidadeDeMedida().name());
            pstmt.setString(6, descricao);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto alterado com sucesso.");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirProduto(String descricao) {
        String sql = "DELETE FROM produto WHERE descricao = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, descricao);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Produto excluído com sucesso.");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarProdutos() {
        String sql = "SELECT * FROM produto";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            List<Produto> produtos = new ArrayList<>();
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getInt("id"),
                        rs.getString("tipo"),
                        rs.getString("descricao"),
                        rs.getDouble("peso"),
                        rs.getInt("quantidade"),
                        UnidadeDeMedida.valueOf(rs.getString("unidadeDeMedida"))
                );
                produtos.add(produto);
            }
            if (produtos.isEmpty()) {
                System.out.println("Nenhum produto cadastrado.");
            } else {
                produtos.forEach(System.out::println);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
