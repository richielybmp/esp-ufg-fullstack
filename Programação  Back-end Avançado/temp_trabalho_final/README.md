# Trabalho final - Fundamentos de Back-end Avançado

Este repositório é dedicado para o trabalho final da disciplina de FBEA.
O aplicativo consiste em dois microserviços que se comunicam. Cada microserviço possui seu banco de dados independente e é capaz de consumir recursos do outro microserviço.

## Executando o Microseviço

### Iniciando o Mongo
`mongod`

### Instalando dependencias
`npm install`

## Executanto em modo *dev*
`npm run dev`

## Acessando o serviço
Acesse o endereço `http://localhost:3000/api/vendas`

Acesse o endereço para obter dados de outro microserviço `http://localhost:3000/api/segurosService`