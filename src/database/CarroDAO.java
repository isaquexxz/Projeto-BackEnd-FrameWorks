package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Carro;

public class CarroDAO {

    ArrayList<Carro> carros = new ArrayList<>();

    public void adicionarCarro(Carro carro) {
        String sql = "INSERT INTO carro (id, nome_carro, valor_carro, ano_carro) VALUES (?, ?, ?, ?);";
        System.out.println(sql);
        try {
            Connection conn = Conexao.abrirConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, carro.getId());
            stmt.setString(2, carro.getNomeCarro());
            stmt.setString(3, carro.getValorCarro());
            stmt.setString(4, carro.getAnoCarro());
            stmt.executeUpdate();
            System.out.println("Carro adicionado com sucesso!");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void listarCarros() {
        String sql = "SELECT * FROM carro;";
        try {
            Connection conn = Conexao.abrirConexao();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Carro carro = new Carro(rs.getInt("id"), rs.getString("nome_carro"),rs.getString("valor_carro"),rs.getString("ano_carro"));
                carros.add(carro);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < carros.size(); i++) {
            System.out.println("id do carro:"+ carros.get(i).getId());
            System.out.println("Nome do carro: "+ carros.get(i).getNomeCarro());
            System.out.println("Valor do carro: "+ carros.get(i).getValorCarro());
            System.out.println("Ano do carro: "+ carros.get(i).getAnoCarro()+"\n");
        }
    }

    public void updateCarro(Carro carro, int id) {
        // O erro costuma ser colocar parênteses aqui igual no INSERT.
        // O CORRETO É ASSIM:
        String sql = "UPDATE carro SET nome_carro = ?, valor_carro = ?, ano_carro = ? WHERE id = ?;";

        System.out.println("Executando: " + sql); // Isso ajuda a ver o erro no console

        try (Connection conn = Conexao.abrirConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // 1º ponto de interrogação
            stmt.setString(1, carro.getNomeCarro());
            // 2º ponto de interrogação
            stmt.setString(2, carro.getValorCarro());
            // 3º ponto de interrogação
            stmt.setString(3, carro.getAnoCarro());
            // 4º ponto de interrogação (o ID que vai no WHERE)
            stmt.setInt(4, id);

            stmt.executeUpdate(); // Linha 75
            System.out.println("Carro atualizado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteCarro(int id) {
        // Comando SQL para deletar usando a chave primária
        String sql = "DELETE FROM carro WHERE id = ?;";
        System.out.println(sql);

        try {
            Connection conn = Conexao.abrirConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Substitui o '?' pelo id passado como parâmetro
            stmt.setInt(1, id);

            // executeUpdate() retorna o número de linhas que foram alteradas no banco
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Carro deletado com sucesso!");
            } else {
                System.out.println("Nenhum carro encontrado com o ID informado.");
            }

            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao tentar deletar o carro:");
            e.printStackTrace();
        }
    }
}
