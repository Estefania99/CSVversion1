/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
     import models.ModelCsv;
     import views.ViewsCsv;
     import controllers.ControllerCsv;
/**
/**
 *
 * @author LAB-1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ModelCsv modelCsv = new ModelCsv();
        ViewsCsv viewCsv= new ViewsCsv();
        ControllerCsv controllerCsv = new ControllerCsv ( modelCsv,viewCsv);
    }
    
}
