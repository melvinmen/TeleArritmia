/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import pojo.Patient;

/**
 *
 * @author danielmarchan
 */
public class Persistence {
    
     /*Un metodo que lee de un archivo objetos de tipo poblacion en binario
        y me devuelve la poblacion que ha leido*/
    
    /*mas de lo mismo le pasa un string que lea el file*/
    public Patient cargar(File f) throws ClassNotFoundException {
        FileInputStream pobla = null;     
        ObjectInputStream poblaratones = null;
        Patient p1=null;

        try{    
                pobla = new FileInputStream (f);     
                poblaratones = new ObjectInputStream(pobla);
                p1=(Patient)poblaratones.readObject();
        }
        catch(IOException ex){
            System.out.println(ex);
        }
        /*Tiene que cerrar el flujo de datos*/
        finally{
            if(poblaratones!=null){
               try{
               poblaratones.close();
               }
               catch(IOException ex){
               System.out.println(ex);          
                }
            }
            
        if(pobla!=null){
              try{
                pobla.close();}
              catch(IOException ex){
                  System.out.println(ex);}}
        }
        return p1; }


      
    /*Le paso un path y me tiene que guardar esa poblacion ahi*/
    /*Yo aqui cambiaria y le meteria un String y dentro inicializaria el File*/
    public void guardar(File f,Patient p1){
        FileOutputStream pobla = null;     
        ObjectOutputStream poblaratones = null; 
        
        
      
        try{
            pobla = new FileOutputStream (f);     
            poblaratones = new ObjectOutputStream(pobla);
            poblaratones.writeObject(p1);
        }
      
        catch(IOException ex){
          System.out.println("Error en la escritura");
        }
      
        finally{
            if(poblaratones!=null){
                try{
                    poblaratones.close();
                    }
                catch(IOException ex){
                    System.out.println(ex);;
                }
             }
            
            if(pobla!=null){
                try{
                    pobla.close();}
                catch(IOException ex){
                    System.out.println(ex);
                }
            }
        }
    }
    
    
    
     /*El file se lee por pantalla es muy sencillo 
        Esto lo vamos a meter dentro del boton para cargar una poblacion 
    
            System.out.println("Introduzca el path del archivo que contiene la poblacion:");
            
            String nom=leer();
            f = new File(nom);
            
            if(!f.exists()){
                    System.out.println("Archivo inexistente");break;
            }
            
            else        
                    try{  
                        p=per.cargar(f);
                        System.out.println(p);break;
                    }
                    catch(ClassNotFoundException ex){
                        System.out.println("error en la lectura intente de nuevo");
                        break;
                    }       
            */
    
    
    /*Esto para guardar
    
    System.out.println("Escriba el nuevo path de su archivo:");
                String nuevo=leer();   
                f = new File(nuevo);
                per.guardar(f, p);
                System.out.println("Creado");
                System.out.println("\n");
    
    */
    
    
}


 