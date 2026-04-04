package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    //atributos
    private static final String URL = "jdbc:postgresql://db.vtkzbzdfrmmfvfkkcumf.supabase.co:5432/postgres";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "daniel_poo-professor";
    static Connection conn;

    public static void testarConexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL,USUARIO, SENHA);
            System.out.println("Conexão realizada com sucesso.");
            conn.close();
            System.out.println("Conexão fechada.");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC não encontrado");
            System.out.println("Tente novamente mais tarde.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection abrirConexao() throws SQLException {
        conn = DriverManager.getConnection(URL, USUARIO, SENHA);
        return conn;
    }

    public static void fecharConexao() throws ClassNotFoundException {
        try {
            conn.close();
            System.out.println("Conexão fechada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
