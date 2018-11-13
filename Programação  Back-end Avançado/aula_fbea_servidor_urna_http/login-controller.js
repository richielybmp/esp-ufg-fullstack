module.exports = {
    login: function login(response){
        response.writeHead(200 ,{"Content-Type": "text/html; charset=utf-8"});
        response.write("<h1>Realizar login no sistema.</h1>");
        response.write("<form action='/api/operacoes' method='POST'>");
        response.write
        (`
            Usuário:<br>
            <input type="text" name="user" value="">
            <br>
            Senha:<br>
            <input type="password" name="senha" value="">
            <br><br>
            <input type="submit" value="Entrar">
        `);
        response.write("</form>");
        response.end();
    }
}