function print(obj){
    obj.forEach(function(element) {
        console.log(element.Nome + ": ");
        console.log(element.Info);
        console.log();
    }, this);
}

module.exports = print;