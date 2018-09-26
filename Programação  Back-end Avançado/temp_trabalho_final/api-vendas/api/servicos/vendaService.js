const Venda = require('../model/venda')

Venda.methods(['get', 'post', 'put', 'delete'])
Venda.updateOptions({ new: true, runValidators: true })

module.exports = Venda