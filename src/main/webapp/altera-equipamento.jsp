<%--
  Created by IntelliJ IDEA.
  User: alysson
  Date: 12/10/24
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Managefy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="style/extra.css">
    <style>
        .caixa {
            width: 50%;
            margin: auto;
        }
        .subcaixa{
            width: 75%;
            margin: auto;
        }
    </style>
</head>
<body class="d-flex justify-content-center align-items-center vh-100 bg-dark">

<div class="container">
    <div class="caixa d-flex flex-column gap-4 mb-3 bg-light p-4">
        <%-- Verifica se veio alguma mensagem do controller --%>
        <%
            String mensagem = (String) request.getAttribute("mensagem");
            String tipoMsg = (String) request.getAttribute("tipoMensagem");
            if(mensagem != null && tipoMsg != null){
        %>

        <div class="alert alert-<%=tipoMsg%> alert-dismissible fade show" role="alert">
            <%=mensagem%>
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div>
        <% } %>
        <h2 class="text-center mb-4">Cadastrar Novo Equipamento</h2>
        <div class="subcaixa">
            <form action="altera" method="post">
                <div class="mb-3">
                    <label for="equipamento" class="form-label">Equipamento</label>
                    <input type="text" class="form-control" id="equipamento" name="equipamento" required>
                </div>

                <div class="mb-3">
                    <label for="marca" class="form-label">Marca</label>
                    <input type="text" class="form-control" id="marca" name="marca" required>
                </div>

                <div class="mb-3">
                    <label for="modelo" class="form-label">Modelo</label>
                    <input type="text" class="form-control" id="modelo" name="modelo" required>
                </div>

                <div class="mb-3">
                    <label for="ano" class="form-label">Ano de Lançamento</label>
                    <input type="number" class="form-control" id="ano" name="ano" min="1900" max="2100">
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

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
