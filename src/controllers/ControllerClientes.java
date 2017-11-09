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

import models.ModelClientes;
import views.ViewClientes;

public class ControllerClientes {
    private ModelClientes modelcl;
    private ViewClientes viewcl;
    
    public ControllerClientes(ModelClientes modelcl, ViewClientes viewcl){
        this.modelcl = modelcl;
        this.viewcl = viewcl;
        this.viewcl.jbtn_primero.addActionListener(e -> jbtn_primero_click());
        this.viewcl.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
        this.viewcl.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
        this.viewcl.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
        this.viewcl.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
        this.viewcl.jbtn_insertar.addActionListener(e -> jbtn_insertar_click());
        this.viewcl.jbtn_borrar.addActionListener(e-> jbtn_borrar_click());
        this.viewcl.jbtn_actualizar.addActionListener(e -> jbtn_actualizar_click());
        initView();
    } 
    
    public void getValores(){
        viewcl.jtf_id_cliente.setText("" + modelcl.getId_cliente());
        viewcl.jtf_nombre.setText(modelcl.getNombre());
        viewcl.jtf_telefono.setText(modelcl.getTelefono());
        viewcl.jtf_email.setText(modelcl.getEmail());
        viewcl.jtf_direccion.setText(modelcl.getDireccion());
    }
    
    public void setValores(){
        modelcl.setId_cliente(Integer.parseInt (viewcl.jtf_id_cliente.getText()));
        modelcl.setNombre(viewcl.jtf_nombre.getText());
        modelcl.setTelefono(viewcl.jtf_telefono.getText());
        modelcl.setEmail(viewcl.jtf_email.getText());
        modelcl.setDireccion(viewcl.jtf_direccion.getText());
    }
        
    public void jbtn_nuevo_click(){
        viewcl.jtf_id_cliente.setText("");
        viewcl.jtf_nombre.setText("");
        viewcl.jtf_telefono.setText("");
        viewcl.jtf_email.setText("");
        viewcl.jtf_direccion.setText("");
    }
    public void jbtn_insertar_click(){
        setValores();
        modelcl.insertar();
        getValores();
        
    }
    
    public void jbtn_actualizar_click(){
        setValores();
        modelcl.actualizar();
        getValores();
    }
    
    public void jbtn_borrar_click(){
        setValores();
        modelcl.borrar();
        getValores();
        
    }
    
    public void jbtn_primero_click(){
        modelcl.moverPrimero();
        getValores();      
    }
    
    public void jbtn_ultimo_click(){
        modelcl.moverUltimo();
        getValores();
    }
    
    public void jbtn_siguiente_click(){
        modelcl.moverSiguiente();
        getValores();
        
    }
    
    public void jbtn_anterior_click(){
        modelcl.moverAnterior();
        getValores();
    }
    
    
    public void initView(){
        modelcl.Conectar();
        viewcl.setVisible(true);
        modelcl.moverPrimero();
        getValores();
    }
}
