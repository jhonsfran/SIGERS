/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigers;
import models.*;
import entity.*;
import java.util.List;


/**
 *
 * @author Univalle_F
 */
public class SIGERS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ModelMain<Categoria> ModelMain = new ModelMain(); 
        Categoria contactoRecuperado = null;  
        String idAEliminar = "";

        //Creamos tes instancias de Contacto 
        Categoria contacto1 = new Categoria("4", "categoria1", "12345678" , null); 
        Categoria contacto2 = new Categoria("5", "categorgf5", "87654321" , null); 
        Categoria contacto3 = new Categoria("6", "categoria3", "45612378" , null);  

        //Guardamos las tres instancias, guardamos el id del contacto1 para usarlo posteriormente 
        idAEliminar = ModelMain.insertIdString(contacto1); 
        ModelMain.insertIdString(contacto2); 
        ModelMain.insertIdString(contacto3);  

        //Modificamos el contacto 2 y lo actualizamos 
        contacto2.setNombre("NContacto 2"); 
        ModelMain.update(contacto2);  

        //Recuperamos el contacto1 de la base de datos 
        contactoRecuperado = (Categoria) ModelMain.getByID(contacto1.getClass(),"1"); 
        System.out.println("Recuperamos a " + contactoRecuperado.getNombre() + " el id del contacto 1 es " + idAEliminar); 

        //Eliminamos al contactoRecuperado (que es el contacto3) 
        ModelMain.delete(contactoRecuperado);  

        //Obtenemos la lista de contactos que quedan en la base de datos y la mostramos 
        List<Categoria> listaContactos = ModelMain.listar(Categoria.class);  
        System.out.println("Hay " + listaContactos.size() + "contactos en la base de datos");  

        for(Categoria c : listaContactos) 
        { 
            System.out.println("-> " + c.getNombre()); 
        } 

    }
    
}
