const mongoose = require('mongoose')
const dbName = 'db_apiVendas'

mongoose.connect('mongodb://localhost/'+ dbName, { useNewUrlParser: true })

var db = mongoose.connection;

db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {
  console.log(`Conectado no banco de dados ${dbName}`)
});