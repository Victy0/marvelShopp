<%-- 
    Document   : pagamento
    Created on : 26/10/2019, 18:04:39
    Author     : Gleison
--%>

<%@page import="br.com.marvelShopp.model.TipoPagamento"%>
<%@page import="br.com.marvelShopp.dao.TipoPagamentoDao"%>
<%@page import="br.com.marvelShopp.model.Endereco"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.marvelShopp.model.Item"%>
<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.model.Carrinho"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css" />
        <title>Marvel Shopp</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
    </head>
    <body>
        <%
            TipoPagamentoDao tipoPagamentoDao = new TipoPagamentoDao();
        %>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <% 
                Usuario user = (Usuario)request.getSession().getAttribute("user");
                String enderecoSelectId;
                String formPag;
                
            %>
                <section id="carrinho"> <!--divisão da pagina. Aqui se inicia o corpo da pagina (seção do meio)-->
                    <h1 id="titulo">Meu Carrinho</h1>
                    <form id="fecharCompra" action="PagamentoController" method="POST">
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
                                <img src="imagens/<%= item.getPersonagem().getImagemRef() %>" class="img-rounded" width="30%" align="left">
                                <h2 align="center"><%= item.getPersonagem().getIdentidade()%></h2>
                                <h3 align="center">R$ <%= item.getPersonagem().getPreco() * item.getQtd() %></h3>
                                <div id="qtd" align="center">
<!--                                    <button  class="btn btn-primary" onClick="AumentaPerc()">+</button>
                                    <input type='text' id="percentage" name="percentage" value="1" readonly="readonly"/>
                                    <button class="btn btn-primary" onClick="DiminuiPerc()">-</button>-->
                                    <form action="/marvelShopp/CarrinhoController" method="POST" align="center">
                                        <input type="hidden" value="delete" name="funcao"/>
                                        <input type="hidden" value="<%= item.getId() %>" name="itemRemove"/>
                                        <input type="submit" class="btn btn-primary" value="Remover" name="remover" style="width:90px;background: #000;">
                                    </form>
                                </div>
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
                            </section>
                            </th><th>

                            <div class="form-group">
                                <h1 style="margin-left:40px;">Selecione a forma de pagamento</h1>
                                <select class="form-control" name="formPag" id="formPag">
                                    <option> Selecione... </option>
                                    <% 
                                        List<TipoPagamento> tipoPagamento = tipoPagamentoDao.list();
                                        for(int i = 0; i < tipoPagamento.size(); i++){
                                            out.println("<option value =" + tipoPagamento.get(i).getId() + ">" + tipoPagamento.get(i).getNome() + "</option>");																
                                        } %>
                                </select>
                            </div>
                            <h1 style="margin-left:40px;">Selecione o endereço de entrega</h1>
                            <%
                                List<Endereco> listaEnderecos = (List<Endereco>) request.getAttribute("enderecoList");
                                for(Endereco endereco:listaEnderecos){
                            %>
                            <hr>
                            
                                <p style="font-size: 18pt;">Selecione</>
                                    <input type="radio" id = "idEndereco" name="idEndereco" value="<%=endereco.getId()%>" style=" transform: scale(2);"/>
                                <p>Logradouro: <%=endereco.getRua()%></p>
                                <p>Número: <%=endereco.getNumeroCasa()%></p>
                                <p>Bairro: <%=endereco.getBairro()%></p>
                                <p>Complemento: <%=endereco.getComplemento()%></p>
                                <p>Cidade: <%=endereco.getCidade()%></p>
                                <p>CEP: <%=endereco.getCep()%></p>
                                
                            
                                <hr>
                                <%
                                }
                                %>


                            <form action="/marvelShopp/CadEnderecoController" method="POST" id="cadEndereco" style="margin-left:40px;">
                                <h3>Cadastrar novo endereço de entrega</h3>
                                <div class="form-group">
                                    <label for="rua">Rua: </label>
                                    <input type="text" class="form-control" name="rua" id="rua" maxlength="50" placeholder="Nome da rua" required>
                                </div>
                                <div class="form-group">
                                    <label for="numero">Número: </label>
                                    <input type="text" class="form-control" name="numero" id="numero" maxlength="50" placeholder="Número" required>
                                </div>
                                <div class="form-group">
                                    <label for="bairro">Bairro: </label>
                                    <input type="text" class="form-control" name="bairro" id="bairro" maxlength="50" placeholder="Bairro" required>
                                </div>
                                <div class="form-group">
                                    <label for="complemento">Complemento: </label>
                                    <input type="text" class="form-control" name="complemento" id="complemento" maxlength="50" placeholder="Complemento">
                                </div>
                                <div class="form-group">
                                    <label for="cidade">Cidade: </label>
                                    <input type="text" class="form-control" name="cidade" id="cidade" maxlength="50" placeholder="Cidade" required>
                                </div>
                                <div class="form-group">
                                    <label for="cep">CEP: </label>
                                    <input type="text" class="form-control" name="cep" id="cep" maxlength="50" placeholder="CEP" required>
                                </div>
                                <input type="submit" value="enviar" ID="cadEndereco" name="cadEndereco" style="width:200px; margin-left: 200px;">
                                <input type="hidden" value="<%= user.getId()%>">
                            </form>
                            </th>
                            </tr>
                        </table>
                        </br>
                        </br>
                        <input type="hidden" value="<%= user.getId()%>" id="idUser" name="idUser">
                        <input type="hidden" value="<%= carrinho.getId() %>" id="pedidoId" name="pedidoId">
                        <input type="hidden" value="finalCompra" id="finalCompra"/>
                        <input type="submit" value="Finalizar compra" class="btn-primary" id="finalCompra" style="width:400px; margin-left: 200px; margin-left: 585px;">
                    </form>    
                </section>
                
                <br/>
                </br>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
