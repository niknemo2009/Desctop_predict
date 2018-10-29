/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repos_predict;

/**
 *
 * @author BigBoss
 */
public interface  AbstractDAO <T> {
    boolean create(T par);
    boolean delete(T par);
    boolean update(T old,T new1);
    
}
