package database;

import model.Carro;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        Conexao conexao = new Conexao();
        conexao.testarConexao();


        CarroDAO carroDAO = new CarroDAO();

        // Adicionar um carro
        Carro novoCarro = new Carro(1,"Uno", "20000", "2010");
        carroDAO.adicionarCarro(novoCarro);

        novoCarro = new Carro(2,"Corsa","16000","2004");
        carroDAO.adicionarCarro(novoCarro);

        novoCarro = new Carro(3,"Palio","12000","2003");
        carroDAO.adicionarCarro(novoCarro);


        // Listar todos os carros
        System.out.println("Lista de carros:");
        carroDAO.listarCarros();
        // Update de carro
        Carro newCarro = new Carro(1, "Celta", "14000", "2006");
        carroDAO.updateCarro(newCarro, 1);

        //Deletar carro
        carroDAO.deleteCarro(2);
    }
}

