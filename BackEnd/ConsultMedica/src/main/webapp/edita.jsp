<%-- 
    Document   : cadastro
    Created on : 17 de mai de 2022, 20:02:43
    Author     : Jean Carlos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar</title>
    </head>
    <body>
        <h1>Editar Consulta</h1>
        <fieldset>
            <legend>Aleração</legend>
            <form action="/cadastro" method="post">
            <input type="hidden" value="${consulta.id}" name="id"/>
                <ul>
                    <li>
                        <label for="paciente">Paciente:</label>
                        <input id="paciente" value="${consulta.paciente}" type="text" name="paciente"/>
                    </li>
                    <br>
                    <li>
                        <label for="idadeAt">Idade:</label>
                        <input id="idadeAt" value="${consulta.idadeAt}" type="text" name="idadeAt"/>
                    </li>
                    <br>
                    <li>
                        <label for="especialidade">Especialidade:</label>
                        <input id="especialidade" value="${consulta.especialidade}" type="text" name="especialidade"/>
                    </li>
                    <br>
                    <li>
                        <label for="dataStr">Data:</label>
                        <input id="dataStr" type="text" value="${consulta.dataStr}"name="dataStr"/>
                    </li>
                    <br>
                    <li>
                        <label for="horario">Horário:</label>
                        <select id="horario" name="horario"/>
                        <option value="07:00" <c:if test="${consulta.horario eq '07:00'}">selected</c:if>>07:00</option>
                        <option value="08:00" <c:if test="${consulta.horario eq '08:00'}">selected</c:if>>08:00</option>
                        <option value="09:00" <c:if test="${consulta.horario eq '09:00'}">selected</c:if>>09:00</option>
                        <option value="10:00" <c:if test="${consulta.horario eq '10:00'}">selected</c:if>>10:00</option>
                        <option value="11:00" <c:if test="${consulta.horario eq '11:00'}">selected</c:if>>11:00</option>
                        <option value="12:00" <c:if test="${consulta.horario eq '12:00'}">selected</c:if>>12:00</option>
                        <option value="14:00" <c:if test="${consulta.horario eq '14:00'}">selected</c:if>>14:00</option>
                        <option value="15:00" <c:if test="${consulta.horario eq '15:00'}">selected</c:if>>15:00</option>
                        <option value="16:00" <c:if test="${consulta.horario eq '16:00'}">selected</c:if>>16:00</option>
                        <option value="17:00" <c:if test="${consulta.horario eq '17:00'}">selected</c:if>>17:00</option>
                    </li>
                </ul>
                <input type="submit" value="Salvar"/>
            </form>
        </fieldset>
    </body>
</html>
