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
                <h1 id="titulo" align="center">Meu Carrinho</h1>
                </br>
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
                            <img src="imagens/<%= item.personagem.getImagemRef() %>" id="imgItem">
                            <h1><%= item.personagem.getIdentidade()%></h2>
                            <h3>(<%= item.personagem.getNomeReal()%>)</h3>
                            <div id="qtd">
                                <button  class="btn btn-primary" onClick="AumentaPerc()">+</button>
                                <input type='text' id="percentage" name="percentage" value="1" readonly="readonly"/>
                                <button class="btn btn-primary" onClick="DiminuiPerc()">-</button>
                            </div>
                            <br/>
                            <p>R$ <%= item.personagem.getPreco()%></p>
                            
                            <form action="/marvelShopp/CarrinhoController" method="POST">
                                <input type="hidden" value="delete" name="funcao"/>
                                <input type="hidden" value="<%= item.id %>" name="itemRemove"/>
                                <input type="submit" class="btn btn-primary" value="Remover" name="remover" style="width:90px;">
                            </form>
                        </div>
                                
                                
                    <%        
                            } 
                            System.out.println("<div id='item'><h5> R$ "+total+"</h5></div");
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
                        <div id="resumoDaCompra">
                            <h1>Resumo da compra</h1>
                            <form action="/marvelShopp/PagamentoController" method="GET" id="resumoCompra">            
                                <table id="resumoDaCompra">
                                    <tr>
                                        <td>Subtotal</td>
                                        <td id="preco">R$ <%= totalCompra%></td>
                                    </tr>
                                    <tr>
                                       <td>Frete</td>
                                       <td id="preco">R$ 10.00</td>
                                    </tr>
                                    <tr>
                                       <td>Desconto</td>
                                       <td id="preco">R$ <%= desconto%></td>
                                    </tr>
                                    <tr>
                                       <td>Valor total</td>
                                       <td id="preco">R$ <%= totalCompra + 10 - desconto%> </td>
                                    </tr>
                                </table>
                                    <input type="submit" value="CONTINUAR" ID="irPag" name="irPag" style="width:300px;"/>
                            </form>
                                    
                            <form action="index.jsp">
                                <button type="submit" style="margin-left: 220px;">CONTINUAR COMPRANDO</button>
                            </form>
                        </div>
                <%
                    }
                %>
                
                </br>
                </br>
            </section>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
