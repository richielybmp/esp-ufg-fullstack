const http = require('http');
const { parse } = require('querystring');

const login = require('./login-controller');
const controlador = require('./candidatos-controller');
const operacoes = require('./operacoes-controller');
const gerenciador = require('./gerenciador-base-candidatos');

const porta = 8081;
var logado = false;

http.createServer((request, response)=>{
    var url = request.url;
    if(url === '/'){
        logado = false;
        response.write("<h1>SISTEMA DE GERENCIAMENTO ELEITORAL</h1>");
        if(!logado){
            response.write("<a href='/api/login'>Login</a>");
            response.write("<br>");
        }
        else{
            response.write("<a href='/api/operacoes'>Operações</a>");
            response.write("<br>");
        }
        response.write("<a href='/api/votar'>Votar</a>");
        response.write("<br>");
        response.end();
    }
    
    if(url === '/api/login'){
        // se não estiver logado, abre o form de login
        if(!logado){
            login.login(response);
        }
        else{
            // response.writeHead(200 ,{"Content-Type": "text/html; charset=utf-8"});
            // response.write("<h1>Você já está logado.</h1>");
            // response.write("<br>");
            // response.write("<a href='/'>Voltar</a>");
            // response.end();
            gerenciador.listar(response);
        }
    }

    if(url === '/api/operacoes'){
        if (request.method === 'POST') {
            collectRequestData(request, result => {
                logado = operacoes.mostrarOperacoes(response, result, false);
            });
            gerenciador.listar(response, false);
        }
        else if(logado){
            operacoes.mostrarOperacoes(response, null, logado);
            gerenciador.listar(response, false);
        }else{
            response.end();
        }
    }
    
    if(url === '/api/votar'){
        if (request.method === 'POST'){
            collectRequestData(request, result => {
                response.writeHead(200 ,{"Content-Type": "text/html; charset=utf-8"});
                response.write(`<div>Voto no número `+ result.numero +`</div>`);
                response.write("<a href='/'>Voltar</a>");
                gerenciador.contabilizarVoto(response, result.numero, ()=>{
                    gerenciador.mostrarPorcentagem(response);
                });
            });
        }
        else {
            response.writeHead(200 ,{"Content-Type": "text/html; charset=utf-8"});
            response.write("<h1>VOTAÇÂO.</h1>");
            response.write("<form action='/api/votar' method='POST'>");
            response.write
            (`
                Número do candidato:<br>
                <input type="text" name="numero">
                <br>
                <input type="submit" value="Confirmar">
            `);
            response.write("</form>");
            response.write("<a href='/'>Voltar</a>");
            response.end();
        }
    }

    
    if(url === '/api/incluir'){
        if (request.method === 'POST' && logado) {
            collectRequestData(request, result => {
                var nome = `${result.nome}`;
                var numero = `${result.numero}`;
                gerenciador.salvar(nome, numero);
                response.write("<h1>Candidado inserido com sucesso: "+ numero +" - "+ nome + "</h1>");
                response.write("<a href='/api/incluir'>Incluir candidato</a>");
                response.write("<br>");
                response.end();
            });
        }
        else if(logado){
            controlador.incluir(response);
        }
    }
    
    if (url.indexOf('/api/excluir') > -1 ){
        var numero = url.split('/')[3];
        response.write("Excluir candidato cadastrado " + numero);
        gerenciador.excluir(numero);
        response.end();
    }

}).listen(porta);

console.log('Servidor eleitoral iniciado na porta ' + porta);

function collectRequestData(request, callback) {
    let body = '';
    request.on('data', chunk => {
        body += chunk.toString();
    });
    request.on('end', () => {
        callback(parse(body));
    });
}