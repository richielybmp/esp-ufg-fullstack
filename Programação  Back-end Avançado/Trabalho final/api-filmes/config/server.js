const app = require('../src/app')
const http = require('http')
const debug = require('debug')('nodestr:server');

const porta = normalizePort(process.env.PORT || 3000);

//seta a porta para o servidor
app.set('port', porta)

//cria o servidor e a constante para a ciração das rotas pelo express
const server = http.createServer(app);

server.listen(porta, function(){
    console.log(`Api-Filmes executando na porta ${porta}!`);
});
server.on('error', onError);
server.on('listening', onListening);

function normalizePort(val){
    const port = parseInt(val, 10);
    if(isNaN(port)){
        return val;
    }
    if(port >= 0){
        return port;
    }
    return false;
}

function onError(error){
    if(error.syscall !== 'listen'){
        throw error;
    }
    const bind = typeof porta === 'string' ?
        'Pipe ' + porta :
        'Port ' + porta;

    switch(error.code){
        case 'EACCES':
            console.error(bind + ' requires elevated privileges');
            process.exit(1);
            break;
        case 'EADDRINUSE':
            console.error(bind + ' is already in use');
            process.exit(1);
            break;
        default:
            throw error;
    }
}

function onListening(){
    const addr = server.address();
    const bind = typeof addr === 'string'
        ? 'pipe ' + addr
        : 'port ' + addr.port;
    debug('Listening on '+ bind);
}