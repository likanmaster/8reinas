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
  
   public static double randomadec(int a, int b, int semilla){ // random con rago de [a b](decimales)
    Random rnd = new Random(semilla);
    Double rndInd = b + ( a - b ) * rnd.nextDouble();
    return rndInd;
   }
     public static int randomanint(int a, int b, int semilla){ //  random con rago de [a b](decimales)
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
   static int fittnes(int [] tablero){  // funcion de fittnes para obtener la cantidad de choques
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
  
    static int ruolette(ArrayList<Integer> fitvalores, ArrayList<int[]> poblacion, int semilla){  // funcion de ruleta para elegir un tableros
        int totalfitnes = 0;
        int totalfitnesnuevo = 0;
        int indtablero = 0;
        int semi=semilla;
        int maxfitnes=0;
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
    
   
    public static void main(String[] args) {
        // TODO code application logic here
        int semilla=4;
        int tpoblacion=4;
        int pcruza=10;
        int pmutaccion=10;
        int iteraciones=10;
        int ttablero=3;
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
        //selecionamos dos padres por medio de la ruleta
        int padre1=ruolette(fitvalores,poblacion, semilla);
       System.out.println("padre 1 "+padre1);
        int padre2=ruolette(fitvalores,poblacion, semilla);
        System.out.println("padre 2 "+padre2);
         //realiza la cruza
        //se crea una nueva generacion
       




//  int tabo = randomabin(semilla);//tablero de 8
   // double tabo2 = randomadec(0,10,semilla);
        
      // int[] tabo3= RandomizeArray(0, 10);
      //  System.out.print(Arrays.toString(tabo3));
    }
   
    
}
