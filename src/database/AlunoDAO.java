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

}
