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
public class Procesador {
     ListaEnlazada<ListaEnlazada<Integer>> listaDeUbicaciones;//para evitar tener que hacer esto hubieras podido encontrar cuantas veces se repetía cada letra en la secuencia con idexOf y según ese valor crear el tamaño para el arreglo
    //ahí revisas por qué es que no se guarda el último caracter de la secuencia <, si es por preferencia o gusto entonces quítalo, pues provoca errores al no aprecer en otra parte el 
    //caracter que ahí de último se muestra
    
    
    public ListaEnlazada<String> decodificarADN(String secuencias[]){   
        ListaEnlazada<String> coincidencias = new ListaEnlazada();
                
        if(verificarValidezDeCaracteres(convertirAMinusculas(secuencias))){
            establecerUbicacionesDeNucleotidos(darSecuenciaComparadora(secuencias));//
            coincidencias = analizarSecuencias(secuencias);            
        }
            
        //depano que tendré que retornar un true para pedir nuevamente los datos
        
        return coincidencias;        
    }
    
    public String[] convertirAMinusculas(String[] secuencias){               
        for (int secuencia = 0; secuencia < secuencias.length; secuencia++) {
            secuencias[secuencia]= secuencias[secuencia].toLowerCase();
        }
        
        return secuencias;
    }
    
    /**
     * Primero en ser ejecutado pues se requiere verificar que los
     * caracterers a revisar correspondan a los nucleótidos del ADN 
     * 
     * @param secuencias
     * @return
     */
    public boolean verificarValidezDeCaracteres(String secuencias[]){
    //podrías recorrer desde el principio hasta el fin las secuencias, para comparar el caracter 
    //de la posición correspondiente, con alguna de las letras que corresponde a los nucleótidos
    //o usar pattern               
       for (int secuencia = 0; secuencia < secuencias.length; secuencia++) {
           if(!sonCaracteresCorrectos(secuencias[secuencia])){
               return false;
           }
           
       }
            
       return true;
    }
    
    public boolean sonCaracteresCorrectos(String secuencia){
        if(!secuencia.matches(".*[actg].*")){//es decir si tiene cualquiera de esas letras
                System.out.println("\n-> La cadena "+ secuencia+" no posee las letras representativas");
                System.out.println("Debes ingresar solamente las representiaciones para los nucleótidos\n a-> Adenina\t g-> Guanina\nc-> Citosina\tt-> Timina");
                return false;
            
        }                
        return true;
    }
    
    /**
     * Es el segundo método a ejecutar que se encarga
     * de revidar cual de las dos es la más pequeña si es
     * que no son iguales, puesto que las coincidencias
     * no podrán exeder el tamaño de la menor
     * @param secuencias
     */
    public String darSecuenciaComparadora(String secuencias[]){
    //afuera se revisa si se puede o no seguir con estos métodos... aunque si
    //nos ponemos a pensar en la BD, creo que sería mejor verif aquí, pero supongo
    //que en ellas se hace con hilos o algo así xD
        
       if(secuencias[0].length()<secuencias[1].length()){                  
       
           String auxiliar;
           auxiliar= secuencias[0];
           secuencias[0]=secuencias[1];
           secuencias[1]=auxiliar;//yo diría que con esto ya manipulé el objeto recibido entonces cuando vuelva a emplearlo en el exterior del método tendrá este cb app                      
       }              
    
       return secuencias[1];//En 0 siempre tendré a la secuencia comparada y en 1 la <=
    }
    
