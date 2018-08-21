const osInfo = require('./app-os');
const printer = require('./app-printer');

var infoMaquina = [ osInfo.getNome(), 
                    osInfo.getFreeMem(),
                    osInfo.getCpus(),
                    osInfo.getPlatform()];

printer(infoMaquina);