module.exports = {
    mostrarOperacoes: function mostrar(response, result, logado){
        var user = '';
        var pw = '';
        if(result!=null){
            user = `${result.user}`;
            pw = `${result.senha}`;
        }
        if(logado || (user == 'admin' && pw == '123')){
            //logado = true;
            response.write("<a href='/api/incluir'>Incluir candidato</a>");
            response.write("<br>");
            //response.write("<a href='/api/excluir'>Excluir candidato</a>");
            //response.write("<br>");
            response.write("<a href='/'>Sair</a>");
            response.write("<br>");
            //response.end();
           
            return true;
        }
        else{
            //logado = false;
            response.write("<h1>Falha no login.</h1>");
            response.write("<a href='/api/login'>Tentar novamente</a>");
            response.write("<br>");
            response.write("<a href='/'>Voltar</a>");
            response.write("<br>");
            //response.end();
            return false;
        }
    }
};