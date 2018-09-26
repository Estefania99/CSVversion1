/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import models.ModelCsv;
import views.ViewsCsv;
/**
 *
 * @author fanny
 */
public class ControllerCsv {
    ModelCsv modelCsv;
   ViewsCsv viewCsv;
     ActionListener al = new ActionListener (){
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==viewCsv.jb_guardar){
                jb_guardar_action_performed();
            }
            else if(e.getSource()==viewCsv.jb_nuevo){
                System.out.println("e.getSource()==blocNotas.jb_nuevo");
                jb_nuevo_action_performed();
            }
        }
     };
     public ControllerCsv(ModelCsv modelCsv, ViewsCsv viewCsv){
        viewCsv.setVisible(true);
        this.modelCsv = modelCsv;
        this.viewCsv = viewCsv;
        this.viewCsv.jb_nuevo.addActionListener(al);
        this.viewCsv.jb_guardar.addActionListener(al);
      }

        private void jb_guardar_action_performed() {
            this.writeFile(modelCsv.getPath());
            
                    }

        private void jb_nuevo_action_performed() {
            viewCsv.jtf_nombre.setText(null);
            modelCsv.setNombre(null);
            viewCsv.jtf_email.setText(null);
            modelCsv.setEmail(null);
            
            
        }
     
     
      public String writeFile (String path) {
        try{
            File  file = new File(path); //Ruta del arhivo que se abrira
            FileWriter fileWriter = new FileWriter(file,true);
            modelCsv.setNombre(viewCsv.jtf_nombre.getText());
            modelCsv.setEmail(viewCsv.jtf_email.getText());
            modelCsv.setResultado(modelCsv.getNombre() + "," + modelCsv.getEmail());
            try(PrintWriter printWriter = new PrintWriter(fileWriter)){               
                printWriter.println(modelCsv.getResultado());
                printWriter.close();  
                JOptionPane.showMessageDialog(null,"Guardado con Exito");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"File not found:"+e.getMessage());
        }
        }catch(IOException err){
            JOptionPane.showMessageDialog(null,"error on IO operation:"+err.getMessage());
        } 
       return null;   
    }//WriteFile   
}

