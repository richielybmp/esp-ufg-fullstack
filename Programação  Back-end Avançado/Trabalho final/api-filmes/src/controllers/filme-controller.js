// FilmeController.js

var FilmeService = require('../../services/filmeService')
var request = require("request");

// GET - Lista todos os filmes existentes no banco de dados.
exports.getAll = (req, res, next) => {
    FilmeService.obtenhaFilmes((erro, filmes) => {
        if (erro)
            return res.status(500).send("Ocorreu um problema ao tentar localizar um filme." + erro);
         res.status(200).send(filmes);
    });
};

// GET - Lista todos os filmes existentes no banco de dados.
exports.find = (req, res, next) => {
    const id = req.params.id;
    FilmeService.obtenhaFilme(id, (erro, filme) => {
        if (erro)
            return res.status(404).send("Ocorreu um problema ao tentar localizar um filme." + erro);
        res.status(200).send(filme);
    });
};

// POST - Criar novo registro filme no banco de dados
exports.create = (req, res, next) => {
    // passando o req.body, temos os dados do formulário em forma de objeto formatado pois estamos utilizando o body-parser.
    FilmeService.addFilme(req.body, (erro, filme) =>{
        if (erro)
            return res.status(500).send("Ocorreu um erro ao tentar adicionar o Filme no banco de dados." + erro);
        res.status(200).send(`${filme.titulo} adicionado com sucesso!`);
    });
};

exports.update = (req, res, next) =>{
    const id = req.params.id;
    FilmeService.atualizeFilme(id, req.body, (erro) =>{
        if (erro)
            return res.status(500).send("Ocorreu um erro ao tentar atualizar o Filme do banco de dados." + erro);
        res.status(200).send("Filme atualizado com sucesso!");
    });
};

exports.delete = (req, res, next) =>{
    const id = req.params.id;
    FilmeService.removaFilme(id, (erro) =>{
        if (erro)
            return res.status(500).send("Ocorreu um erro ao tentar remover o Filme do banco de dados." + erro);
        res.status(200).send("Filme removido com sucesso!");
    });
};

exports.inserirReview = (req, res, next) => {
    const id = req.params.id;

    FilmeService.addReview(id, req.body, (erro) =>{
        if(erro)
            return res.status(500).send("Ocorreu um erro ao tentar adicionar um review no filme de id " + id + ". Erro:\n " + erro);
        res.status(200).send("Review adicionado com sucesso!");
    });
};

exports.getTotalVendas = (req, res, next) =>{
    //atenção : caso a chamada não funcione verifique a porta da api php
    var url = 'http://localhost:80/api-ri/ingressos/vendidos?id_filme=' + req.params.id;
    
    request(url, function (error, response, body) {
        if (!error && response.statusCode === 200) {
            res.status(200).json(JSON.parse(body));
        }
    })
};
