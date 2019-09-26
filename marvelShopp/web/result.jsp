<%-- 
    Document   : result
    Created on : 26/09/2019, 19:37:47
    Author     : victo
--%>

<%@page import="java.util.List"%>
<%@page import="br.com.marvelShopp.model.TipoSexo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
            <%  
                        List<TipoSexo> vinhos = (List<TipoSexo>) request.getAttribute("sexoLista");  
                        for (int i = 0; i < vinhos.size(); i++) {  
                            out.println(vinhos.get(i).getNome() + "<br>");  
                        }  
                    %>   
    </body>
</html>