    /**
     * Encargado de crear los listados que contendrán las ubicaciones de los caracteres que 
     * correspondan a su nombre los cuales son las representaciones de los nucleótidos del ADN
     * @param secuenciaComparadora
     */
    public void establecerUbicacionesDeNucleotidos(String secuenciaComparadora){
        listaDeUbicaciones = new ListaEnlazada();
        
        for (int caracterActual = 0; caracterActual < secuenciaComparadora.length(); caracterActual++) {//es necesario tomar el último en cuenta porque puede suceder (y pasó xD) que esa letra solo se encuentre en la última posición y justmente esa era el útlimo caracter de las cadenas coincidientes y por ello no se muestre u obtenga de forma completa dicha cadena
            if(caracterActual==0){                                
                listaDeUbicaciones.anadirAlFinal(inicializarListaDeNucleotidoNuevo(secuenciaComparadora.charAt(caracterActual), caracterActual));//sería el primer nodo
                
            }else{
               agregarAListadoCorrespondiente(secuenciaComparadora.charAt(caracterActual), caracterActual);              
            }
        }  
        
       if(listaDeUbicaciones.darTamanio()!=4){
           System.out.println("\nAl parecer el espécimen presenta una anomalía en su genética :v");
       }
    }   
    
    
    private ListaEnlazada<Integer> inicializarListaDeNucleotidoNuevo(char caracterRepresentante, int caracterActual){
        ListaEnlazada<Integer> ListaDesiguienteNucleotido = new ListaEnlazada(caracterRepresentante);
        ListaDesiguienteNucleotido.anadirAlFinal(caracterActual);    
        
        return ListaDesiguienteNucleotido;
    }
    
    
    private void agregarAListadoCorrespondiente(char caracterRepresentativo, int caracterActual){//añade la ubicación según en el listado que tenga nombre igual a él
       Nodo<ListaEnlazada<Integer>> nodoAuxiliar = listaDeUbicaciones.obtnerPrimerNodo();
       boolean grupoHallado= false;
                
       while(nodoAuxiliar!=null && !grupoHallado){
           if(nodoAuxiliar.contenido.obtenerNombre() == caracterRepresentativo){//con los char se puede emplear el == para comparar
                nodoAuxiliar.contenido.anadirAlFinal(caracterActual);
                grupoHallado=true;
           }
                 
           nodoAuxiliar=nodoAuxiliar.nodoSiguiente;
       }
              
       if(!grupoHallado){                                                      
           listaDeUbicaciones.anadirAlFinal(inicializarListaDeNucleotidoNuevo(caracterRepresentativo, caracterActual));
       }                      
    }
    
    public ListaEnlazada<String> analizarSecuencias(String secuencias[]){        
       ListaEnlazada<String> coincideciaMayor= new ListaEnlazada();//o coincidencias... pues puede que sean iguales[en tamaño]... por eso cree la lista
       ListaEnlazada<Integer> listadoCaracterActual;
        
        for (int caracterAComparar = 0; caracterAComparar < (secuencias[0].length()-1); caracterAComparar++) {//pues la última posición no me interesa analizarala porque si llego ahí es porque no hubieron coincidencias y obviamente esa letra última la van a tener ambas cadenas talvez no e l a misma posi pero a lo que voy es que ese no es un conjunto representativo como para tomarlo en cuenta :v
            listadoCaracterActual=hallarListadoCaracterActual(secuencias[0].charAt(caracterAComparar));
            
            if(!coincideciaMayor.estaVacia()){
                if((secuencias[0].length()-caracterAComparar)<coincideciaMayor.obtnerPrimerNodo().contenido.length()){//no le sumo 1 porque ya estoy en el valor que le correspondía al tamaño de lo analizado anteriromente
                    //Se hace así con el listado de las coincidencias puesto que en ella habrá secuencias que tengan el mismo tamaño [si es que se halla una coinci de igual tamaño]
                    break;//pues a la secuencia > ya no le sobra un #> de espacios como para obtener una coincidencia > con esto si definitivamente ya no hay posibilidad de SEGUIR, por ello PARO
                }else{
                    if(listadoCaracterActual!=null){
                        if((secuencias[1].length()-(listadoCaracterActual.obtnerPrimerNodo().contenido+1))>=coincideciaMayor.obtnerPrimerNodo().contenido.length()){
                        //pues quiere decir que la letra que se encuentra en el listado a revisar tiene una cadena menor a la coincidencia y así no tiene chiste de seguir, porque quiere
                        //decir que los listados de las demás letras[debido a que se encuentran ubicaciones después de esta] no tendrán la posibilidad de generar una coincidencia > a la hallada
                        //que las compañeras al cumplirse esto sean >= se corrobora en el for del mét de abajito :)
                            hallarConjuntosSimilares(coincideciaMayor, listadoCaracterActual, secuencias, caracterAComparar+1);
                        }
                    }                                        
                }
            }else{            
                if(listadoCaracterActual!=null){
                    hallarConjuntosSimilares(coincideciaMayor, listadoCaracterActual, secuencias, caracterAComparar+1);//revisa sie sto concuerda con los coment recientes de abajo, lee de primero el del for de abajito y luego el de aquí
                }
                
            }                        
        }
        
        return coincideciaMayor;
        
        //Y ESTE FOR es para que cuando se termine de comparar co las compañeras se pueda avanzar al siguente caracter [si es que está permitido, según el resultado del for de abajito
        //Quien será el que posea las condiciones para saber si se puede seguir avanzando o tiene que parar, o debe permitir que este siga o pare
        
    }

