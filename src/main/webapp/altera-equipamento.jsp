<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="aranoua.managefy.modelo.Equipamento" %>
<%@ page import="aranoua.managefy.dao.EquipamentoDAO" %>
<%@ page import="java.sql.SQLException" %>

<html>
<head>
    <title>Managefy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .caixa {
            width: 50%;
            margin: auto;
        }
        .subcaixa {
            width: 75%;
            margin: auto;
        }
    </style>
</head>
<body class="d-flex justify-content-center align-items-center vh-100 bg-dark">

    <%
        String num_tombo = request.getParameter("num_tombo");
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        Equipamento equipamento = null;
        try {
            if (num_tombo != null && !num_tombo.isEmpty()) {
                equipamento = equipamentoDAO.consultar(Long.parseLong(num_tombo));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    %>


    <div class="container">
        <div class="caixa d-flex flex-column gap-4 mb-3 bg-light p-4">
            <%-- Mensagem de alerta --%>
            <%
                String mensagem = (String) request.getAttribute("mensagem");
                String tipoMsg = (String) request.getAttribute("tipoMensagem");
                if (mensagem != null && tipoMsg != null) {
            %>
            <div class="alert alert-<%= tipoMsg %> alert-dismissible fade show" role="alert">
                <%= mensagem %>
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
            <% } %>

            <h2 class="text-center mb-4">Alterar Equipamento</h2>
            <div class="subcaixa">
                <form action="alterar" method="post">
                    <input type="hidden" name="id" value="<%= equipamento.getNum_tombo() %>">

                    <div class="mb-3">
                        <label for="equipamento" class="form-label">Equipamento</label>
                        <input type="text" class="form-control" id="equipamento" name="equipamento"
                               value="<%= equipamento.getEquipamento() %>" required>
                    </div>

                    <div class="mb-3">
                        <label for="marca" class="form-label">Marca</label>
                        <input type="text" class="form-control" id="marca" name="marca"
                               value="<%= equipamento.getMarca() %>" required>
                    </div>

                    <div class="mb-3">
                        <label for="modelo" class="form-label">Modelo</label>
                        <input type="text" class="form-control" id="modelo" name="modelo"
                               value="<%= equipamento.getModelo() %>" required>
                    </div>

                    <div class="mb-3">
                        <label for="ano" class="form-label">Ano de Lançamento</label>
                        <input type="number" class="form-control" id="ano" name="ano"
                               value="<%= equipamento.getAno_lancamento() %>" min="1900" max="2100">
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Salvar</button>
                        <button type="reset" class="btn btn-secondary">Resetar</button>
                        <a href="lista-equipamentos.jsp" class="btn btn-success">Voltar</a>
                    </div>
                </form>
            </div>
        </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
