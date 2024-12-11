package aranoua.managefy.controller;

import aranoua.managefy.util.ConexaoBD;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "loginServlet", value = "/home")
public class LoginController extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String matricula = request.getParameter("matricula");
        String senha = request.getParameter("senha");

        boolean autenticado = autenticarUsuario(matricula, senha);

        if(autenticado){
            response.sendRedirect("lista-equipamentos.jsp");
        }
        else {
            request.setAttribute("mensagemErro", "Credenciais inválidas");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // metodo que autentica o usuario
    private boolean autenticarUsuario(String matricula, String senha) {
        boolean validado = false;

        try(Connection conn = ConexaoBD.getConexao()){ // estabele a conexao, ja que ConexaoBD é static
            String sql = "select * from usuarios where matricula = ? and senha = ?";
            // prepara a instrução com os parametros recebidos
            try(PreparedStatement statement = conn.prepareStatement(sql)){
                statement.setString(1, matricula);
                statement.setString(2, senha);
                // consulta no banco se existe os parametros
                try(ResultSet resultados = statement.executeQuery()){
                    validado = resultados.next(); // é esperado o valor true
                }
            }
        }
        catch(Exception e){
            System.out.println("Erro :" + e.getMessage());
        }

        return validado;
    }
}
