/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;


import java.util.List;


/**
 *
 * @author Univalle_F
 */
public interface ModelInterface {
    
    <T> T getByID(final Class<T> type, String id);
 
    <T> List<T> listar(Class<T> type);
 
    <T> String insertIdString(T entity);
    
    <T> int insertIdInt(T entity);
 
    <T> void update(T entity);
 
    <T> void delete(T entity);
 
    <T> void deleteById(final Class<T> type, String id);
        
}
