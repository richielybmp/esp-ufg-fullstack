//
//  ViewController.swift
//  MyPhome
//
//  Created by Aluno on 09/03/2019.
//  Copyright © 2019 Aluno. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var vrLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        print("TELA 1 CARREGADA")
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    override func viewWillAppear(_ animated: Bool) {
        print("A TELA 1 ESTA PRONTA MAS NAO ESTA VISIVEL")
    }

    override func viewDidAppear(_ animated: Bool) {
        print("A TELA 1 JA ESTA VISIVEL AO USUARIO")
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        print("A TELA 1 IRÁ DESAPARECER")
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        print("A TELA 1 DESAPARECEU")
    }
    
    @IBAction func alterarTexto(_ sender: UIButton) {
        vrLabel.text = "Olá, Mundo"
    }
}
