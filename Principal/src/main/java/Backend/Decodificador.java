/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author phily
 */
public class Decodificador {
    
    Receptor receptor = new Receptor();
    Procesador procesador = new Procesador();
    
    public void iniciarProceso(){
        receptor.presentrarPrograma();        
        receptor.solicitarDatos();        
        receptor.mostrarResultados(procesador.decodificarADN(receptor.retornarSecuencias()));
    }
}
