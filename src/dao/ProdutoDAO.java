package dao;

import util.Conexao;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public void inserir(Produto produto) {

        String sql = "INSERT INTO produto (nome, preco) VALUES (?, ?)";

        try (Connection conn = Conexao.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir o produto!", e);
        }
    }

    public List<Produto> listar() {

        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT nome, preco FROM produto";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");

                Produto produto = new Produto(nome, preco);
                produtos.add(produto);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os produtos!", e);
        }

        return produtos;
    }

    public void alterar (String nomeAntigo, Produto produto) {

        String sql = "UPDATE produto SET nome = ?, preco = ? WHERE nome = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setString(3, nomeAntigo);

            int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas == 0) {
                System.out.println("Não existe produto com esse nome!");
            }
            else {
                System.out.println("Dados alterados com sucesso!");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao alterar os dados do produto!", e);
        }
    }

    public void deletar (String nome) {

        String sql = "DELETE FROM produto WHERE nome = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setString(1, nome);

            int linhasAlteradas = stmt.executeUpdate();

            if (linhasAlteradas == 0) {
                System.out.println("Esse produto não existe!");
            }
            else {
                System.out.println("produto deletado com sucesso!");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar o produto!", e);
        }
    }
}
