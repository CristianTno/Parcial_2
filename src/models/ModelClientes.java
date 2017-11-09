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


public class ModelClientes {
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int id_cliente;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    
            
    public void Conectar(){
        try{
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/pelis","root","utectulancingo");
            st= conexion.createStatement();
            seleccionaTodos();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "error101" + ex.getMessage());
                     
        }
    }
    
    public void setId_cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    } 
    
    public void setTelefono (String telefono){
        this.telefono = telefono;
    }
    
    public void setEmail (String email){
        this.email = email;
    }
    public void setDireccion (String direccion){
        this.direccion = direccion;
    }
    
    public int getId_cliente(){
        return id_cliente;
    }
    public String getNombre(){
        return nombre;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getEmail(){
        return email;
    }
    public String getDireccion(){
        return direccion;
    }
    
    public void LlenarValores(){
        try{
            setId_cliente(rs.getInt("Id_cliente"));
            setNombre(rs.getString("Nombre"));
            setTelefono(rs.getString("Telefono"));
            setEmail(rs.getString("Email"));
            setDireccion(rs.getString("Direccion"));
            
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
            sql = "select *from clientes;";
            ps = conexion.prepareStatement(sql);
            rs = ps.executeQuery();
            moverPrimero();
            
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 107");
        }
    }
    
    public void insertar(){
        try{
            sql = "insert into clientes(Id_cliente, Nombre, Telefono, Email, Direccion) values(?,?,?,?,?);";
            ps = conexion.prepareStatement (sql);
            ps.setInt(1, getId_cliente());
            ps.setString(2, getNombre());
            ps.setString(3, getTelefono());
            ps.setString(4, getEmail());
            ps.setString(5, getDireccion());
            ps.executeUpdate();
            Conectar();
            
            moverPrimero();
       
            
           
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"error 108" + ex.getMessage());
        }
    }
    
    public void borrar(){
        try{
            sql = "delete from clientes where Id_cliente = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, getId_cliente());
            ps.executeUpdate();
            Conectar();
            moverPrimero();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"error 109 " + ex.getMessage());
            
        }
    }
    
    public void actualizar(){
        try{
            sql = " update clientes set Nombre = ?, Telefono = ?, Email = ?, Direccion = ?  where Id_cliente = ?;";
            ps = conexion.prepareStatement(sql);
            ps.setInt(5, getId_cliente());
            ps.setString(1, getNombre());
            ps.setString(2, getTelefono());
            ps.setString(3, getEmail());
            ps.setString(4, getDireccion());
            ps.executeUpdate();
            Conectar();
            moverPrimero();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"error 110" + ex.getMessage());
        }
    }
  
}

