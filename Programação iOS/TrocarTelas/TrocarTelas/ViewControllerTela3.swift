//
//  ViewControllerTela3.swift
//  TrocarTelas
//
//  Created by Aluno on 23/03/2019.
//  Copyright © 2019 Aluno. All rights reserved.
//

import UIKit

class ViewControllerTela3: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        self.title = "Principal"
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
     
    @IBAction func pushViaCodigo(_ sender: UIButton) {
        
        let proxTela = storyboard?.instantiateViewController(withIdentifier: "tela4") as! ViewControllerTela4
        
    self.navigationController?.pushViewController(proxTela, animated: true)
        
        
    }
}
