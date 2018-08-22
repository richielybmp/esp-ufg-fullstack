

module.exports = {
    incluir: function incluir(response){
        response.writeHead(200 ,{"Content-Type": "text/html; charset=utf-8"});
        response.write("<h1>Adicionar novo candidato.</h1>");
        response.write("<form action='/api/incluir' method='POST'>");
        response.write
        (`
            Nome:<br>
            <input type="text" name="nome" value="">
            <br>
            Número:<br>
            <input type="text" name="numero" value="">
            <br><br>
            <input type="submit" value="Adicionar">
        `);
        response.write("<br>");
        response.write("<a href='/'>Voltar</a>");
        response.write("<br>");
        response.write("</form>");
        response.end();
    }
}   