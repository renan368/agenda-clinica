<%-- 
    Document   : tarefas
    Created on : 17 de mai de 2022, 20:02:59
    Author     : Jean Carlos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultas</title>
    </head>
    <body>
        <h1><font face="Comic Sans">Consultas</font></h1>
        <a href="/cadastro"><font face="Arial"> Ir Novo Cadastro</font></a>
        <hr>
        <table border="2px" width="900" bordercolor="#191970">
            <thead>
                <tr>
                    <th width="10%">Paciente</th>
                    <th width="6%">Idade</th>
                    <th width="10%">Especialidade</th>
                    <th width="6%">Data</th>
                    <th width="6%">Horário</th>
                    <th width="7%">Atendido</th>
                    <th width="16%">Opções</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${consulta}" var="consulta">
                <tr>
                    <td align="center">${consulta.paciente}</td>
                    <td align="center">${consulta.idadeAt}</td>
                    <td align="center">${consulta.especialidade}</td>
                    <td align="center">${consulta.dataStr}</dt>
                    <td align="center">${consulta.horario}</td>
                    <c:if test="${consulta.atendido}"><td align="center" bgcolor="#1E90FF">Sim</td></c:if>
                    <c:if test="${not consulta.atendido}"><td align="center">Não</td></c:if>
                    <td align="center"><a href="/edita?id=${consulta.id}">Editar</a>&nbsp;
                        <a href="/exclui?id=${consulta.id}">Excluir</a>&nbsp;
                        <c:if test="${not consulta.atendido}">
                                <a href="/atender?id=${consulta.id}">Atendido</a>
                        </c:if>
                        <c:if test="${consulta.atendido}">
                                <a href="/reabrir?id=${consulta.id}">Reabrir</a>
                        </c:if>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
