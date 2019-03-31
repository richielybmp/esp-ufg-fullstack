//
//  AnotherViewController.swift
//  MyPhome
//
//  Created by Aluno on 09/03/2019.
//  Copyright © 2019 Aluno. All rights reserved.
//

import UIKit

class AnotherViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    
    @IBOutlet weak var vrImageView: UIImageView!

    @IBOutlet weak var vrPickerView: UIPickerView!
    
    var paradigmas = ["Estruturadas","Orientadas a Objetos"]
    var vetorLinguagens = [["C", "Pascal"], ["Java", "Swift", "C Sharp"]]
    
    var paradigmaSelecionado = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        vrPickerView.delegate = self
        vrPickerView.dataSource = self
        carregaImagem(nome: vetorLinguagens[paradigmaSelecionado][0])
        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func numberOfComponents(in pickerView: UIPickerView) -> Int{
        return paradigmas.count
    }
    
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int
    {
        if component == 0
        {
            return paradigmas.count
        }
        
        return vetorLinguagens[pickerView.selectedRow(inComponent: 0)].count
    }
    
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String?
    {
        if component == 0
        {
            return paradigmas[row]
        }
        else
        {
            let selecionado = pickerView.selectedRow(inComponent: 0)
            
            return vetorLinguagens[selecionado][row]
        }
    }
    
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if component == 0
        {
            pickerView.reloadComponent(1)
            pickerView.selectRow(0, inComponent: 1, animated: true)
            
            let selecionado = pickerView.selectedRow(inComponent: 0)
            carregaImagem(nome: vetorLinguagens[selecionado][0])
            return
        }
        
        let selecionado = pickerView.selectedRow(inComponent: 0)
        carregaImagem(nome: vetorLinguagens[selecionado][row])
        return
    }
    
    private func carregaImagem(nome:String)
    {
        vrImageView.image = UIImage(named: nome)
    }
    
}
