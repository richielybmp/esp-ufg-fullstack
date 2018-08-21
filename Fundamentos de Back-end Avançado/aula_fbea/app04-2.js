var url = 'http://meuservidorlog.com.br'

function log(mensagem){
    // Faz log remoto via http
    console.log(mensagem);
}

function log2(mensagem){
    // Faz log remoto via http
    console.log(mensagem + "2");
}

// expõe somente a função
 module.exports.logar = log;
// module.exports.logar2 = log2;

// pode acessar diretamente com o nome do pacote requerido
//module.exports = log;
