/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parcialii;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class TbEmpleados {
    
    public static void Consultas(int niv){
        String url = "jdbc:mysql://localhost:3306/empleaprogra?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try{
            Connection con=DriverManager.getConnection(url, "root","Umg$2019");
            Statement sen=con.createStatement();
            String sql="SELECT * FROM empleaprogra.empleados where NIV="+niv;
            ResultSet resul=sen.executeQuery(sql);
            while(resul.next()){
                System.out.println("Niv: "+resul.getInt(1));
                System.out.println("Nombre: "+resul.getString(2));
                System.out.println("Enero: "+resul.getInt(3));
                System.out.println("Febrero: "+resul.getInt(4));
                System.out.println("Marzo: "+resul.getInt(5));
                System.out.println("Abril: "+resul.getInt(6));
                System.out.println("Mayo: "+resul.getInt(7));
                System.out.println("Junio: "+resul.getInt(8));
            }
        }catch(SQLException ex){
            System.out.println("Error: "+ex.getMessage());
            
        }  
    }
    
    private static void Eliminar(){
        Scanner vin= new Scanner(System.in);
        Scanner opc= new Scanner (System.in);
        System.out.println("Por favor ingrese el Niv del vendedor");
        int niv=vin.nextInt();
        System.out.println("Estas seguro de eliminarlo?");
        System.out.println("1)-SI");
        System.out.println("2)-NO");
        int op=opc.nextInt();
        switch(op){
            case 1:
                try{
                    String url = "jdbc:mysql://localhost:3306/empleaprogra?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
                    Connection con=DriverManager.getConnection(url,"root","Umg$2019");
                    Statement sen= con.createStatement();
                    String sql="DELETE FROM empleados WHERE NIV="+niv;
                    sen.execute(sql);
                }catch(SQLException ex){
                    System.out.println("Lo lamento hubo un problema");
                    
                }
                break;
            case 2:
                System.out.println("Que bueno que lo pensaste :)");
                break;
            default:
                System.out.println("Ingrese una opcion correcta");
                break;
        }
        
        
    }
    
    private static void Actualizar(){
        Scanner vin=new Scanner(System.in);
        System.out.println("Por ingrese el NIV del vendedor");
        int niv=vin.nextInt();
        String url = "jdbc:mysql://localhost:3306/empleaprogra?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try{
            Connection con=DriverManager.getConnection(url,"root","Umg$2019");
            Statement sen=con.createStatement();
            String sql="UPDATE empleados SET Nombre='Mario Gonzalez'  WHERE NIV=" +niv;
            sen.execute(sql);
        }catch(SQLException ex){
            System.out.println("Lo lamento hubo un problema: "+ex.getMessage());
        }
            
        
    }
    
    
    private static void Consultar(){
        Scanner vin=new Scanner(System.in);
        System.out.println("Por favor ingrese el NIV del vendedor");
        int niv=vin.nextInt();
        String url = "jdbc:mysql://localhost:3306/empleaprogra?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try{
            Connection con=DriverManager.getConnection(url,"root","Umg$2019");
            Statement sen=con.createStatement();
            String sql="SELECT Nombre, Enero, Febrero, Marzo, Abril, Mayo, Junio, SUM(Enero+Febrero+Marzo+Abril+Mayo+Junio) AS Total from empleados where NIV="+niv;
            sen.execute(sql);
           
        }catch(SQLException ex){
            System.out.println("Lo lamento hubo un problema:"+ex.getMessage());
        }
    }
    
    public static void Lis(){
        String url = "jdbc:mysql://localhost:3306/empleaprogra?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try{
            Connection con=DriverManager.getConnection(url,"root","Umg$2019");
            Statement sen=con.createStatement();
            String sql1="SELECT Nombre FROM empleados;";
            String sql="SELECT  SUM(Enero) as TotalEnero, SUM(Febrero)as Totalfebrero ,SUM(Marzo) as Totalmarzo, SUM(Abril) as Totalabril,SUM(Mayo) as Totalmayo,SUM(Junio) as Totaljunio from empleados group by Nombre;";
            ResultSet resul=sen.executeQuery(sql1);
            ResultSet resul1=sen.executeQuery(sql);
            while(resul.next() && resul1.next()){
                System.out.println("Nombre: "+resul.getString(1));
                
            }
            
            
        }catch(SQLException ex){
            System.out.println("Lo lamento hubo un problema:"+ex.getMessage());
        }
    }
    

    public static void main(String[] args){
        Actualizar();
        
        
        
    }
    
}
