const express = require('express');
const bodyParser = require('body-parser')
const app = express();
const MongoClient = require('mongodb').MongoClient;
var db;

app.use(bodyParser.urlencoded({ useNewUrlParser: true }));

MongoClient.connect('mongodb://localhost:27017/?readPreference=primary', { useNewUrlParser: true }, (err, client) => {
    if (err) return console.log(err);
    db = client.db('curso_fbea');
    app.listen(3000, function () {
        console.log('listening on 3000');
    });
})

app.delete('/delete', (req, res) => {
    db.collection('vendas').deleteOne({ _id: req.body._id }, function (err, result) {
        if (err) return console.log(err);
        res.redirect('/');
    });
});

app.put('/update', (req, res) => {
    var query = { _id: req.body._id};

    var dados = {$set: {"data": req.body.data}}

    db.collection('vendas').updateOne(query, dados ,(err, result) => {
        if (err) return console.log(err);
        res.redirect('/');
    });
});

app.post('/save', (req, res) => {
    db.collection('vendas').insertOne(req.body, (err, result) => {
        if (err) return console.log(err);
        res.redirect('/');
    });
});

app.get('/', (req, res) => {
    var cursor = db.collection('vendas').find().toArray(function (err, results) {
        res.send(results);
    })
});