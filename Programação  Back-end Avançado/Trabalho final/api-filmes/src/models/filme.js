const mongoose = require('mongoose');  
const ReviewSchema = require('./review')

const FilmeSchema = new mongoose.Schema({  
  titulo: String,
  diretor: String,
  genero: String,
  ano: Date,
  reviews: [ReviewSchema.schema]
});

mongoose.model('Filme', FilmeSchema);
module.exports = mongoose.model('Filme');