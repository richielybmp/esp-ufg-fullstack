const roteadorPadrao = require('./routes')
const roteadorVendas = require('./routerVendas')

module.exports =  function (server){
    server.use('/', roteadorPadrao)

    server.get('/', function(req, res){
    res.json({mensagem: "Api de vendas de automóveis está executando. Acesso a rota '/vendas' para listar as vendas "+
                        "ou '/segurosService' para listar as apólices de seguros.' "})
    })

    server.use('/api', roteadorPadrao)
    server.use('/api/vendas', roteadorVendas)
}