const os = require('os');

class Informacao {
    constructor(nome, info){
        this.Nome = nome;
        this.Info = info;
    }
}

module.exports = {
    getNome: function getNome(){
        return new Informacao('Nome', os.hostname());
    },

    getFreeMem: function getFreeMem(){
        return new Informacao('Quantidade de memória livre', os.freemem());
    },

    getCpus: function getCpus(){
        return new Informacao('Informações de Cpu', os.cpus());
    },

    getPlatform: function getPlatform(){
        return new Informacao('Plataforma', os.platform());
    }
};
