package pkg8reinas;
import java.util.*;
import java.util.ArrayList;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author likanmaster
 */
public class Main { 
  //numero randomico entre 0 y uno. depende de la semilla
    public static int randomabin(int semilla){ 
      Random r = new Random();
      int valor = r.nextInt(2);  // Entre 0 y 1.
    return valor;
   }
    // random con rango de [a b](decimales) para comparar la probabilidad de cruza y mutacion
    public static double randomadec(int a, int b, int semilla){ 
    Random r = new Random(semilla);
    Double ri = b + ( a - b ) * r.nextDouble(); 
    return ri;
   }
    //  random con rango de [a b](enter0) para la posicion de los vectores 
    public static int randomanint(int a, int b, int semilla){ 
    Random rnd = new Random(semilla);
    int rndInd = (int)(b + ( a - b ) * rnd.nextDouble());
    return rndInd;
   }
 // creamos array de a - b onrdenados aleatoriamente sin repetirse para generar el tablero
    public static int[] RandomizeArray(int a, int b){
		Random rgen = new Random();   	
		int size = b-a+1;
		int[] array = new int[size];
 
		for(int i=0; i< size; i++){
			array[i] = a+i;
		}
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		
 
		return array;
	}
    // funcion de fittnes para obtener la cantidad de choques que hay en los tableros
    public static int fittnes(int [] tablero){  
    int cantidadchoques=0;          // si hay dos numeros iguales,suma un choque
        for(int i=0;i<tablero.length;i++){  
            for(int j=0;j<tablero.length;j++){
                if((i-tablero[i]==j-tablero[j])||(i+tablero[i])==j+tablero[j]){
                 cantidadchoques++;
                }
            }
        }     
        cantidadchoques=Math.abs(cantidadchoques-tablero.length);
    return cantidadchoques;
    }
  // funcion de ruleta para elegir un tableros
    public static int ruolette(ArrayList<Integer> fitvalores, ArrayList<int[]> poblacion, int semilla){  
        int totalfitnes = 0;
        int totalfitnesnuevo = 0;
        int indtablero = 0;
        int semi=semilla;
        int tpoblacion=poblacion.size();
        int []nuevofitness = new int [fitvalores.size()];
        double []nproporcion = new double [fitvalores.size()];
        ArrayList <Double> proporcion = new ArrayList<>();//proporcion de la ruleta
        ArrayList <Double> ruleta = new ArrayList<>();
        //obtener el max fitnes
        for(int i=0;i<fitvalores.size();i++){  //total de fitnes
          totalfitnes=totalfitnes+fitvalores.get(i);
            }
        
        for(int i=0;i<fitvalores.size();i++){  //poner datos en el nuevo fittnes inverso
          double pro=(tpoblacion*tpoblacion-tpoblacion)-fitvalores.get(i);
             nuevofitness[i]= (int) pro;
             // System.out.println("nuevo fitnes"+nuevofitness[i]);
           }   
        for(int i=0;i<fitvalores.size();i++){  //total de fitnes nuevo o inverso
          totalfitnesnuevo=(totalfitnesnuevo+nuevofitness[i]);//para que los mejores casos usen mas espacio
           }
     
       for(int i=0;i<fitvalores.size();i++){  //poner datos en el array proporcion
         double  var1=nuevofitness[i];
         double var2=totalfitnesnuevo;
         double pro=var1/var2;
         nproporcion[i]=pro;
         //System.out.println("nueva proporcion "+nproporcion[i]);
           } 
     ruleta.add(nproporcion[0]);
    // System.out.println("primera propporniaso "+nproporcion[0]);
       for(int i=1;i<fitvalores.size();i++){  //poner datos en la ruleta
        double var1=ruleta.get(i-1);
        double var2=nproporcion[i];
           ruleta.add(var1+var2);
        //System.out.println("ruleta "+ruleta.get(i));
          }
        double num=randomadec(0,1,semi);
        // System.out.println("numero random dec   "+num);       
         for(int i=0;i<fitvalores.size();i++){  //poner datos en el array proporcion
        // System.out.println(ruleta.get(i));
            if(num<ruleta.get(i)){
              indtablero=i;
              //System.out.println("se guardo el tablero   "+indtablero);
              break;
            }
          }
       return indtablero;//esto devuelve el indice del tablero  ganador en la ruleta
    }
    //funcion para obtener eel vector padre dado el indice de ubicacion en el array
    public static int[] obtenerpadre(ArrayList<int[]> poblacion, int ttablero, int padre1) {
        int[] padre = new int[ttablero];
        for(int i=0;i<poblacion.size();i++){  //total de fitnes
               // System.out.println("sapos qls"+poblacion.get(i));
               if (i==padre1) {
                //System.out.println("padre "+Arrays.toString(poblacion.get(i)));
                padre=poblacion.get(i);
            }    
            //for (int j = 0; j<=ttablero ; j++) {
              //   System.out.print("padre  em vec"+padre[j]);
            //}
        }
       return padre;
    }
    //funcion booleana para saber si se cruzan 
    public static boolean probabilidadcruza(double pcruza, double randomdec){
       boolean pcruzas;
        pcruzas = false;
        if(pcruza > randomdec){
            pcruzas = true;
        }
        else{
           pcruzas = false;
        }
        return pcruzas;
    }
    //esta funcion recibe al padre , la madre, el tamaño del tablero, el numero de corte, y una condicion que dice si queremos el primer o segundo hijo
    public static int [] cruza(int[] padre,int[]madre, int ttablero, int mitad, int con){ 
       int [] hijo=new int[ttablero+1];    
       int tam=ttablero+1;  
       int mid = mitad;
         //System.out.println("mitad "+mitad);
       int[] padreaux=padre;
       int[] madreaux=madre;
       //for (int i = 0; i < tam; i++) {
         //  System.out.print("v"+madreaux[i]);
        //}
       // for (int i = 0; i <tam; i++) {
          //  hijo[i]=7;
          //  System.out.print("h"+hijo[i]);
           // System.out.print(madreaux[i]);
        //}
        //System.out.println("ijo con ceros "+hijo);
           if (con==1) {
            for(int i=0; i<mid;i++){
                hijo[i]=padre[i]; // 
                //System.out.println("recibe del padre el "+hijo[i]);
                }
            for(int i=mid;i<tam;i++){
                hijo[i]=madre[i];
               //  System.out.println("recibe de la madre el "+hijo[i]);
           }
          }
           
           if (con==2) {
            for(int i=0; i<mid;i++){
                hijo[i]=madre[i]; // 
              //  System.out.println("recibe del padre el "+hijo[i]);
                }
            for(int i=mid;i<tam;i++){
                hijo[i]=padre[i];
             // System.out.println("recibe de la madre el "+hijo[i]);
           }
          } 
           return hijo;
    } 
    //funcion de prueba que repara un hijo si este tiene dos numeros iguales, es decir choques verticales
    public static int[]reparacion(int[] hijo,int ttablero){
       int []hijor=new int[ttablero];
       int falta;
       int cont=0;
       int aux;
       int repite;
       ArrayList<Integer> repetidos = new ArrayList<>();
       ArrayList<Integer> faltantes = new ArrayList<>();
       for(int i=0;i<=ttablero;i++){
       aux=hijo[i];
            for(int j=0;j<=ttablero;j++){
                  if(aux==hijo[j]){
                   cont=cont+1;
                  // System.out.println("contador "+cont+" se repite el hijo " +hijo[j]);
                  }
                  if (cont>=2) {
                   repite=hijo[j];
                   repetidos.add(repite);
                   // System.out.println("se repite el numero "+repite );
                    cont=0;   
                 } 
             
            }
           cont=0;  
        }
        
        //limpiar de repetidos el array repetidos
        for (int i = 0; i<repetidos.size(); i++) {
            int auxi=repetidos.get(i);
            //System.out.println("aux   "+ auxi );
            for (int j = i+1;j<repetidos.size() ; j++) {
                if (auxi==repetidos.get(j)) {
                   //System.out.println("repetidos   "+ repetidos.get(i) );
                    repetidos.remove(j);
                   
                }
                
            }
         
        }
        
        for (int i = 0; i <repetidos.size(); i++) {
            System.out.println("repetidos finalmente  "+ repetidos.get(i) );
        }
        int a=0;
          for (int i = 0; i <=ttablero; i++) {
           int auxx=i;
              for (int j = 0; j<=ttablero; j++) {
                
              }
        }
       int [] auscio=new int [ttablero];
        for (int i = 0; i <ttablero; i++) {
            auscio[i]=0;
        //    System.out.println("auscio  "+auscio[i]);
        }
        
        for (int i = 0; i <ttablero; i++) {
           // int amp=i;
            for (int j = 0; j<ttablero; j++) {
                if (i==hijo[j]) {
                    auscio[i]=1;
                }
            }
        }
        
        for (int i = 0; i <ttablero; i++) {
             // System.out.print(""+auscio[i]);
        }
        for (int i = 0; i <ttablero; i++) {
            if (auscio[i]==0) {
                 System.out.println("falta el numero "+(i));
                 faltantes.add(i);
            }
        }
        
       return hijor;
    }
   //funcion que repara un hijo si este tiene dos numeros iguales, esta si, es decir choques verticales
    public static int[]reparacion2(int[] hijo,int ttablero){
    int[] hijor= RandomizeArray(0, ttablero);
       return hijor;
    }
   // funcion que intercambia dos numeros en un vector
    private static int[] mutacion(int[] hijo1, int ttablero,int num1,int num2, double prob,double pmutacion) {
           int aux;
        if (prob<pmutacion) {
        for (int i = 0; i <ttablero; i++) {
            if (i==num1) {
                aux=hijo1[i];
                hijo1[i]=hijo1[num2];
                hijo1[num2]=aux;
            }
        }    
        }
     return hijo1;
    }
     //
    public static void dibujo(int [] tablero){
     for(int i=0; i < tablero.length; i++) {
          
           for(int j=0; j < tablero.length; j++) {
             if (tablero[i]==j){
               System.out.print("☻ ");
             }
             else {
               System.out.print ("☺ ");
             }
           }
           System.out.println ("");
     }
    }
    //funcion que dibuja una matriz con caras blancas(casillas vacias), y caras negras(con reinas)
    public static void main(String[] args) {
        // variables iniciales
        int    semilla     ;           
        int    tpoblacion  ;
        double pcruza      ;
        double pmutaccion  ;
        int    iteraciones ;
        int    ttablero    ;
        ArrayList<Integer> fitvalores = new ArrayList<>();
        ArrayList<int []>  poblacion  = new ArrayList<>();//ponemos tableros a la poblacion  inicial
        ArrayList<int []>  nuevagen  = new ArrayList<>();
       /* Scanner sc=new Scanner(System.in);
            System.out.println("Ingrese semilla: ");
            semilla=sc.nextInt();
            System.out.println("Ingrese numero de reinas ");
            ttablero=(sc.nextInt()-1);
            System.out.println("Ingrese tamaño de la poblacion: ");
            tpoblacion=sc.nextInt();
            System.out.println("Ingrese numero de generaciones: ");
            iteraciones=sc.nextInt();
            System.out.println("Ingrese probabilidad de cruza (con coma en un rango de 0,0 a 1,0): ");
            pcruza=sc.nextDouble();
            System.out.println("Ingrese probabilidad de mutacion (con coma en un rango de 0,0 a 1,0): ");
            pmutaccion=sc.nextDouble();
            System.out.println();
         */  
             if (args.length <6) { //si hay más de 1 parámetro
			System.out.println("Debe ingresar 6 variables (semilla reinas poblacion generaciones probcruza probmutacion)");
			
		} 
             
             
             else {
                 //recibe las variables como strings
	String ssemilla     =args[0];           
        String sttablero    =args[1];
        String stpoblacion  =args[2];
        String siteraciones =args[3];
        String spcruza      =args[4];
        String spmutaccion  =args[5];
            //cambiar de string a enteros y decimales
            
            int isemilla = Integer.parseInt(ssemilla);
            int itpoblacion = Integer.parseInt(stpoblacion);
            double ipcruza = Double.parseDouble(spcruza);
            double ipmutaccion = Double.parseDouble(spmutaccion);
            int iiteraciones = Integer.parseInt(siteraciones);
            int itablero = Integer.parseInt(sttablero);
            // le pasamos el valor a las variables
            
            semilla     =isemilla;           
            tpoblacion  =itpoblacion;
            pcruza      =ipcruza;
            pmutaccion  =ipmutaccion;
            iteraciones =iiteraciones;
            ttablero    =itablero;
             int gen=1;
             boolean find=false;
        //inicializamos la poblacion de tableros randomicamente 1ra generacion
            for(int i=0;i<tpoblacion;i++){
            int[] tablero= RandomizeArray(0, ttablero);
            poblacion.add(tablero);
            int fit=fittnes(tablero);
            if (fit==0) {
                  //dibujo(tablero);
                   System.out.println(Arrays.toString(tablero));
                  System.out.println("En generacion 0");
                  find=true; 
                  break;
            }
            fitvalores.add(fit);
        }
            
        
        for (int kk = 0; kk < iteraciones; kk++) {
        //selecionamos dos padres por medio de la ruleta . solo obtenemos el iindice del tablero
        int padre1=ruolette(fitvalores,poblacion, semilla); 
        int padre2=ruolette(fitvalores,poblacion, semilla);
        // System.out.println("padre 1 "+padre1);
        //volvemos a elegir el padre 2 si es igual al padre 1
        int semilla2=10;
        while (padre2==padre1) {
               padre2=ruolette(fitvalores,poblacion, semilla2);
               semilla2=semilla2*2;
         //System.out.println("padre 2 "+ padre2);
        }
       
        // System.out.println("padre 2 "+padre2);
        //random decimal para ver si se cruzan los padres
        double  randomdeccc=randomadec(0,1,semilla);
    
         //obtenemos la mitad para hacer a los hijos
        int mitad=randomanint(0,ttablero, semilla);
        //recuperar padre y madre seleccionados
        int [] padrek=obtenerpadre(poblacion, ttablero, padre1);
        int [] padres=obtenerpadre(poblacion, ttablero, padre2);
        int [] hijo1= new int[ttablero];
        int [] hijo2= new int[ttablero];
        //realizamos la cruza
        boolean cruza;
        //obtenemos la probabilidad de cruza
        cruza=probabilidadcruza(pcruza, randomdeccc);
        if(cruza==true){
              hijo1 =cruza( padrek, padres,  ttablero, mitad, 1);
              hijo2 =cruza( padrek, padres,  ttablero, mitad, 2);
        }
        //  for (int i = 0; i <ttablero+1; i++) {
           // System.out.print( hijo1[i]);
      //  }
        //  System.out.println(" ");
        //   for (int i = 0; i <ttablero+1; i++) {
         //   System.out.print( hijo2[i]);
     //   }
      // System.out.println(" ");
        //reparamosa a los hijos si se repiten los numeros
        int[] hijoreparauno=reparacion2(hijo1,ttablero);
        int[] hijoreparados=reparacion2(hijo2,ttablero);
        //seleccionamos numeros enteros para hacer la mutacion. si esta dentro de la probabilidad
        int num1=randomanint(0, ttablero,  semilla);
        int num2=randomanint(0, ttablero,  semilla);
        //nos aseguramon que no salga el mismo numero
        int semilla3=10;
        while (num1==num2) {
               num2=randomanint(0, ttablero,  semilla3);
               semilla3=semilla3*2;
        }
        
      // System.out.println("numero 1 "+num1);
      // System.out.println("numero 2 "+num2);
      //seleccionamos la probabilidad para la mutacion
       double probmut=randomadec(0,1,semilla);
       //hacemos la mutacion de los hijos
       int[] hijolistouno=mutacion(hijo1,ttablero,num1,num2,probmut,pmutaccion);
       int[] hijolistodos=mutacion(hijo2,ttablero,num1,num2,probmut,pmutaccion);
       //agregamos lo hijos a la nueva generacion
       //nuevagen.add(hijolistouno);
      // nuevagen.add(hijolistodos);
       poblacion.add(padre1, hijolistouno);
       poblacion.add(padre2, hijolistodos);
       int fit=fittnes(hijolistouno);
       if (fit==0) {
                  //dibujo(hijolistouno);
                  System.out.println(Arrays.toString(hijolistouno));
                  System.out.println("En generacion "+(kk+1));
                  find=true;
                  break;
       }
       int fiti=fittnes(hijolistodos);
       if (fiti==0) {
                  //dibujo(hijolistouno);
                  System.out.println(Arrays.toString(hijolistodos));
                  System.out.println("En generacion "+(kk+1));
                  find=true;
                  break;
       }
       
            
       fitvalores.add(padre1,fit);
       fitvalores.add(padre2,fiti);
      //se crea una nueva generacion
     }//fin llenado de nueva generacion
                 
        int mejor=100;
        
        for(int i = 0; i < fitvalores.size(); i++){
	    if(fitvalores.get(i)<mejor){
                mejor=fitvalores.get(i);
        	}
			
	}
        int [] mejorcito=obtenerpadre(poblacion, ttablero, mejor);
        if (find==false) {
                     
                   
                      System.out.print("la mejor solucion es ");
                      System.out.println(Arrays.toString(mejorcito));
                 }
   }
    }

}
