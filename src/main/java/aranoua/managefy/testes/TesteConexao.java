package aranoua.managefy.testes;

import aranoua.managefy.util.ConexaoBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexao {
    public static void main(String[] args) {
        ConexaoBD conn = new ConexaoBD();

        try{
            Connection conexao = conn.getConexao();

            String sql = "select * from equipamento";
            System.out.println("SQL: " + sql);

            Statement conexaoStatement = conexao.createStatement();
            boolean temResultado = conexaoStatement.execute(sql);

            if(temResultado){
                ResultSet resultados = conexaoStatement.getResultSet();
                while(resultados.next()){
                    System.out.println("Numero de Tombo: " + resultados.getInt("num_tombo"));
                    System.out.println("Equipamento: " + resultados.getString("equip"));
                    System.out.println("Marca: " + resultados.getString("marca"));
                    System.out.println("Modelo: " + resultados.getString("modelo"));
                    System.out.println("Ano de lançamento: " + resultados.getInt("ano_lancamento"));
                }
            }
        }
        catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
