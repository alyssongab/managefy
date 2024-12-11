<%@ page import="aranoua.managefy.dao.EquipamentoDAO" %>
<%@ page import="aranoua.managefy.modelo.Equipamento" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <title>Managefy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .table-container {
            margin-top: 30px;
        }
        .btn {
            width: 100px;
        }
        .cadastrobtn {
            width: 200px;
        }
    </style>
</head>
<body class="bg-dark">

<div class="container">
    <div class="d-flex justify-content-between align-items-center my-4">
        <h1 class="fs-1 text-white">Lista de Equipamentos</h1>
        <a href="cadastrarEquipamento.jsp" class="cadastrobtn btn btn-primary">Cadastrar</a>
    </div>

    <%
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        try {
            List<Equipamento> equipamentos = equipamentoDAO.listar();
            request.setAttribute("equipamentos", equipamentos);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    %>

    <div class="table-container">
        <div class="table-responsive">
            <table class="table table-striped table-bordered table-hover text-center align-middle">
                <thead class="table-info">
                <tr>
                    <th>Num. Tombo</th>
                    <th>Equipamento</th>
                    <th>Marca</th>
                    <th>Ações</th>
                </tr>
                </thead>
                <tbody>
                <%
                    List<Equipamento> equipamentosList = (List<Equipamento>) request.getAttribute("equipamentos");
                    if (equipamentosList != null) {
                        for (Equipamento e : equipamentosList) {
                %>
                <tr>
                    <td><%= e.getNum_tombo() %></td>
                    <td><%= e.getEquipamento() %></td>
                    <td><%= e.getMarca() %></td>
                    <td>
                        <a href="detalhesEquipamento.jsp?id=<%= e.getNum_tombo() %>" class="btn btn-info btn-sm">Ver Detalhes</a>
                        <a href="editarEquipamento.jsp?id=<%= e.getNum_tombo() %>" class="btn btn-warning btn-sm">Editar</a>
                        <a href="excluirEquipamento.jsp?id=<%= e.getNum_tombo() %>" class="btn btn-danger btn-sm">Excluir</a>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
