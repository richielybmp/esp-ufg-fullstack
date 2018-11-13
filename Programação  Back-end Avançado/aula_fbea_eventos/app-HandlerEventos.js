// modulos existentes
const fs = require('fs');
const Events = require('events');

// modulos criados
const download = require('./app-download');
const print = require('./app-ImprimaArquivo');

// emissor de eventos
const emissor = new Events();

emissor.on('iniciarDownload', (url) => {
    console.log('*****  Iniciando seu download  *****');
    download(url, (filePath) =>{
        emissor.emit('downloadFinalizado',filePath);
    });
});

emissor.on('downloadFinalizado', (filePath) => {
    console.log();
    console.log("*****  Download finalizado *****");
    fs.readFile(filePath, 'utf-8', print);
});

module.exports = emissor;