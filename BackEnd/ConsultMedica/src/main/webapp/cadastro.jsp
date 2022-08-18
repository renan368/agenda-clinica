<%-- 
    Document   : cadastro
    Created on : 17 de mai de 2022, 20:02:43
    Author     : Jean Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <h1>Consultas</h1>
        <fieldset>
            <legend>Cadastro</legend>
            <form action="/cadastro" method="post">
                <ul>
                    <li>
                        <label for="paciente">Paciente:</label>
                        <input id="paciente" type="text" name="paciente"/>
                    </li>
                    <br>
                    <li>
                        <label for="idadeAt">Idade:</label>
                        <input id="idadeAt" type="text" name="idadeAt"/>
                    </li>
                    <br>
                    <li>
                        <label for="especialidade">Especialidade:</label>
                        <input id="especialidade" type="text" name="especialidade"/>
                    </li>
                    <br>
                    <li>
                        <label for="dataStr">Data:</label>
                        <input id="dataStr" type="text" name="dataStr"/>
                    </li>
                    <br>
                    <li>
                        <label for="horario">Horário:</label>
                        <select id="horario" name="horario"/>
                        <option value="07:00">07:00</option>
                        <option value="08:00">08:00</option>
                        <option value="09:00">09:00</option>
                        <option value="10:00">10:00</option>
                        <option value="11:00">11:00</option>
                        <option value="12:00">12:00</option>
                        <option value="12:00">14:00</option>
                        <option value="12:00">15:00</option> 
                        <option value="12:00">16:00</option>
                        <option value="12:00">17:00</option>
                    </li>
                </ul>
                <input type="submit" value="Salvar"/>
            </form>
        </fieldset>
    </body>
</html>
