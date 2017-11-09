/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Invitado
 */

import controllers.ControllerClientes;
import controllers.ControllerPeliculas;

import controllers.ControllerPrincipal;
import models.ModelClientes;
import models.ModelPeliculas;

import models.ModelPrincipal;
import views.ViewClientes;
import views.ViewPeliculas;

import views.ViewPrincipal;


public class Main {
    public static void main(String ctj[]){
        ModelClientes modelcl = new ModelClientes();
        ViewClientes viewcl = new ViewClientes();
        ControllerClientes controllercl = new ControllerClientes(modelcl, viewcl);
        
        ModelPeliculas modelpe = new ModelPeliculas();
        ViewPeliculas viewpe = new ViewPeliculas ();
        ControllerPeliculas controllerpe = new ControllerPeliculas (modelpe, viewpe);
        
        
        
        ModelPrincipal modelpr = new ModelPrincipal();
        ViewPrincipal viewpr = new ViewPrincipal();
        Object views[] = new Object[3];
        views[0]=viewcl;
        views[1]=viewpe;
        views[2]=viewpr;
        ControllerPrincipal controllerpr = new ControllerPrincipal(modelpr, views);
    
    
    }
    
}

