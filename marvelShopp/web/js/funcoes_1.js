function AumentaPerc() {
    var campo = document.getElementById("percentage");
    var preco = document.getElementById("preco")
    campo.value= parseInt(campo.value) + 1;
}

function DiminuiPerc() {
    var campo = document.getElementById("percentage");
    campo.value= parseInt(campo.value) - 1;
}