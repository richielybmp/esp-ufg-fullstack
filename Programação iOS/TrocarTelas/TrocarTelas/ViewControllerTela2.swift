//
//  ViewControllerTela2.swift
//  TrocarTelas
//
//  Created by Aluno on 23/03/2019.
//  Copyright © 2019 Aluno. All rights reserved.
//

import UIKit

class ViewControllerTela2: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
    }
    

    @IBAction func voltar(_ sender: Any) {
        //dismiss(animated: true, completion: nil)
        dismiss(animated: true) {
            print("VOLTANDO...")
        }
    }
    
    
    
}
