//
//  IMCViewController.swift
//  MyPhome
//
//  Created by Aluno on 09/03/2019.
//  Copyright © 2019 Aluno. All rights reserved.
//

import UIKit

class IMCViewController: UIViewController {

   @IBOutlet weak var vrPeso: UITextField!
    
   @IBOutlet weak var vrAltura: UITextField!
    
    @IBOutlet weak var vrResultadoIMC: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func calculaIMC(_ sender: Any) {
        let peso:Float! = Float(vrPeso.text!)
        let altura:Float! = Float(vrAltura.text!)
        
        let imc:Float! = peso / (altura * altura)
        
        if imc < 17
        {
            vrResultadoIMC.text = "Muito abaixo do peso 👎🏼"
        }
        else if imc >= 17 && imc < 18.49
        {
            vrResultadoIMC.text = "Abaixo do peso 🤨"
        }
        else if imc >= 18.5 && imc < 24.99
        {
            vrResultadoIMC.text = "Peso normal 😁"
        }
        else if imc >= 25 && imc < 29.99
        {
            vrResultadoIMC.text = "Acima do peso 😬"
        }
        else if imc >= 30 && imc < 34.99
        {
            vrResultadoIMC.text = "Obesidade I 😨"
        }
        else if imc >= 35 && imc < 39.99
        {
            vrResultadoIMC.text = "Obesidade II (severa) 😱"
        }
        else if imc < 40.0
        {
            vrResultadoIMC.text = "Obesidade III (mórbida) ☠️"
        }
//        Abaixo de 17    Muito abaixo do peso
//        Entre 17 e 18,49    Abaixo do peso
//        Entre 18,5 e 24,99    Peso normal
//        Entre 25 e 29,99    Acima do peso
//        Entre 30 e 34,99    Obesidade I
//        Entre 35 e 39,99    Obesidade II (severa)
//        Acima de 40    Obesidade III (mórbida)
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?)
    {
        // sumir com o teclado
        vrPeso.resignFirstResponder()
        vrAltura.resignFirstResponder()
    }
}


// label
// switch
// imageview
// segment tab controller (configurar a quantidade de segmentos)
// slider (valor de intervalo)
