/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.Scanner;

/**
 *
 * @author phily
 */
public class Receptor {
    String secuencias[] = new String [2];
    
           
    public void presentrarPrograma(){
        System.out.println("<<DECODIFICADOR DE ADN>>\n\n");
        System.out.println("Esta herramienta es útil para hallar los conjuntos mayores de coincidencia\n de nucleotidos en dos secuencias de ADN ingresadas\n por medio del cual es posible analizar las similitudes entre seres vivos\n");
        System.out.println("INSTRUCCIONES\n");
        System.out.println("1. Realice las acciones que le han sido solicitadas");
        System.out.println("2. Luego de cumplirlas presione ENTER");
        System.out.println("3. Espere unos momentos para recibir los resultados\n\n");                
    }
    
    public void solicitarDatos(){
        Scanner entrada = new Scanner(System.in);        
         
        for (int numeroSecuencia = 0; numeroSecuencia < 2; numeroSecuencia++) {
            System.out.println("Ingrese la secuencia " + (numeroSecuencia+1)+ ":");
            secuencias[numeroSecuencia] = entrada.nextLine();
        }                        
    }//si requierieras hacerlo static podría hacer que este mismo devuelva el arreglo
    
    public String[] retornarSecuencias(){
        return secuencias;
    }        
    
    public void mostrarResultados(ListaEnlazada<String> coincidecias){
        if(coincidecias.estaVacia()){
            System.out.println("\nLos seres estudiados son COMPLETAMENTE DIFERENTES en su anatomía");
        }else{
            if(coincidecias.darTamanio()==1){
                System.out.println("\n-> El conjunto: "+ coincidecias.obtnerPrimerNodo().contenido + " se encuentra en ambos seres");
            }else{//es decir es mayor... pues arriba se contempla cuando es 0
                Nodo<String> auxiliar= coincidecias.obtnerPrimerNodo();
                
                System.out.println("\n-> El primer conjunto de coincidencias hallado fue: "+ auxiliar.contenido+"\n");
                System.out.println("-> Demás coincidencias");
                auxiliar=auxiliar.nodoSiguiente;
                
                do{
                    System.out.println("   "+ auxiliar.contenido);
                    auxiliar=auxiliar.nodoSiguiente;
                }while(auxiliar!=null);
            }
            
        }
    }
    
}
