<%@ page import="aranoua.managefy.dao.EquipamentoDAO" %>
<%@ page import="aranoua.managefy.modelo.Equipamento" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Managefy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="style/extra.css">
    <style>
        .table-container {
            margin-top: 30px;
        }
        .btn {
            width: 140px;
        }
    </style>
</head>
<body class="bg-dark">

<div class="container-sm">
    <div class="d-flex justify-content-between align-items-center my-4">
        <h1 class="fs-1 text-white">Detalhes do Equipamento</h1>
        <a href="lista-equipamentos.jsp" class="btn btn-secondary">Voltar para Lista</a>
    </div>

    <%
        String tombo = request.getParameter("num_tombo");
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        Equipamento equipamento = null;

        try {
            if (tombo != null) {
                equipamento = equipamentoDAO.consultar(Long.parseLong(tombo));
            }

            if (equipamento == null) {
                out.print("<div class='alert alert-danger'>Equipamento não encontrado.</div>");
            }

        } catch (SQLException e) {
            out.print("<div class='alert alert-danger'>Erro ao consultar equipamento: " + e.getMessage() + "</div>");
        }
    %>

    <%
        if (equipamento != null) {
    %>
    <div class="table-container">
        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover text-center align-middle">
                <thead class="table-info">
                <tr>
                    <th>Num. Tombo</th>
                    <th>Equipamento</th>
                    <th>Marca</th>
                    <th>Modelo</th>
                    <th>Ano de Lançamento</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td><%= equipamento.getNum_tombo() %></td>
                    <td><%= equipamento.getEquipamento() %></td>
                    <td><%= equipamento.getMarca() %></td>
                    <td><%= equipamento.getModelo() %></td>
                    <td><%= equipamento.getAno_lancamento() %></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <% } %>
</div>

<script src="scripts/handle.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
