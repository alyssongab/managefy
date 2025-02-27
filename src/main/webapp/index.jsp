<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Managefy</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="style/extra.css">
</head>
<body class="d-flex justify-content-center align-items-center vh-100 bg-dark">

    <div class="container text-center border border-secondary-subtle p-3 w-25 rounded-3 bg-primary-subtle">
        <%-- Caso a autenticação do usuário falhe --%>
        <% String mensagemErro = (String) request.getAttribute("mensagemErro"); %>
            <% if (mensagemErro != null) { %>
            <div class="alert alert-danger" role="alert">
                <%= mensagemErro %>
            </div>
        <% } %>
        <h1 class="text-center mb-4">Bem vindo</h1>
        <p class= "fs-5 mb-4">Faça login para continuar</p>
        <form action="home" method="post" class="text-center">
            <div class="d-flex flex-column gap-4 mb-3">
                <div id="email-box">
                    <label for="matricula" class="form-label">ID da matrícula</label>
                    <input type="text" name="matricula" id="matricula" class="text-center form-control w-75 mx-auto" required>
                </div>
                <div id="password-box">
                    <label for="SENHA" class="form-label">Senha</label>
                    <input type="password" name="senha" id="senha" class="text-center form-control w-75 mx-auto" required>
                </div>

                <button type="submit" class="w-50 mb-3 mx-auto btn btn-primary">Log in</button>
            </div>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>