    /**
     * Encargado de revisar los listados que comiencen con el caracter de la posición actual en el string comparado,
     * y de parar el proceso cuando no sea necesario seguirlo ya sea porque no se hallo ninguna coincidencia o porque
     * la posibilidad de hallar una > en la secuencia comparada no es posible o porque la secuencia comparadora no tiene
     * la posibilidad de dar un conjunto > al obtenido; de esta manera es posible hallar las coincidencias sin importar 
     * donde estén ubicadas
     * 
     * @param listaCoincidencias
     * @param listaDePosicionesDeCaracterActual
     * @param secuencias
     * @param posicionDelCaracterActual
     
     */
    public void hallarConjuntosSimilares(ListaEnlazada<String> listaCoincidencias, ListaEnlazada<Integer> listaDePosicionesDeCaracterActual,String secuencias[], int posicionDelCaracterActual){//se recibe el numero de caracter a comp+1        
        String coincidenciaEnFormacion=String.valueOf(listaDePosicionesDeCaracterActual.obtenerNombre());
        boolean aprobacionParaSeguir=true;      
        Nodo<Integer> nodoAuxiliar=listaDePosicionesDeCaracterActual.obtnerPrimerNodo();
        int indiceCoincidenciaARevisar=nodoAuxiliar.contenido+1;//porque el primer caracter es el que corresponde al nombre de la lista que fue revisado y encontrado para trabajar con la lista correspondiente aquí
        
        while(aprobacionParaSeguir && nodoAuxiliar!=null){//es que realemnte no es necesario esto porqu eal ser null se para TODO el proceso [según lo que he visto al debuggear]
            for (int caracteresARevisar = posicionDelCaracterActual; caracteresARevisar <
                    (caracteresARevisar+obtenerCantidadARecorrer(secuencias, caracteresARevisar, indiceCoincidenciaARevisar)); caracteresARevisar++) {//pues no puede seguirse revisando si la cadena más pequeña ya se acabó :v, lo cual se determina al mandar la ubicación actual, por el hecho de que se requiere actualizar la distancia al existir coincidencias
                if(secuencias[0].charAt(caracteresARevisar)==secuencias[1].charAt(indiceCoincidenciaARevisar)){
                    coincidenciaEnFormacion=coincidenciaEnFormacion+String.valueOf(secuencias[0].charAt(caracteresARevisar));
                    indiceCoincidenciaARevisar++;//De alguna manera se inserta una letra extra, que varía, porque la vez pasada fue la c y era la primera y ahora la g yera la 2da... deplnao que es el manejo ded algún indice
                    //es decir que avanzas de más.. pero de todos modos lo que le estoy concatenando es lo de la sec[0]... esta vez la letra correspondia al conjunto de ella la vez pasada a ninguna... creo que es la letra + repetida la que se add "solita"
                }else{
                    break;//si llegase a parar a ambos ciclos debes hacer que la var tenga un valor que no cumpla req para que para elfor
                }                                                               
            }
            
            if(coincidenciaEnFormacion.length()>1){//pues el primer elemento coincidiente sería el tipo de caracter con el que inicia la lista... por ello no puedo comenzar a concatenar el string estando él en blanco pues la primera coinci fue la del nombre de la lista [el primer caracter hallado en la poscion a revisar actual del for del mét de arriba]
                if(listaCoincidencias.estaVacia()){
                    listaCoincidencias.anadirAlFinal(coincidenciaEnFormacion);
                }else{
                    if(coincidenciaEnFormacion.length()>listaCoincidencias.obtnerPrimerNodo().contenido.length()){//con obtener el primer nodo bastaría porque como los demás tendrán el mismo tamaño... solo que si 
                        //llega una coicidencia nueva mayor, entonces se tendrá que borrar toda la lista ya que todas esasa palabras son menores a la reciente
                        listaCoincidencias.limpiarLIstaCompletamente();
                        listaCoincidencias.anadirAlFinal(coincidenciaEnFormacion);
                    }else if(coincidenciaEnFormacion.length()==listaCoincidencias.obtnerPrimerNodo().contenido.length()){//si llegara a decir que esto no lo quiere, entonces solo vuelves la coinci> String y en lugar de añadir al final sustiuyes el valor por el nuevo dado
                        listaCoincidencias.anadirAlFinal(coincidenciaEnFormacion);
                    }
                }
                
                if(nodoAuxiliar.nodoSiguiente!=null){
                    if((secuencias[0].length()-posicionDelCaracterActual)<listaCoincidencias.obtnerPrimerNodo().contenido.length() || //en este if se revisa si lo que sobra o falta es mayor en tamaño a la coincidencia, pues si no es así se trabajaría en vano
                        (secuencias[1].length()-(nodoAuxiliar.nodoSiguiente.contenido+1))<listaCoincidencias.obtnerPrimerNodo().contenido.length()){//pues sin importar cual de las dos se incumpla no existen posibilidades de hallar una coincidencia >=
                            aprobacionParaSeguir=false;//relamente al tener cualquiera de estas dos condis cumplidas en la revisión debería parar completamente puesto que ya no hay posibilidad
                            //pues puede que hayan más caracteres en la cadena grande pero ya no en la peq, entonces no podrá hallarse una 
                    }else{
                        coincidenciaEnFormacion=String.valueOf(listaDePosicionesDeCaracterActual.obtenerNombre());//debe estar aquí pues media vez haya recopilado algo más que la letra actual
                        //debe ser eliminado para comenzar desde 0 con la compañera si es que cumple con los requisitos de arribita
                    }
                }                
                
                
                
            }//fin del if que revisa condiciones al tener una coincidencia guardada
            
          
                if(listaCoincidencias.estaVacia() || aprobacionParaSeguir){                
                    nodoAuxiliar=nodoAuxiliar.nodoSiguiente;    
                     if(nodoAuxiliar!=null){
                        indiceCoincidenciaARevisar=nodoAuxiliar.contenido+1;//como puede que lleguemos al final con estas dos condis activas entonces debes poner && el nodo!=null PERO PIENSALO BIEN!                                
                    }//al igual que antes debes comenzar en el sigueiten porque es un hecho que en la ubicación guardada hay coincidencia
                }
            
        }
        
        //ya no es necesario que retorne puesto que estoy manipulando el mismísimo elemento, solo que ahora en este método
        
        //ES QUE ESTE FOR ES PARA DAR LA POSIBILIDAD DE COMPARAR CON LAS COMPAÑERAS, PUESTO QUE AL TERMINAR DE REVISAR UNA [donde no se hallen coinci]
        //debes regresar a la ubicación de donde partiste a comparar con el caracter actual
           
                //Es decir que aquí se haría la comparación a partir del siguiente al numero recibido para [0] y el sigueinte del de la lista enlazada para [1]
                //y cuando hayan diferencias parar y almacenar en la lista enlazada y corroborar lo de los tamños, de priemro con [0] y luego con las compañeras si ellas no cumplen
                //salir de aquí, avanzar en el for de arriba y hacer la debida comparación porque ya hay una coinci, [es decur si el listado de coincid es nulo, no revsar tam de esa letra nueva
                //sino comparar para saber si ese for [el exte] debe parar o seguir
        
        
    }
    
