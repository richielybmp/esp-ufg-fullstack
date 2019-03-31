//
//  ViewControllerDetalhe.swift
//  MyPhome
//
//  Created by Aluno on 23/03/2019.
//  Copyright © 2019 Aluno. All rights reserved.
//

import UIKit

class ViewControllerDetalhe: UIViewController {

    @IBOutlet weak var vrImageDetail: UIImageView!
    
    @IBOutlet weak var vrLabelDetail: UILabel!
    
    public var selectedItem:String = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
   }

    override func viewDidAppear(_ animated: Bool) {
        vrImageDetail.image = UIImage(named: selectedItem)
        vrLabelDetail.text = selectedItem
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
}
