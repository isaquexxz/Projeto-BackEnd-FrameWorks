package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Aluno;

public class AlunoDAO {

    ArrayList<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        String sql = "INSERT INTO aluno (primeiro_nome, ultimo_nome, nascimento) VALUES (?, ?, ?);";
        System.out.println(sql);
        try {
            Connection conn = Conexao.abrirConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getPrimeiroNome());
            stmt.setString(2, aluno.getUltimoNome());
            stmt.setString(3, aluno.getDataDeNascimento());
            stmt.executeUpdate();
            System.out.println("Aluno adicionado com sucesso!");
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void listarAlunos() {
        String sql = "SELECT * FROM aluno;";
        try {
            Connection conn = Conexao.abrirConexao();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Aluno aluno = new Aluno(rs.getString("primeiro_nome"),rs.getString("ultimo_nome"),rs.getString("nascimento"));
                alunos.add(aluno);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < alunos.size(); i++) {
            System.out.println("Primeiro nome do aluno: "+alunos.get(i).getPrimeiroNome());
            System.out.println("Último nome do aluno: "+alunos.get(i).getUltimoNome());
            System.out.println("Data de Nascimento: "+alunos.get(i).getDataDeNascimento()+"\n");
        }
    }

    public void updateDatabase (Aluno aluno, int id) throws SQLException {
            String sql = "INSERT INTO aluno (primeiro_nome, ultimo_nome, nascimento) VALUES (?, ?, ?);";
            System.out.println(sql);

            try {
                Connection conn = Conexao.abrirConexao();
                PreparedStatement stmt = conn.prepareStatement(sql);

                // Preenchendo os novos dados
                stmt.setString(1, aluno.getPrimeiroNome());
                stmt.setString(2, aluno.getUltimoNome());
                stmt.setString(3, aluno.getDataDeNascimento());

                // Preenchendo o ID
                stmt.setInt(4, id);

                int linhasAfetadas = stmt.executeUpdate();

                if (linhasAfetadas > 0) {
                    System.out.println("Aluno atualizado com sucesso!");
                } else {
                    System.out.println("Nenhum aluno encontrado com o ID: " + id);
                }

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    public void deleteAlunoDataBase(int id) {
        // Comando SQL para deletar usando a chave primária
        String sql = "DELETE FROM aluno WHERE id = ?;";
        System.out.println(sql);

        try {
            Connection conn = Conexao.abrirConexao();
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Substitui o '?' pelo id passado como parâmetro
            stmt.setInt(1, id);

            // executeUpdate() retorna o número de linhas que foram alteradas no banco
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Aluno deletado com sucesso!");
            } else {
                System.out.println("Nenhum aluno encontrado com o ID informado.");
            }

            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao tentar deletar o aluno:");
            e.printStackTrace();
        }
    }
}
