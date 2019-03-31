//
//  TableViewController.swift
//  MyPhome
//
//  Created by Aluno on 22/03/2019.
//  Copyright © 2019 Aluno. All rights reserved.
//

import UIKit

class CardapioViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    let dataBase = DataBase()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "Cardápio"
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return dataBase.cardapio.count
    }
    
    func tableView(_ tableView: UITableView, titleForHeaderInSection section: Int) -> String? {
        return dataBase.retornaSecao(numero: section)
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return dataBase.itensCardapio[section].count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        // os outlets estao na TableViewCellcontroller
        let celula = tableView.dequeueReusableCell(withIdentifier: "celula") as! TableViewCellController
        let item = dataBase.retornaItemSecao(secao: indexPath.section, item: indexPath.row)
        celula.vrImageView.image = UIImage(named: item)
        celula.vrLabel.text = item
        return celula
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let item = dataBase.retornaItemSecao(secao: indexPath.section, item: indexPath.row)
        
        let proxTela = storyboard?.instantiateViewController(withIdentifier: "telaDetalhes") as! ViewControllerDetalhe
        
        proxTela.selectedItem = item
        
        self.navigationController?.pushViewController(proxTela, animated: true)
        
      }
    
   
}
