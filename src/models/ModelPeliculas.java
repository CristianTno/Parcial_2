/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Invitado
 */

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelPeliculas {
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_pelicula;
    private String nombre;
    private String formato;
    private String duracion;
    private String descripcion;
    
            
    public void Conectar(){
        try{
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/pelis","root","utectulancingo");
            st= conexion.createStatement();
            seleccionaTodos();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "error101");
                     
        }
    }
    
    public void setId_pelicula(int id_pelicula){
        this.id_pelicula = id_pelicula;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    } 
    
    public void setFormato (String formato){
        this.formato = formato;
    }
    
    public void setDuracion (String duracion){
        this.duracion = duracion;
    }
    
    public void setDescripcion (String descripcion){
        this.descripcion = descripcion;
    }
    
    public int getId_pelicula(){
        return id_pelicula;
    }
    public String getNombre(){
        return nombre;
    }
    public String getFormato(){
        return formato;
    }
    public String getDuracion(){
        return duracion;
    }
    public String getDescripcion(){
        return descripcion;
    }
    
    public void LlenarValores(){
        try{
            setId_pelicula(rs.getInt("Id_pelicula"));
            setNombre(rs.getString("Nombre"));
            setFormato(rs.getString("Formato"));
            setDuracion(rs.getString("Duracion"));
            setDescripcion(rs.getString("Descripcion"));
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 102");
        }
    }
    
    public void moverPrimero(){
        try{
            rs.first();
            LlenarValores();
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error103");     
        }
    }


    
    public void moverUltimo(){
        try{
            rs.last();
            LlenarValores();
        
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 104");
        }
    }
    
    public void moverSiguiente(){
        try{
            if(rs.isLast() == false){
                rs.next();
                LlenarValores();
            }  
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 105");
        }
    }
    
    public void moverAnterior(){
        try{
            if(rs.isFirst() == false){
                rs.previous();
                LlenarValores();
            }
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 106");
        }
    }
    
    public void seleccionaTodos(){
        try{
            sql = "select *from peliculas;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 107");
        }
    }
    
    public void insertar(){
        try{
            sql = "insert into peliculas(Id_pelicula, Nombre, Formato, Duracion, Descripcion) values(?,?,?,?,?);";
            ps = conexion.prepareStatement (sql);
            ps.setInt(1, getId_pelicula());
            ps.setString(2, getNombre());
            ps.setString(3, getFormato());
            ps.setString(4, getDuracion());
            ps.setString(5, getDescripcion());
            ps.executeUpdate();
            Conectar();
            moverPrimero();
       
            
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"error 108" + ex.getMessage());
        }
    }
    
    public void borrar(){
        try{
            sql = "delete from peliculas where Id_pelicula = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, getId_pelicula());
            ps.executeUpdate();
            Conectar();
            moverPrimero();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"error 109 " + ex.getMessage());
            
        }
    }
    
    public void actualizar(){
        try{
            sql = " update peliculas set Nombre = ?, Formato = ?, Duracion = ?, Descripcion = ? where Id_pelicula = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(5, getId_pelicula());
            ps.setString(1, getNombre());
            ps.setString(2, getFormato());
            ps.setString(3, getDuracion());
            ps.setString(4, getDescripcion());
            ps.executeUpdate();
            Conectar();
            moverPrimero();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"error 110" + ex.getMessage());
        }
    }
  
}

