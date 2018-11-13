//biblioteca que auxilia na conversão do corpo das requisições para padrão ideal para js
const express = require('express')
const app = express();

/**************** CARREGAR ROTAS *****************/
const indexRoute = require('./routes/index-route')
const filmesRoute = require('./routes/filme-router')

/**************** Prepara todas as requisições com o body parser *****************/
const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

/**************** Prepara a utilização do query parser *****************/
const queryParser = require('express-query-int')
app.use(queryParser())

/**************** Prepara rotas default *****************/
app.use('/api', indexRoute);
app.use('/api/filmes', filmesRoute);

module.exports = app;


