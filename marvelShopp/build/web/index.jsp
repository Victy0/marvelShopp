<%-- 
    Document   : index
    Created on : 15/09/2019, 16:05:19
    Author     : Victor
--%>

<%@page import="br.com.marvelShopp.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marvel Shopp</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
        <link rel="stylesheet" href="css/style.css" /> 
    </head>
    <body>
        <% Usuario loginUser = (Usuario)request.getSession().getAttribute("user");%>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <section id="corpo"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <hr>
                <div class="container" style="width: 100%;">
                    <div class="col-md-auto" align="center">
                        <a href='/marvelShopp/BuscaController?busca=heroi'>
                            <img id='heroList' class="img-rounded" src="imagens/hero.png" title="Super heróis cadastrados" height="20%" width="90%"/> 
                        </a>
                        <h5></h5>
                    </div>              
                
                    <div class="col-md-auto" align="center">
                        <a href='/marvelShopp/BuscaController?busca=cosmico'>
                            <img id='cosmicList' class="img-rounded float-left" src="imagens/cosmic.png" title="Combatentes cósmicos cadastrados" height="20%" width="49%"/>
                        </a>
                        <a href='/marvelShopp/BuscaController?busca=habilidade'>
                            <img id='abilitiesList' class="img-rounded float-left" src="imagens/abilities.png" title="Combatentes de habilidades cadastrados" height="20%" width="49%"/>
                        </a>
                        <h5></h5>
                    </div>              
                
                    <div class="col-md-auto" align="center">
                        <a href='/marvelShopp/BuscaController?busca=mistico'>
                            <img id='mysticList' class="img-rounded float-left" src="imagens/mystic.png" title="Combatentes místicos cadastrados" width="50%"/>
                        </a>                       
                        <h5></h5>
                    </div>              
                
                    <div class="col-md-auto" align="center">
                        <a href='/marvelShopp/BuscaController?busca=mutante'>
                            <img id='mutantList' class="img-rounded float-left" src="imagens/mutant.png" title="Combatentes mutantes cadastrados" width="47%"/> 
                        </a>
                        <a href='/marvelShopp/BuscaController?busca=tecnologia'>
                            <img id='techList' class="img-rounded float-left" src="imagens/tech.png" title="Combatentes tecnológicos cadastrados" width="52%"/> 
                        </a>
                        <h5></h5>
                    </div>              
                
                    <div class="col-md-auto" align="center">
                        <a href='/marvelShopp/BuscaController?busca=aranha'>
                            <img id='girlList' class="img-rounded" src="imagens/aranha.png" title="Combatentes do aranhaverso cadastrados" width="60%"/> 
                        </a>
                        <h5></h5>
                    </div>              
                
                    <div class="col-md-auto" align="center">
                        <a href='/marvelShopp/BuscaController?busca=feminino'>
                            <img id='spiderList' class="img-rounded float-left" src="imagens/girl.png" title="Combatentes femininas cadastrads" width="48%"/>
                        </a>
                        <a href='/marvelShopp/BuscaController?busca=anti-heroi'>
                            <img id='antiheroList' class="img-rounded float-left" src="imagens/antihero.png" title="Anti-heróis cadastrados" width="51%"/> 
                        </a>
                        <h5></h5>
                    </div>              
                
                    <div class="col-md-auto" align="center">
                        <a href='/marvelShopp/BuscaController?busca=vilao'>
                            <img id='villainList' class="img-rounded" alt="Responsive image" src="imagens/vilo.png" title="Vilões cadastrados" width="90%"/>
                        </a>
                    </div>              
                </div> 
                <hr>
            </section>
            
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
