'use strict';
// FilmeController.js
const express = require('express');
const router = express.Router();
const controller = require('../controllers/filme-controller');

// GET - Lista todos os filmes existentes no banco de dados.
router.get('/', controller.getAll);

// GET - retorna o filme de determinado ID.
router.get('/:id', controller.find);

// GET - retorna a quantidade de ingressos vendidos para um determinado filme.
router.get('/bilheteriaTotal/:id', controller.getTotalVendas);

// POST - Criar novo registro filme no banco de dados.
router.post('/', controller.create);

// PUT - Atualizar informações do filme no banco de dados.
router.put('/:id', controller.update);

// DELETE - Excluir filme do banco de dados.
router.delete('/:id', controller.delete);

// POST - Adicionar um review ao filme específico.
router.post("/novoReview/:id", controller.inserirReview);

module.exports = router;
