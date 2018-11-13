const express = require('express')
const request = require('request')

module.exports = function(server) {

  const router = express.Router()
  server.use('/api', router)

  const alunoService = require('../api/aluno/alunoService')
  alunoService.register(router, '/alunos')

  server.route('/api/func').get((req,res) => {
    console.log(req);
    
    var url ='http://localhost:8080/Atividade_FPW/webresources/funcionarios/'
    request(url, (error, res2, body) =>{
        res.send(res2.body)
    })
  })
}