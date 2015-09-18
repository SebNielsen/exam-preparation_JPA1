/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Control.Control;
import Facade.CRUD;

/**
 *
 * @author sebastiannielsen
 */
public class Tester {

    public static void main(String[] args) {
    CRUD persistenceHandler = new Control();
    persistenceHandler.createUser("Sebastian", "sebnielsen@hotmail.com");
    persistenceHandler.createProject("Project1", "Desciption");
    persistenceHandler.assignUserToProject(1l, 1l);
    persistenceHandler.createTaskAndAssignToProject("Task2", "desciption", 20, 1);
    
    }

    
}
