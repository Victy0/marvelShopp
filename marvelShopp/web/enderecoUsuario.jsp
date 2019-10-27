<%-- 
    Document   : enderecoUsuario
    Created on : 27/10/2019, 18:58:59
    Author     : Victor
--%>

<%@page import="br.com.marvelShopp.model.Endereco"%>
<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.dao.EnderecoDao"%>
<%@page import="br.com.marvelShopp.model.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Marvel Shopp</title>
        <link rel="icon" type="imagem/png" href="imagens/deadpoolLogo.png" />
    </head>
    <% Usuario loginUser = (Usuario)request.getSession().getAttribute("user");
        EnderecoDao enderecoDao = new EnderecoDao();
        List<Endereco> lista = enderecoDao.list(loginUser.getId().toString());
           int i =1;%>
        <div id="interface">
            <%@ include file="header.jsp"%>
            <section id="corpo">
                 <h1 id="titulo" align="center">Endereços</h1>
                    <% if (lista.isEmpty()){%>
                    <div align="center"><h1 style="color: red;">NENHUM ENDEREÇO CADASTRADO!!!</h1></div><br><br>
                    <%}else{%>
                    <table class="table">
                        <thead class="thead-dark">
                          <tr>
                            <th scope="col">#</th>
                            <th scope="col">Logradouro</th>
                            <th scope="col">Número</th>
                            <th scope="col">Bairro</th>
                            <th scope="col">Complemento</th>
                            <th scope="col">Cidade</th>
                            <th scope="col">CEP</th>
                            <th scope="col">+ Detalhes</th>
                          </tr>
                        </thead>
                        <tbody>
                          <% for(Endereco endereco : lista ){ %>  
                          <tr>
                            <th scope="row" ><%=i++%></th>
                            <td><%=endereco.getRua()%></td>
                            <td><%=endereco.getNumeroCasa()%></td>
                            <td><%=endereco.getBairro()%></td>
                            <td><%=endereco.getComplemento()%></td>
                            <td><%=endereco.getCidade()%></td>
                            <td><%=endereco.getCep()%></td>
                            <td><form action="CadEnderecoController?enderecoId=<%=endereco.getId()%>&acao=delete" method="POST"><input type="submit" class="btn btn-primary" value="Excluir" style="width:70px;"></form></td>
                          </tr>
                          <%}%>
                        </tbody>
                    </table>
                        <center> 
                    <div style="width: 400px;">
                    <form action="/marvelShopp/CadEnderecoController?acao=create" method="POST" id="cadEndereco">
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
                        <input type="submit" class="btn-primary" value="Enviar" ID="cadEndereco" name="cadEndereco" style="width:200px; margin-left: 200px;">
                        <input type="hidden" value="<%= loginUser.getId()%>">
                    </form>
                    </div>
                    </center>
                        <br><br>
                    <%}%>
            </section>
            <%@ include file="footer.jsp"%>
        </div>
</html>
