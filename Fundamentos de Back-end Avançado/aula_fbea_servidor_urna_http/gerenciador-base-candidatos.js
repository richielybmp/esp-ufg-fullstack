const fs = require('fs');
const readline = require('readline');
const os = require('os');

module.exports = {
    salvar: function salvar(nome, numero){
        var dado = nome + ',' + numero;

        fs.open('./candidatos', 'a', 666, function( e, id ) {
            fs.write( id, dado + os.EOL, null, 'utf8', function(){
                fs.close(id, function(){
                    console.log('Candidato salvo com sucesso');
                });
            });
        });
    },

    excluir: function excluir(numExcluir){
        var rs = fs.createReadStream('./candidatos');

        var leitor = readline.createInterface({
            input: rs
        });
        leitor.on('line', function (line) {
            var escritor = fs.createWriteStream("./temp", {flags : 'a'});
            var numero = line.split(',')[1];

            if(numExcluir != numero){
                escritor.write(line + os.EOL);
            }
            escritor.end();
        }).on('close', () => {
            fs.createReadStream('./temp').pipe(fs.createWriteStream('./candidatos'));
            fs.unlink('./temp', () => {});
        });
    },

    listar: function listarCandidatos(response, ehVotar){
        response.writeHead(200 ,{"Content-Type": "text/html; charset=utf-8"});
        var leitor = readline.createInterface({
            input: fs.createReadStream("./candidatos")
        });
        leitor.on('line', function (line) {
            var nome = line.split(',')[0];
            var numero = line.split(',')[1];
            
            if((nome != "" && nome != null && nome != undefined) || (numero != "" && numero != null && numero != undefined)){
                response.write(`<div> Nome: `+ nome + ` | Número: `+ numero);
                if(!ehVotar){
                    response.write(`----------- <a href='/api/excluir/`+numero+`'>Excluir</a>`);
                }
                response.write("</div>");
            }
        });
    },

    contabilizarVoto: function contabilizarVoto(response, num_voto, callback){
        var rs = fs.createReadStream('./candidatos');

        var leitor = readline.createInterface({
            input: rs
        });
        leitor.on('line', function (line) {
            var escritor = fs.createWriteStream("./votos", {flags : 'a'});
            var nome = line.split(',')[0];
            var numero = line.split(',')[1];

            if(num_voto == numero){
                line = nome + ',' + numero + os.EOL;
                escritor.write(nome + os.EOL);
                if(callback){
                    callback(response);
                }
            }
            escritor.end();
        });
    },

    mostrarPorcentagem: function mostrarPorcentagem(response){
        //ler o arquivo, contabilizar a quantidade de linhas e contabilizar a ocorrencia de cada voto
        var rs = fs.createReadStream('./votos');
        var totalVotos = 0;
        var associacao = {};
        var leitor = readline.createInterface({
            input: rs
        });
        leitor.on('line', function (candidato) {
            totalVotos++;
            if (associacao[candidato] == null){
                associacao[candidato] = 1;
            } 
            else{
                associacao[candidato]++;
            }
        }).on('close', ()=>{
            Object.keys(associacao).forEach(candidato => {
                response.write(`
                    <div>`+ candidato +` - ` + associacao[candidato] + ` votos - 
                    `+ (associacao[candidato] / totalVotos)*100 +` %
                    </div>
                `);
            });
            response.end();
        });
    }
}