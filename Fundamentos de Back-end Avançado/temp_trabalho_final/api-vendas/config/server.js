const porta = 3000

const bodyParser = require('body-parser')
const cors = require('./cors')
const queryParser = require('express-query-int')
const express = require('express')
const server = express()

server.use(bodyParser.urlencoded({ extended: true }))
server.use(bodyParser.json())
server.use(cors)
server.use(queryParser())

server.listen(porta, function(){
    console.log(`Api-Vendas executando na porta ${porta}!`)
})

module.exports = server