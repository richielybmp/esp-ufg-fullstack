module.exports = function(){
    const vendaService = require('../../api/servicos/vendaService')
    vendaService.register(roteador, '/vendas')

    // const microservico = server.route('/api/segurosService')
    // microservico.get(function(req, res){
        
    //     // url de teste de chamada de outra api
    //     // SUBSTITUIR A URL para a URL do outro microserviço 
    //     // Não sei se a ideia é essa, estou apenas testando o registro de rota.
    //     var url = 'https://jsonplaceholder.typicode.com/todos/'
    //     request(url, function(error, response, body){
    //         res.send(response.body)
    //         console.log(response.body)
    //     })
    // })
}