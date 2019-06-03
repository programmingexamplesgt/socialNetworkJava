/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author user
 */
public class DbException extends RuntimeException{
    
    private static final long serialVersionUId = 1L;

    public DbException(String msj) {
        super(msj);
    }
    

}
