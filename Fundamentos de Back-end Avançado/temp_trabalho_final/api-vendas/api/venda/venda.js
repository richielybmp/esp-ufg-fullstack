const mongoose = require('./restful-model')
const Apolice = require('./apolice')

const vendaSchema = new mongoose.model.Schema
({
    modelo:
        {
            type: String,
            required: true
        },
    valor:
        {
            type: Number,
            required: true
        },
    vendedor:
        {
            type: String, 
            required: true
        },
    comprador:
        {
            type: String, 
            required: true
        },
    data:
        {
            type: Date,
            default: Date.now,
            required: true
        },
    apolice:
        {
            type:  {type: mongoose.model.Schema.Types.ObjectId, ref: 'Apolice'},
        }
})

module.exports = mongoose.restful.model('Venda', vendaSchema)