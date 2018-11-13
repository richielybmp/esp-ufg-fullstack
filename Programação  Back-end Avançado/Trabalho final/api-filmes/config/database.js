const mongoose = require('mongoose')
const dbName = 'db_apifilmes'

mongoose.connect('mongodb://admin:dbadmin1@ds115758.mlab.com:15758/db_apifilmes', { useNewUrlParser: true })

const db = mongoose.connection;

db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {
  console.log(`Conectado no banco de dados ${dbName}`);
});
