package aranoua.managefy.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexaoBD {

    private static final String url = "jdbc:mysql://localhost:3306/managefy";
    private static final String usuario= "root";
    private static final String senha = "Aly@4341";

    public static Connection getConexao() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){ // exceção em caso de erro
            throw new RuntimeException(e);
        }

        return DriverManager.getConnection(url, usuario, senha);
    }
}
