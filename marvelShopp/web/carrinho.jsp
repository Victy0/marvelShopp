<%-- 
    Document   : carrinhoDeCompras
    Created on : 22/09/2019, 10:06:21
    Author     : Gleison
--%>

<%@page import="br.com.marvelShopp.model.Item"%>
<%@page import="br.com.marvelShopp.model.Carrinho"%>
<%@page import="br.com.marvelShopp.model.Personagem"%>
<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.dao.CarrinhoDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Marvel Shopp - Carrinho</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
       <!-- <link rel = "shortcut icon" type = "imagem/x-icon" href = "imagens/favicon.ico"/> -->
        <link rel="stylesheet" href="css/style.css" /> 
        <script language="javascript" src="js/funcoes_1.js"></script>
    </head>
    
    <body>
        <% Usuario loginUser = (Usuario)request.getSession().getAttribute("user");%>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <section id="carrinho"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                <h1 align="center">Meu Carrinho</h1>
                </br>
                <table>
                    <tr>
                    <th>
                <%
                    Boolean carrinhoVazio =true;
                    Double totalCompra=0.0;
                    
                    Carrinho carrinho = (Carrinho)request.getSession().getAttribute("carrinho");
                    if(carrinho != null){
                        List<Item> itens = carrinho.getItens();
                        if(itens.size()!= 0){
                            carrinhoVazio = false;
                            Double total = 0.0;
                            for(Item item : itens){ 
                                total += item.getPersonagem().getPreco();
                                totalCompra = totalCompra+total;
                %>      
                        <div id="item">
                            <img src="imagens/<%= item.personagem.getImagemRef() %>" class="img-rounded" width="30%" align="left">
                            <h2 align="center"><%= item.personagem.getIdentidade()%></h2>
                            <h3 align="center">R$ <%=String.format("%.2f", (item.personagem.getPreco() * item.getQtd())) %></h3>
                            <div id="qtd" align="center">
                                <a href='CarrinhoController?funcao=atualiza&op=m&idPersonagem=<%=item.personagem.getId()%>' class='btn btn-danger' >-</a>
                                <input type='text' id="percentage" name="percentage" value="<%=item.getQtd()%>" readonly="readonly"/>
                                <a href='CarrinhoController?funcao=atualiza&idPersonagem=<%=item.personagem.getId()%>' class='btn btn-danger' >+</a> 
                                <form action="/marvelShopp/CarrinhoController" method="POST" align="center">
                                    <input type="hidden" value="delete" name="funcao"/>
                                    <input type="hidden" value="<%= item.id %>" name="itemRemove"/>
                                    <input type="submit" class="btn btn-primary" value="Remover" name="remover" style="width:90px;background: #000;">
                                </form>
                            </div>
                        </div> 
                    <%        
                            } 
                        }else{%>
                            <div align="center"><h1 style="color: red;">NENHUM ITEM NO CARRINHO!!!</h1></div>
                   <%   }
                    }else{%>
                    <div align="center"><h1 style="color: red;">NENHUM ITEM NO CARRINHO!!!</h1></div>
                   <% }
                %>
                
                <%
                    
                    if(!carrinhoVazio){
                        Double desconto = totalCompra*0.1;
                %>
                </th><th>
                        <div id="resumoDaCompra" align="right">
                            <h1>Resumo da compra</h1>
                            <form action="/marvelShopp/PagamentoController" method="GET" id="resumoCompra">            
                                <table id="resumoDaCompra" style="margin-right: -5px; margin-left: -40px;">
                                    <tr align="left">
                                        <td>Subtotal</td>
                                        <td id="preco">R$ <%= String.format("%.2f", totalCompra)%></td>
                                    </tr>
                                    <tr>
                                       <td>Frete</td>
                                       <td id="preco">R$ 10,00</td>
                                    </tr>
                                    <tr>
                                       <td>Desconto</td>
                                       <td id="preco">R$ <%= String.format("%.2f", desconto)%></td>
                                    </tr>
                                    <tr>
                                       <td>Valor total</td>
                                       <td id="preco">R$ <%= String.format("%.2f", totalCompra + 10 - desconto)%> </td>
                                    </tr>
                                </table>
                                    <input type="submit" align="center" value="CONTINUAR" ID="irPag" name="irPag" style="width:300px;margin-right: 100px;"/>
                            </form>
                                    <br>        
                            <a href="javascript:history.back()" class='btn btn-danger' >CONTINUAR COMPRANDO</a>
                        </div>
                <%
                    }
                %>
            </th></tr></table>
                </br>
                </br>
            </section>
                </br>
                </br>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
