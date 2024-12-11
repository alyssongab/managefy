package aranoua.managefy.dao;

import aranoua.managefy.modelo.Equipamento;
import aranoua.managefy.util.ConexaoBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {

    // cadastrar ou inserir equipamento
    public void inserir(Equipamento equip) throws SQLException {
        Connection conexao = ConexaoBD.getConexao();
        Statement stmt = conexao.createStatement();

        String inserir = "insert into equipamento " +
                        "(equip, marca, modelo, ano_lancamento) " +
                        "values " +
                        "('"+equip.getEquipamento()+"', '"+equip.getMarca()+"', '"+equip.getModelo()+"', "+equip.getAno_lancamento()+");";

        System.out.println("SQL: " + inserir);
        stmt.execute(inserir);
    }

    // editar equipamento
    public void alterar(Equipamento equip) throws SQLException {
        Connection conexao = ConexaoBD.getConexao();

        // sql utilizando prepared statement
        String alterarSQL = "UPDATE equipamento SET equip = ?, marca = ?, modelo = ?, ano_lancamento = ? WHERE num_tombo = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(alterarSQL)) {
            // definindo os parâmetros da instrução
            stmt.setString(1, equip.getEquipamento());
            stmt.setString(2, equip.getMarca());
            stmt.setString(3, equip.getModelo());
            stmt.setInt(4, equip.getAno_lancamento());
            stmt.setLong(5, equip.getNum_tombo());

            // executa a instrução
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao alterar equipamento: " + e.getMessage());
        }
    }


    // excluir equipamento
    public void excluir(Equipamento equip) throws SQLException {
        Connection conexao = ConexaoBD.getConexao();
        Statement stmt = conexao.createStatement();

        String excluir = "delete from equipamento where num_tombo = "+equip.getNum_tombo()+";";

        System.out.println("SQL: " + excluir);
        stmt.execute(excluir);
    }

    // Listar equipamentos
    public List<Equipamento> listar() throws SQLException {
        Connection conexao = ConexaoBD.getConexao();
        Statement stmt = conexao.createStatement();

        String listar = "select num_tombo, equip, marca from equipamento;";
        System.out.println("SQL: " + listar);
        boolean resultado = stmt.execute(listar);

        List<Equipamento> equipamentos = new ArrayList<>();
        Equipamento equipamento = null;

        if(resultado){
            ResultSet resultados = stmt.getResultSet();
            while(resultados.next()){
                equipamento = new Equipamento();
                equipamento.setNum_tombo(resultados.getLong(1));
                equipamento.setEquipamento(resultados.getString(2));
                equipamento.setMarca(resultados.getString(3));
                equipamentos.add(equipamento);
            }
        }

        return equipamentos;
    }

    // consultar equipamentos pelo numero de tombo
    public Equipamento consultar(long num_tombo) throws SQLException {
        Connection conexao = ConexaoBD.getConexao();
        Statement stmt = conexao.createStatement();

        String consultar = "select * from equipamento where num_tombo = "+num_tombo+";";
        System.out.println("SQL: " + consultar);

        ResultSet resultados = stmt.executeQuery(consultar); //

        Equipamento equipamento = null;

        if (resultados.next()) {  // verifica se tem resultado
            equipamento = new Equipamento();
            equipamento.setNum_tombo(resultados.getLong(1));
            equipamento.setEquipamento(resultados.getString(2));
            equipamento.setMarca(resultados.getString(3));
            equipamento.setModelo(resultados.getString(4));
            equipamento.setAno_lancamento(resultados.getInt(5));
        }
        return equipamento;
    }
}
