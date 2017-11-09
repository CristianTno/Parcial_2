/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author Invitado
 */
import models.ModelPrincipal;
import views.ViewClientes;
import views.ViewPeliculas;
import views.ViewPrincipal;


public class ControllerPrincipal {
    private ModelPrincipal modelpr;
    private ViewPrincipal viewpr;
    private ViewClientes viewcl;
    private ViewPeliculas viewpe;
    private ControllerPrincipal controllerpr;
    
    
    public ControllerPrincipal(ModelPrincipal modelpr, Object views[]){
        this.modelpr = modelpr;
        this.viewpr =(ViewPrincipal)views[2];
        this.viewpe = (ViewPeliculas)views[1];
        this.viewcl = (ViewClientes) views[0];
        this.viewpr.jmi_clientes.addActionListener(e-> jmi_clientes_click());
        this.viewpr.jmi_peliculas.addActionListener(e-> jmi_peliculas_click());
        initView();
        
        
    }
    
    private void initView(){
        this.viewpr.setVisible(true);
        
    }
    
    public void jmi_clientes_click(){
        this.viewpr.setContentPane(viewcl);
        this.viewpr.revalidate();
        this.viewpr.repaint();
    }
    
    public void jmi_peliculas_click(){
        this.viewpr.setContentPane(viewpe);
        this.viewpr.revalidate();
        this.viewpr.repaint();
    }
}

