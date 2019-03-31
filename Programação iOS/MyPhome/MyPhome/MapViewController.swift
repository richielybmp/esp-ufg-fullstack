//
//  MapViewController.swift
//  MyPhomeApp
//
//  Created by Aluno on 23/03/2019.
//  Copyright © 2019 Aluno. All rights reserved.
//

import UIKit
import MapKit

class MapViewController: UIViewController, MKMapViewDelegate, UIGestureRecognizerDelegate {
    
    @IBOutlet weak var vrMapView: MKMapView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        vrMapView.delegate = self
        self.title = "Mapa"
    }
    
    override func viewDidAppear(_ animated: Bool) {
        criaPino()
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    
    @IBAction func trataTipoMap(_ sender: UISegmentedControl) {
        switch sender.selectedSegmentIndex {
        case 0:
            vrMapView.mapType = .standard
            break
        case 1:
            vrMapView.mapType = .satellite
            break
        case 2:
            vrMapView.mapType = .hybrid
            break
        default:
            vrMapView.mapType = .standard
            break
        }
    }
    
    func criaPino()
    {
        let pino = MKPointAnnotation()
        pino.title = "UFG - INF"
        
        let coordenadas = CLLocationCoordinate2D(latitude: -16.6033361, longitude: -49.2671683)
        pino.coordinate = coordenadas
        
        vrMapView.addAnnotation(pino)
        
        let zoom = MKCoordinateSpanMake(0.002, 0.002)
        
        let regiao = MKCoordinateRegion(center: pino.coordinate, span: zoom)
        
        vrMapView.setRegion(regiao, animated: true)
        
    }
    
    func mapView(_ mapView: MKMapView, didSelect view: MKAnnotationView) {
        print("LOCAL SELECIONADO NO MAPA")
    }
    
    func gestureRecognizerShouldBegin(_ gestureRecognizer: UIGestureRecognizer) -> Bool {
        
        let ponto = gestureRecognizer.location(in: vrMapView)
        let coordenadas = vrMapView.convert(ponto, toCoordinateFrom: vrMapView)
        
        let pino = MKPointAnnotation()
        pino.title = "Novo local"
        pino.coordinate = coordenadas
        
        vrMapView.addAnnotation(pino)
        
        print("LONG PRESS")
        return true
    }
}

