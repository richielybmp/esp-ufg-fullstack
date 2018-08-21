function imprima(erro, data){
    if (erro){
        console.log("Aconteceu algum erro: " + erro);
    }
    else{
        console.log(JSON.stringify(data));
    }
}

module.exports = imprima;