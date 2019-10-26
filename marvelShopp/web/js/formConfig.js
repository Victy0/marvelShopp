function validarCPF(cpf) {	
	cpf = cpf.replace(/[^\d]+/g,'');	
	if(cpf == '') return false;	
	// Elimina CPFs invalidos conhecidos	
	if (cpf.length != 11 || 
		cpf == "00000000000" || 
		cpf == "11111111111" || 
		cpf == "22222222222" || 
		cpf == "33333333333" || 
		cpf == "44444444444" || 
		cpf == "55555555555" || 
		cpf == "66666666666" || 
		cpf == "77777777777" || 
		cpf == "88888888888" || 
		cpf == "99999999999")
			return false;		
	// Valida 1o digito	
	add = 0;	
	for (i=0; i < 9; i ++)		
		add += parseInt(cpf.charAt(i)) * (10 - i);	
		rev = 11 - (add % 11);	
		if (rev == 10 || rev == 11)		
			rev = 0;	
		if (rev != parseInt(cpf.charAt(9)))		
			return false;		
	// Valida 2o digito	
	add = 0;	
	for (i = 0; i < 10; i ++)		
		add += parseInt(cpf.charAt(i)) * (11 - i);	
	rev = 11 - (add % 11);	
	if (rev == 10 || rev == 11)	
		rev = 0;	
	if (rev != parseInt(cpf.charAt(10)))
		return false;		
	return true;   
}

var iCount1;
var trava = false;

function MaskDown(e) {    
    if (trava == false) {
        iCount1 = e.value.length;
        trava = true;
    }
}

function MaskUp(e,mascara) {
    if (trava) {
        var textoLimpo = e.value.substr(0,iCount1+1).replace(/[\/\:\-\.]/g,"");
        var texto = "";
        
        var iM = 0;
        var iT = 0;
        while (iM < mascara.length) {
            if (iT < textoLimpo.length) {                
                if (mascara.substr(iM,1) == "#") {
                   texto += textoLimpo.substr(iT,1);
                   iT++;
                } else {
                    texto += mascara.substr(iM,1);
                }            
            }
        iM++;           
        }
    e.value = texto;
    trava = false;
    }    
}

function numeros(e){
        
    if (document.all) // Internet Explorer
        var tecla = event.keyCode;
    else if(document.layers) // Nestcape
        var tecla = e.which;
    
    if ((tecla > 47 && tecla < 58)) // numeros de 0 a 9
        return true;
    else {
        if (tecla != 8) // backspace
             //event.keyCode = 0;
            return false;
        else
            return true;
    }
}

function somenteNumeros(event) {
    var key = event.which || event.keyCode;
    if( key != 8 && isNaN( String.fromCharCode( key ) ) ){
	event.preventDefault();
    }
}



function validatePassword(){
    var password = document.getElementById("senha1");
    var confirm_password = document.getElementById("senha2");
    if(confirm_password.value != ""){
        if(password.value != confirm_password.value) {
            document.getElementById("erroSenhas").style.display = "block";
            return;
        } 
    }
    document.getElementById("erroSenhas").style.display = "none";
}
