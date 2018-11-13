const mongoose = require('../restful/restful-model')

const apoliceSchema = new mongoose.model.Schema
({
    inicio: 
        {
            type: Date,
            default: Date.now
        },
    seguradora:
        {
            type: String,
            required: true
        },
    valorDaApolice:
        {
            type: Number,
            required: true
        }
})

module.exports =  mongoose.restful.model('Apolice', apoliceSchema)