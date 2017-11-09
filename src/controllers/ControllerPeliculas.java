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


import models.ModelPeliculas;
import views.ViewPeliculas;

public class ControllerPeliculas {
    private ModelPeliculas modelpe;
    private ViewPeliculas viewpe;
    
    public ControllerPeliculas(ModelPeliculas modelpe, ViewPeliculas viewpe){
        this.modelpe = modelpe;
        this.viewpe = viewpe;
        this.viewpe.jbtn_primero.addActionListener(e -> jbtn_primero_click());
        this.viewpe.jbtn_siguiente.addActionListener(e -> jbtn_siguiente_click());
        this.viewpe.jbtn_anterior.addActionListener(e -> jbtn_anterior_click());
        this.viewpe.jbtn_ultimo.addActionListener(e -> jbtn_ultimo_click());
        this.viewpe.jbtn_nuevo.addActionListener(e -> jbtn_nuevo_click());
        this.viewpe.jbtn_insertar.addActionListener(e -> jbtn_insertar_click());
        this.viewpe.jbtn_borrar.addActionListener(e-> jbtn_borrar_click());
        this.viewpe.jbtn_actualizar.addActionListener(e -> jbtn_actualizar_click());
        initView();
    } 
    
    public void getValores(){
        viewpe.jtf_id_pelicula.setText("" + modelpe.getId_pelicula());
        viewpe.jtf_nombre.setText(modelpe.getNombre());
        viewpe.jtf_formato.setText(modelpe.getFormato());
        viewpe.jtf_duracion.setText(modelpe.getDuracion());
        viewpe.jtf_descripcion.setText(modelpe.getDescripcion());
    }
    
    public void setValores(){
        modelpe.setId_pelicula(Integer.parseInt (viewpe.jtf_id_pelicula.getText()));
        modelpe.setNombre(viewpe.jtf_nombre.getText());
        modelpe.setFormato(viewpe.jtf_formato.getText());
        modelpe.setDuracion(viewpe.jtf_duracion.getText());
        modelpe.setDescripcion(viewpe.jtf_descripcion.getText());
    }
        
    public void jbtn_nuevo_click(){
        viewpe.jtf_id_pelicula.setText("");
        viewpe.jtf_nombre.setText("");
        viewpe.jtf_formato.setText("");
        viewpe.jtf_duracion.setText("");
        viewpe.jtf_descripcion.setText("");
    }
    public void jbtn_insertar_click(){
        setValores();
        modelpe.insertar();
        getValores();
        
    }
    
    public void jbtn_actualizar_click(){
        setValores();
        modelpe.actualizar();
        getValores();
    }
    
    public void jbtn_borrar_click(){
        setValores();
        modelpe.borrar();
        getValores();
        
    }
    
    public void jbtn_primero_click(){
        modelpe.moverPrimero();
        getValores();      
    }
    
    public void jbtn_ultimo_click(){
        modelpe.moverUltimo();
        getValores();
    }
    
    public void jbtn_siguiente_click(){
        modelpe.moverSiguiente();
        getValores();
        
    }
    
    public void jbtn_anterior_click(){
        modelpe.moverAnterior();
        getValores();
    }
    
    
    public void initView(){
        modelpe.Conectar();
        viewpe.setVisible(true);
        modelpe.moverPrimero();
        getValores();
    }
}

