//
//  ViewController.swift
//  TrocarTelas
//
//  Created by Aluno on 23/03/2019.
//  Copyright © 2019 Aluno. All rights reserved.
//

import UIKit

class ViewControllerTela1: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if(segue.identifier == "segueModal")
        {
            //let proxTela = segue.destination as! ViewControllerTela2
            print("Nova tela")
        }
    }

    @IBAction func proximaTelaModal(_ sender: UIButton) {
        let proxTela = storyboard?.instantiateViewController(withIdentifier: "tela2") as! ViewControllerTela2
        
        proxTela.modalTransitionStyle = .partialCurl
        
        present(proxTela, animated: true)
        {
            print("Abrindo tela 2")
        }
    }
}

