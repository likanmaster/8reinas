package pkg8reinas;
import java.util.*;
import java.io.*;
import java.math.*;
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
//Scanner sc = new Scanner(System.in);   
  
    public static int randomabin(int semilla){ //numero randomico entre 0 y uno. depende de la semilla
  Random r = new Random();
      int valorDado = r.nextInt(2);  // Entre 0 y 1.
    return valorDado;
   }
  
    public static double randomadec(int a, int b, int semilla){ // random con rango de [a b](decimales)
    Random rnd = new Random(semilla);
    Double rndInd = b + ( a - b ) * rnd.nextDouble();
    
    return rndInd;
   
   }
    public static int randomanint(int a, int b, int semilla){ //  random con rago de [a b](enter0)
    Random rnd = new Random(semilla);
    int rndInd = (int)(b + ( a - b ) * rnd.nextDouble());
    return rndInd;
   }
 
    public static int[] RandomizeArray(int a, int b){
		Random rgen = new Random();  // creamos array de a - b onrdenados aleatoriamente sin repetirse 	
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
    public static int fittnes(int [] tablero){  // funcion de fittnes para obtener la cantidad de choques
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
  
    public static int ruolette(ArrayList<Integer> fitvalores, ArrayList<int[]> poblacion, int semilla){  // funcion de ruleta para elegir un tableros
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
    
    private static int[] obtenerpadre(ArrayList<int[]> poblacion, int ttablero, int padre1) {
        int[] padre = new int[ttablero];
       
        for(int i=0;i<poblacion.size();i++){  //total de fitnes
            
               // System.out.println("sapos qls"+poblacion.get(i));
               if (i==padre1) {
                System.out.println("padre "+Arrays.toString(poblacion.get(i)));
                padre=poblacion.get(i);
               
            }
                
            //for (int j = 0; j<=ttablero ; j++) {
              //   System.out.print("padre  em vec"+padre[j]);
            //}
            
              
        }
    
       return padre;//esto devuelve el indice del tablero  ganador en la ruleta //To change body of generated methods, choose Tools | Templates.
    }
    
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
    
    public static int [] cruza(int[] padre,int[]madre, int ttablero, int mitad, int con){
       //esta funcion recibe al padre , la madre, el tamaño del tablero, el numero de corte, y una condicion que dice si queremos el primer o segundo hijo 
       int [] hijo=new int[ttablero+1];    
       int tam=ttablero+1;  
     //  System.out.println("tamaño tablero "+tam);
       int mid = mitad; //
         //System.out.println("mitad "+mitad);
       int[] padreaux=padre;
       int[] madreaux=madre;
       for (int i = 0; i < tam; i++) {
         //  System.out.print("v"+madreaux[i]);
        }
        for (int i = 0; i <tam; i++) {
            hijo[i]=7;
          //  System.out.print("h"+hijo[i]);
           // System.out.print(madreaux[i]);
        }
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
    public static int[]reparacion2(int[] hijo,int ttablero){
    int[] hijor= RandomizeArray(0, ttablero);
       return hijor;
    }
   
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
     
    
    public static void main(String[] args) {
        // TODO code application logic here
        int semilla=111110;
        int tpoblacion=5;
        double pcruza=1.0;
        double pmutaccion=1.0;
        int iteraciones=10;
        int ttablero=8;
        ArrayList<Integer> fitvalores = new ArrayList<>();
      // Declaración el ArrayList de la poblacion
        ArrayList<int []> poblacion = new ArrayList<>();//ponemos tableros a la poblacion 
        for(int i=0;i<tpoblacion;i++){
           int[] tablero= RandomizeArray(0, ttablero);
            poblacion.add(tablero);
            int fit=fittnes(tablero);
            fitvalores.add(fit);
            System.out.println(Arrays.toString(tablero));
            System.out.println( fit);
        }
        //selecionamos dos padres por medio de la ruleta . solo obtenemos el iindice del tablero
        int padre1=ruolette(fitvalores,poblacion, semilla);
            System.out.println("padre 1 "+padre1);
        int padre2=ruolette(fitvalores,poblacion, semilla);
        
    
          int semilla2=10;
          while (padre2==padre1) {
               padre2=ruolette(fitvalores,poblacion, semilla2);
               semilla2=semilla2*2;
               //System.out.println(semilla2);
         //System.out.println("padre 2 "+ padre2);
             }
       
          System.out.println("padre 2 "+padre2);
          double randomdeccc=randomadec(0,1,semilla);
         // System.out.print("decimal ranmod "+randomdeccc);
          boolean cruza;
          cruza=probabilidadcruza(pcruza, randomdeccc);
          //System.out.println("prob cruza "+cruza);
          
          //realiza la cruza¿
          int mitad=randomanint(0,ttablero, semilla);
          //recuperar padre y madre seleccionados
          
          System.out.println("mitad peruana "+mitad);
          int [] padrek=obtenerpadre(poblacion, ttablero, padre1);
          int [] padres=obtenerpadre(poblacion, ttablero, padre2);
          int [] hijo1= new int[ttablero];;
          int [] hijo2= new int[ttablero];;
          
          for (int i = 0; i <=ttablero; i++) {
          //   hijo1[i]=0;
        }
          for (int i = 0; i <=ttablero; i++) {
           // System.out.print( hijo1[i]);
        }
           System.out.println("--------------");
         if(cruza==true){//realizamos la cruza
           //  int []padre={2,2,2,2,2,2,2,2};
            // int []madre={2,2,2,2,2,2,2,2};
             // System.out.println("cruzamiento");
              hijo1 =cruza( padrek, padres,  ttablero, mitad, 1);
              hijo2 =cruza( padrek, padres,  ttablero, mitad, 2);
             
         }
          for (int i = 0; i <ttablero+1; i++) {
            System.out.print( hijo1[i]);
        }
          System.out.println(" ");
           for (int i = 0; i <ttablero+1; i++) {
            System.out.print( hijo2[i]);
        }
       System.out.println(" ");
       
       int[] hijoreparauno=reparacion2(hijo1,ttablero);
       int[] hijoreparados=reparacion2(hijo2,ttablero);
       int num1=randomanint(0, ttablero,  semilla);
       int num2=randomanint(0, ttablero,  semilla);
       int semilla3=10;
          while (num1==num2) {
               num2=randomanint(0, ttablero,  semilla3);
               semilla3=semilla3*2;
               //System.out.println(semilla2);
         //System.out.println("padre 2 "+ padre2);
             }
       System.out.println("numero 1 "+num1);
       System.out.println("numero 2 "+num2);
        double probmut=randomadec(0,1,semilla);
       int[] hijolistouno=mutacion(hijo1,ttablero,num1,num2,probmut,pmutaccion);
       int[] hijolistodos=mutacion(hijo2,ttablero,num1,num2,probmut,pmutaccion);
   //se crea una nueva generacion
   //  int tabo = randomabin(semilla);//tablero de 8
   // double tabo2 = randomadec(0,10,semilla);
        
      // int[] tabo3= RandomizeArray(0, 10);
      //  System.out.print(Arrays.toString(tabo3));
    }

}
