var Filme = require('../src/models/filme');
var Review = require('../src/models/review')

module.exports = class FilmeService {
    
    static addFilme(filmeObj, callback){
        console.log(filmeObj);
        Filme.create(filmeObj, callback);
    }

    static obtenhaFilmes(callback){
        Filme.find({}, callback);
    }

    static obtenhaFilme(id, callback){
        Filme.findById(id, callback)
    }

    static atualizeFilme(id, documentoAtualizado ,callback){
        Filme.findByIdAndUpdate( { "_id" : id }, documentoAtualizado , callback)
    }

    static removaFilme(id, callback){
        Filme.deleteOne(id, callback)
    }

    static addReview(id, review, callback){
        const novoReview = new Review({
            idFilme: id,
            usuario: review.user,
            comentario: review.review,
            data: Date.now()       
        });

        Filme.findByIdAndUpdate( { "_id" : id }, { $push: { "reviews" : novoReview } }, callback)
    }
}