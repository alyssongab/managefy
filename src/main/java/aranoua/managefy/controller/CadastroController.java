package aranoua.managefy.controller;

import aranoua.managefy.dao.EquipamentoDAO;
import aranoua.managefy.modelo.Equipamento;
import aranoua.managefy.util.ConexaoBD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "cadastro", value = "/cadastro")
public class CadastroController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String equipamento = request.getParameter("equipamento");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String ano = request.getParameter("ano");

        // validando parâmetros obrigatórios
        if (equipamento == null || equipamento.trim().isEmpty() || marca == null || marca.trim().isEmpty() || modelo == null || modelo.trim().isEmpty()) {
            request.setAttribute("mensagem", "Campos obrigatórios não preenchidos");
            request.setAttribute("tipoMensagem", "danger"); // da classe do bootstrap
            request.getRequestDispatcher("cadastra-equipamentos.jsp").forward(request, response);
            return;
        }

        // tratando o ano opcional
        Integer anoInt = null;
        if (ano != null && !ano.isEmpty()) {
            try {
                anoInt = Integer.parseInt(ano);
            } catch (NumberFormatException e) { // caso o valor informado nao seja numero
                request.setAttribute("mensagem", "Ano inválido");
                request.setAttribute("tipoMensagem", "danger"); // da classe do bootstrap
                request.getRequestDispatcher("cadastra-equipamentos.jsp").forward(request, response);
                return;
            }
        }

        // Se anoInt for null, use 0 como valor padrão
        int anoPrimitivo = (anoInt != null) ? anoInt : 0; // condição que define para 0 ou nãos

        boolean cadastrado = cadastrarEquip(equipamento, marca, modelo, anoPrimitivo);

        if (cadastrado) {
            request.setAttribute("mensagem", "Equipamento cadastrado com sucesso");
            request.setAttribute("tipoMensagem", "success");
        }
        else {
            request.setAttribute("mensagem", "Erro ao cadastrar o equipamento");
            request.setAttribute("tipoMensagem", "danger");
        }

        request.getRequestDispatcher("cadastra-equipamentos.jsp").forward(request, response);
    }

    private boolean cadastrarEquip(String equipamento, String marca, String modelo, int ano) {
        boolean sucesso = false;
        Equipamento equip = new Equipamento(equipamento, marca, modelo, ano);
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();

        try(Connection conn = ConexaoBD.getConexao()){
            equipamentoDAO.inserir(equip);
            sucesso = true;
        }
        catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }

        return sucesso;
    }
}
