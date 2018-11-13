'use strict'

const express = require('express')
const router = express.Router();

//criar primeira rota como default
router.get('/', (req, res, next) => {
    res.status(200).send({
        title: 'Node Filmes API',
        version: "0.0.1"
    });
})

module.exports = router;