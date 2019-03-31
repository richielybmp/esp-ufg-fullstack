//
//  TorchViewController.swift
//  MyPhome
//
//  Created by Aluno on 09/03/2019.
//  Copyright © 2019 Aluno. All rights reserved.
//

import UIKit

class TorchViewController: UIViewController {
    
    @IBOutlet weak var vrImageTorch: UIImageView!
    
    @IBOutlet weak var vrSegmentedTab: UISegmentedControl!
    
    @IBOutlet weak var vrSlider: UISlider!
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

    @IBAction func handleSlider(_ sender: UISlider) {
        //self.view.alpha = CGFloat(sender.value)
        self.vrImageTorch.alpha = CGFloat(sender.value)
    }
    
    @IBAction func handleSegmentedControl(_ sender: UISegmentedControl) {
        switch sender.selectedSegmentIndex {
        case 0:
            self.view.backgroundColor = UIColor.red
        case 1:
            self.view.backgroundColor = UIColor.green
        case 2:
            self.view.backgroundColor = UIColor.purple
        case 3:
            self.view.backgroundColor = UIColor.yellow
        case 4:
            self.view.backgroundColor = UIColor.white
        default:
            self.view.backgroundColor = UIColor.black
        }
    }
    
    override func touchesBegan(_ touches: Set<UITouch>, with event: UIEvent?)
    {
        self.view.alpha = 1
    }
    
    @IBAction func handleSwitchControl(_ sender: UISwitch) {
        if sender.isOn
        {
            vrSlider.isEnabled = true
            vrSegmentedTab.isEnabled = true
        }
        else
        {
            vrSlider.isEnabled = false
            vrSegmentedTab.isEnabled = false
        }
    }
    
}
