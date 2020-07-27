/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.principal;
    import Backend.Decodificador;
    import Frontend.GUI_decodificador;

/**
 *
 * @author phily
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Decodificador decodificadorEnAccion = new Decodificador();
        //GUI_decodificador guiDecodificador = new GUI_decodificador();
        
        decodificadorEnAccion.iniciarProceso();//fase 1
        
        //guiDecodificador.setLocationRelativeTo(null);//segunda fase
        //guiDecodificador.setVisible(true);
           
        
    }
    
}
