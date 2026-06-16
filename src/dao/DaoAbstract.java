/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author u06454182185
 */
public abstract class DaoAbstract {
     public abstract boolean insert(Object object);
     public abstract void update(Object object);
     public abstract void delete(Object object);
     public abstract Object list(int id);
     public abstract Object listAll();
}
