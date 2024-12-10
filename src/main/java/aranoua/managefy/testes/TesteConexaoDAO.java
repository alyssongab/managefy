package aranoua.managefy.testes;

import aranoua.managefy.dao.EquipamentoDAO;
import aranoua.managefy.modelo.Equipamento;
import aranoua.managefy.util.ConexaoBD;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TesteConexaoDAO {
    public static void main(String[] args) {
        EquipamentoDAO dao = new EquipamentoDAO();
        try {
            // listar com DAO
            List<Equipamento> equipamentos = dao.listar();
            for(Equipamento equipamento : equipamentos) {
                System.out.println("Numero de tombo: "+equipamento.getNum_tombo());
                System.out.println("Equipamento: "+equipamento.getEquipamento());
                System.out.println("Marca: "+equipamento.getMarca());
            }

            System.out.println("Listado com sucesso!\n");
        }
        catch(SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
