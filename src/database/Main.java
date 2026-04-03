package database;

import model.Aluno;

public class Main {

    public static void main(String[] args) {

        Conexao conexao = new Conexao();
        conexao.testarConexao();


        AlunoDAO alunoDAO = new AlunoDAO();

        // Adicionar um aluno
        Aluno novoAluno = new Aluno("Zé", "Silva", "15/05/2000");
        alunoDAO.adicionarAluno(novoAluno);

        novoAluno = new Aluno("Ana","do Carmo","20/02/2000");
        alunoDAO.adicionarAluno(novoAluno);

        novoAluno = new Aluno("José","Guimarães","01/02/1998");
        alunoDAO.adicionarAluno(novoAluno);


        // Listar todos os alunos
        System.out.println("Lista de alunos:");
        alunoDAO.listarAlunos();


    }
}

