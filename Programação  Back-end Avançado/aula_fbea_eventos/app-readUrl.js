const emissorDeEvento = require('./app-HandlerEventos');

var url = process.argv[2];

if(url != null || url != undefined){
    emissorDeEvento.emit('iniciarDownload', url);
}
else {
    console.log('Atenção!!! Não foi possível realizar o download!')
    console.log('Informe a url como parametro na chamada do aplitativo.');
    console.log('Ex.: node app-readUrl https://www.google.com');
}