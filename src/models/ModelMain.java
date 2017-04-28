/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import conf.*;
import java.util.List;
import javax.swing.JOptionPane;


public class ModelMain<T> implements ModelInterface{
    
    private Session sesion; 
    private Transaction tx;  

    @Override
    public <T> int insertIdInt(T entity) throws HibernateException 
    {
        
        int id = 0;
        
        try 
        { 
            iniciaOperacion();
            id = (int) sesion.save(entity); 
            tx.commit(); 
            
        } catch (HibernateException he) 
        { 
            ExcepcionManager(he); 
            throw he; 
            
        } finally 
        { 
            sesion.close(); 
        }  

        return id;
    }  
    
    @Override
    public <T> String insertIdString(T entity) throws HibernateException 
    {
        
        String id = "";
        
        try 
        { 
            iniciaOperacion();
            id = (String) sesion.save(entity); 
            tx.commit(); 
            
        } catch (HibernateException he) 
        { 
            ExcepcionManager(he); 
            throw he; 
            
        } finally 
        { 
            sesion.close(); 
        }  

        return id;
    }

    @Override
    public <T> void update(T entity) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.update(entity); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            ExcepcionManager(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    } 
    
    @Override
    public <T> T getByID(final Class<T> type, String id) throws HibernateException 
    { 
        T miobjeto = null;  
        
        try 
        { 
            iniciaOperacion(); 
            miobjeto = (T) sesion.get(type, id);
            
        } catch (HibernateException he) 
        { 
            ExcepcionManager(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }  

        return miobjeto; 
    }  
    
    @Override
    public <T> void deleteById(final Class<T> type, String id) throws HibernateException 
    { 

        try 
        { 
            iniciaOperacion(); 
            sesion.delete(getByID(type,id));
            
        } catch (HibernateException he) 
        { 
            ExcepcionManager(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        }  

    }

    @Override
    public <T> void delete(T entity) throws HibernateException 
    { 
        try 
        { 
            iniciaOperacion(); 
            sesion.delete(entity); 
            tx.commit(); 
        } catch (HibernateException he) 
        { 
            ExcepcionManager(he); 
            throw he; 
        } finally 
        { 
            sesion.close(); 
        } 
    }  

    @Override
    public <T> List<T> listar(final Class<T> type) throws HibernateException 
    { 
        List<T> lista = null;  

        try 
        { 
            iniciaOperacion(); 
            lista = sesion.createQuery("from " + type.getName()).list(); 
        } finally 
        { 
            sesion.close(); 
        }  

        return lista; 
    }  
    

    private void iniciaOperacion() throws HibernateException 
    { 
        sesion = HibernateUtil.getSessionFactory().openSession(); 
        tx = sesion.beginTransaction(); 
    }  


    private void ExcepcionManager(HibernateException he) throws HibernateException 
    { 
        //cancelar la transacción
        tx.rollback(); 
        //System.out.println(he.getCause().getMessage());
        JOptionPane.showMessageDialog(null,he.getCause().getMessage());
        //throw new HibernateException("Ocurrió un error en la capa de acceso a datos", he); 

    } 
    
}