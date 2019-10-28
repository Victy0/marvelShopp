<%-- 
    Document   : pedidosUsuario
    Created on : 27/10/2019, 20:40:28
    Author     : Victor
--%>

<%@page import="br.com.marvelShopp.model.Item"%>
<%@page import="br.com.marvelShopp.dao.CarrinhoDao"%>
<%@page import="br.com.marvelShopp.model.Carrinho"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marvel Shopp</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png"/>
    </head>
    <body>
        <% Usuario loginUser = (Usuario)request.getSession().getAttribute("user");
        CarrinhoDao carrinhoDao = new CarrinhoDao();
        List<Carrinho> lista = carrinhoDao.listPedidos(loginUser);
        Double totalPreco = 0.0;%>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <section id="corpo">
                <h1 id="titulo" align="center">Meus Pedidos</h1>
                <% if (lista.isEmpty()){%>
                    <div align="center"><h1 style="color: red;">NENHUM PEDIDO CADASTRADO!!!</h1></div><br><br>
                    <%}else{%>
                    <table class="table">
                        <thead class="thead-dark">
                          <tr>
                            <th scope="col">Num Pedido</th>
                            <th scope="col">itens</th>
                            <th scope="col">Preço pago</th>
                            <th scope="col">Pagamento</th>
                            <th scope="col">Data</th>
                            <th scope="col">Endereço</th>
                            <th scope="col">Status</th>
                          </tr>
                        </thead>
                        <tbody>
                          <% for(Carrinho carrinho : lista ){ %>  
                          <tr>
                            <th scope="row" ><%=carrinho.getId()%></th>
                            <td><%for(Item item : carrinho.getItens() ){
                                totalPreco += item.getPersonagem().getPreco() + item.getQtd();
                                out.print(item.getPersonagem().getIdentidade()+" | "+item.getQtd()+"<br>");
                            }%></td>
                            <td>R$ <%=String.format("%.2f", totalPreco)%></td>
                            <td><%=carrinho.getPagamento().getNome()%></td>
                            <td><%=carrinho.getDtConfirmacao()%></td>
                            <td><%=carrinho.getEndereco().getRua()%>, <%=carrinho.getEndereco().getNumeroCasa()%> </td>
                            <td><%=carrinho.getStatus()%></td>
                          </tr>
                          <%}%>
                        </tbody>
                    </table>
                    <%}%>
                <br><br>
            </section>
            <%@ include file="footer.jsp"%>
        </div>
    </body>
</html>
