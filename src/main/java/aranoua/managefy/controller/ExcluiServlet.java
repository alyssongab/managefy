package aranoua.managefy.controller;

import aranoua.managefy.dao.EquipamentoDAO;
import aranoua.managefy.modelo.Equipamento;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "excluirServlet", value = "/exclui")
public class ExcluiServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();

        try {
            Equipamento equipamento = equipamentoDAO.consultar(id);
            equipamentoDAO.excluir(equipamento);
            request.setAttribute("mensagem", "Equipamento excluído com sucesso!");
            request.setAttribute("tipoMensagem", "success");
            request.getRequestDispatcher("lista-equipamentos.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Erro ao excluir equipamento", e);
        }
    }
}
