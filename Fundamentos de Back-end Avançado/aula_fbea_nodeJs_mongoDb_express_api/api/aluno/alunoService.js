const Aluno = require('./aluno')

Aluno.methods(['get', 'post', 'put', 'delete'])
Aluno.updateOptions({new: true, runValidators: true})

module.exports = Aluno