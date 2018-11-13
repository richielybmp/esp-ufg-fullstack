const restful = require('node-restful')
const mongoose = restful.mongoose

const alunoSchema = new mongoose.Schema({
  matricula: { type: Number, required: true },
  _id: { type: Number, required: true },
  nome: { type: String, required: true }
})

module.exports = restful.model('Aluno', alunoSchema)