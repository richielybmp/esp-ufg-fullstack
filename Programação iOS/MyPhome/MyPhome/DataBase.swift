//
//  DataBase.swift
//  MyPhome
//
//  Created by Aluno on 22/03/2019.
//  Copyright © 2019 Aluno. All rights reserved.
//

import Foundation

class DataBase
{
    var cardapio = ["Pizzas", "Bebidas", "Sobremesa"]
    
    var itensCardapio = [["Calabresa", "California", "Mussarela", "Portuguesa", "Quatro Queijos"], ["Cervejas", "Vinhos", "Sucos"], ["Salada de Frutas", "Sorvete", "Torta Doce"]]
    
    func retornaSecao(numero:Int) -> String
    {
        return cardapio[numero]
    }
    
    func retornaItemSecao(secao:Int, item:Int) -> String
    {
        return itensCardapio[secao][item]
    }
}
