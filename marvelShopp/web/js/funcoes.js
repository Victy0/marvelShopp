function AumentaPerc() {
    var campo = document.getElementById("percentual");
    campo.value= parseInt(campo.value) + 1;
}

function DiminuiPerc() {
    var campo = document.getElementById("percentual");
    campo.value= parseInt(campo.value) - 1;
}

function menos(quantidade) { 

    if(quantidade!==0) { 
        document.form.quantidade.value=parseFloat(quantidade)-parseFloat(1); 
    } 
    function mais(quantidade) { 
        document.form.quantidade.value=parseFloat(quantidade)+parseFloat(1); 
    }
}
