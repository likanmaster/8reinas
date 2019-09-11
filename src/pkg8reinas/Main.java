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
 
    public void calcularfittnes(){//funcion para calcular el fittnes de cada individuo
         for (int i=0;i<10;i++){//cantidad de  tableros
            for (int j=0;j<8;j++){
           
            
            }
         }     
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
   
    public static void main(String[] args) {
        // TODO code application logic here
        int semilla=4524;
        int tpoblacion=100;
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
        
        
       




//  int tabo = randomabin(semilla);//tablero de 8
   // double tabo2 = randomadec(0,10,semilla);
        
      // int[] tabo3= RandomizeArray(0, 10);
      //  System.out.print(Arrays.toString(tabo3));
    }
   
    
}
