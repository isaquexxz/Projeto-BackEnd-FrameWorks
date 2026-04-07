package database;

import model.Aluno;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Conexao conexao = new Conexao();
        conexao.testarConexao();


        AlunoDAO alunoDAO = new AlunoDAO();

        // Adicionar um aluno
        Aluno novoAluno = new Aluno(1,"Zé", "Silva", "15/05/2000");
        alunoDAO.adicionarAluno(novoAluno);

        novoAluno = new Aluno(2,"Ana","do Carmo","20/02/2000");
        alunoDAO.adicionarAluno(novoAluno);

        novoAluno = new Aluno(3,"José","Guimarães","01/02/1998");
        alunoDAO.adicionarAluno(novoAluno);


        // Listar todos os alunos
        System.out.println("Lista de alunos:");
        alunoDAO.listarAlunos();
        // Update de alunos
        Aluno newAluno = new Aluno(1, "isaque", "pereira", "22/03/2005");
        alunoDAO.updateDatabase(newAluno, 1);

        //Deletar alunos
        alunoDAO.deleteAlunoDataBase(2);
    }
}

