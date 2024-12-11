// Função para exibir o popup e definir o ID
function abrirPopup(id) {
    document.getElementById('idExcluir').value = id; // Define o ID no campo oculto
    document.getElementById('popupDiv').style.display = 'block'; // Mostra o popup
}

// Função para fechar o popup
function fecharDiv() {
    document.getElementById('popupDiv').style.display = 'none'; // Oculta o popup
}
