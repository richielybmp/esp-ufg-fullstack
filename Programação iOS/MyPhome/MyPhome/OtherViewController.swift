//
//  OtherViewController.swift
//  MyPhome
//
//  Created by Aluno on 09/03/2019.
//  Copyright © 2019 Aluno. All rights reserved.
//

import UIKit

class OtherViewController: UIViewController {

    @IBOutlet weak var vrCampoDeTexto: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        print("TELA 2 CARREGADA")
    }
    
    
    @IBAction func voltar(_ sender: Any) {
        self.dismiss(animated: true, completion: nil)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func viewWillAppear(_ animated: Bool) {
        print("A TELA 2 ESTA PRONTA MAS NAO ESTA VISIVEL")
    }
    
    override func viewDidAppear(_ animated: Bool) {
        print("A TELA 2 JA ESTA VISIVEL AO USUARIO")
    }
    
    override func viewWillDisappear(_ animated: Bool) {
        print("A TELA 2 IRÁ DESAPARECER")
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        print("A TELA 2 DESAPARECEU")
    }

    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?)
    {
        // sumir com o teclado
        vrCampoDeTexto.resignFirstResponder()
    }
}
