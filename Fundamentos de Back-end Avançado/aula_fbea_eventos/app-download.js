const http = require('https');
const fs = require('fs');

function download(url, callBack){
    var file = fs.createWriteStream('./download.txt');
    http.get(url, (response) =>{
        response.pipe(file);
        file.on('finish', () =>{
            file.close(callBack(file.path));
        })
    })
};

module.exports = download;