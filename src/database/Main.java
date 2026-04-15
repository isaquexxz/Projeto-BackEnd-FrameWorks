package database;
//Grupo: Maurício e Isaque
import model.Carro;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        // TESTAR conexão
        Conexao conexao = new Conexao();
        conexao.testarConexao();

        // CRIANDO objeto carroDAO
        CarroDAO carroDAO = new CarroDAO();

        // ADICIONAR um carro
        Carro novoCarro = new Carro(1,"Uno", "R$20.000,00", "2010");
        carroDAO.adicionarCarro(novoCarro);

        novoCarro = new Carro(2,"Corsa","R$16.000,00","2004");
        carroDAO.adicionarCarro(novoCarro);

        novoCarro = new Carro(3,"Palio","R$12.000,00","2003");
        carroDAO.adicionarCarro(novoCarro);

        // LISTAR todos os carros
        System.out.println("Lista de carros:");
        carroDAO.listarCarros();

        // ATUALIZAR carro
        Carro newCarro = new Carro(1, "Celta", "R$14.000,00", "2006");
        carroDAO.updateCarro(newCarro, 1);

        //DELETAR carro
        carroDAO.deleteCarro(2);
    }
}

