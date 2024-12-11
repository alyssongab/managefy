package aranoua.managefy.controller;

import aranoua.managefy.dao.EquipamentoDAO;
import aranoua.managefy.modelo.Equipamento;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/alterar")
public class AlteraController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numTombo = request.getParameter("id");
        String equipamento = request.getParameter("equipamento");
        String marca = request.getParameter("marca");
        String modelo = request.getParameter("modelo");
        String ano = request.getParameter("ano");

        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        Equipamento eq = new Equipamento();
        eq.setNum_tombo(Long.parseLong(numTombo));
        eq.setEquipamento(equipamento);
        eq.setMarca(marca);
        eq.setModelo(modelo);
        eq.setAno_lancamento(Integer.parseInt(ano));

        try {
            // Chama o método alterar, sem retornar nada
            equipamentoDAO.alterar(eq);

            // Se a alteração for bem-sucedida
            request.setAttribute("mensagem", "Equipamento alterado com sucesso!");
            request.setAttribute("tipoMensagem", "success");
        } catch (SQLException e) {
            // Caso haja erro
            request.setAttribute("mensagem", "Erro ao alterar equipamento: " + e.getMessage());
            request.setAttribute("tipoMensagem", "danger");
        }

        // Redireciona de volta para a página de edição com a mensagem
        RequestDispatcher dispatcher = request.getRequestDispatcher("altera-equipamento.jsp?num_tombo=" + numTombo);
        dispatcher.forward(request, response);
    }
}
