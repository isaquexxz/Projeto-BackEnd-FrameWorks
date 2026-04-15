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

    // Função para ADICIONAR carros
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

    // Função para LISTAR carros
    public void listarCarros() {

        String sql = "SELECT * FROM carro;";
        System.out.println("Executando: " + sql);

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
    // Função para ATUALIZAR carros
    public void updateCarro(Carro carro, int id) {

        String sql = "UPDATE carro SET nome_carro = ?, valor_carro = ?, ano_carro = ? WHERE id = ?;";
        System.out.println("Executando: " + sql);

        try (Connection conn = Conexao.abrirConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, carro.getNomeCarro());
            stmt.setString(2, carro.getValorCarro());
            stmt.setString(3, carro.getAnoCarro());
            stmt.setInt(4, id);

            stmt.executeUpdate(); // Linha 75
            System.out.println("Carro atualizado!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Função para DELETAR carros
    public void deleteCarro(int id) {

        String sql = "DELETE FROM carro WHERE id = ?;";
        System.out.println("Executando: " + sql);

        try {
            Connection conn = Conexao.abrirConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

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