    public int obtenerCantidadARecorrer(String[] secuencias, int posicion1, int posicion2){
        if((secuencias[0].length()-posicion1)>(secuencias[1].length()-posicion2)){
            return secuencias[1].length()-posicion2;
        }
        
        return (secuencias[0].length()-posicion1);
    }
    
    private ListaEnlazada<Integer> hallarListadoCaracterActual(char caracterAComparar){//Es empleado para comenzar la búsqueda de la coincidencia en el listado que corresponda al caracter de la ubicacióna ctual
        Nodo<ListaEnlazada<Integer>> nodoAuxiliar = listaDeUbicaciones.obtnerPrimerNodo();
        
        for (int nucleotido = 0; nucleotido < listaDeUbicaciones.darTamanio(); nucleotido++) {       
       
           if(nodoAuxiliar.contenido.obtenerNombre() == caracterAComparar){//con los char se puede emplear el == para comparar
              nucleotido=listaDeUbicaciones.darTamanio()+1;//aunque siempre serán 4... o tal vez no xD
           }else{
               nodoAuxiliar=nodoAuxiliar.nodoSiguiente;
           }                            
       }
        
        if(nodoAuxiliar==null){
            return null;
        }
        
        return nodoAuxiliar.contenido;//es el listado que corresponde al caracter de la ubicación en la que se está actualemnte
        
    }  
          
}

/*
Pasos (esto es para buscar las coin, no cuando se haya encontrado una segunda o tercera... que es el mismo proceso)
    -> compruebo que sean las letras que corresponden a los nucleótidos
    -> encuentro la cadena <=
    -> hallo las ubicaciones de cad nucleótido de la cadena <=
    -> comienzo a recorrer la cadena comparada para buscar las coind con 
    la cadenas que salen a partir de cada repetición de la letra en cuestión
    -> concateno los caracteres coincidientes
    -> comparo tamaños para seguir con el proceso 
     |---> 1. con la cadena comparada si queda un # de caracteres >= al del string coin 
     |        SI SI 
     |             1.2. compara con las compañeras de la letra en cuestión [o la primera del listado si es que        
     |              ya la lista de las letras ant incumplian con el >= o ya no habían más                          
     |                  -> si es > sigo con las compañeras                                                             
     |                  -> sino                                                                                                      
     |                  .> avanzo --|             
     -------------------------------
               SI NO 
                -> Finaliza proceso de búsqueda           
*/


