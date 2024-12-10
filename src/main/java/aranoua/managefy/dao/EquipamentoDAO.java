package aranoua.managefy.dao;

import aranoua.managefy.modelo.Equipamento;
import aranoua.managefy.util.ConexaoBD;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {

    // cadastrar ou inserir equipamento
    public void inserir(Equipamento equip) throws SQLException {
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getConexao();
        Statement stmt = conexao.createStatement();

        String inserir = "insert into equipamento " +
                        "(equip, marca, modelo, ano_lancamento) " +
                        "values " +
                        "('"+equip.getEquipamento()+"', '"+equip.getMarca()+"', '"+equip.getModelo()+", "+equip.getAno_lancamento()+"');";

        System.out.println("SQL: " + inserir);
        stmt.execute(inserir);
    }

    // alterar equipamento
    public void alterar(Equipamento equip) throws SQLException {
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getConexao();
        Statement stmt = conexao.createStatement();

        String alterar = "update equipamento " +
                        "set equip = '"+equip.getEquipamento()+"', "+
                        "marca = '"+equip.getMarca()+"', "+
                        "modelo = '"+equip.getModelo()+"', "+
                        "ano_lancamento = "+equip.getAno_lancamento()+
                        "where num_tombo = "+equip.getNum_tombo()+";";

        System.out.println("SQL: " + alterar);
        stmt.execute(alterar);
    }

    // excluir equipamento
    public void excluir(Equipamento equip) throws SQLException {
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getConexao();
        Statement stmt = conexao.createStatement();

        String excluir = "delete from equipamento where num_tombo = "+equip.getNum_tombo()+";";

        System.out.println("SQL: " + excluir);
        stmt.execute(excluir);
    }

    // Listar equipamentos
    public List<Equipamento> listar() throws SQLException {
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getConexao();
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
    public Equipamento consultar(int num_tombo) throws SQLException {
        ConexaoBD con = new ConexaoBD();
        Connection conexao = con.getConexao();
        Statement stmt = conexao.createStatement();

        String consultar = "select * from equipamento where id = "+num_tombo+";";
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
