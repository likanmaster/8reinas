package pkg8reinas;
import java.util.*;
import java.io.*;
import java.math.*;
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
  
public static int randomabin(int semilla){ // con a cota inferior y b cota superior (ENTEROS)
  Random r = new Random();
      int valorDado = r.nextInt(2);  // Entre 0 y 1.
    return valorDado;
    
    
   }
  
   public static double randomadec(int a, int b, int semilla){ // con a cota inferior y b cota superior (decimales)
    Random rnd = new Random(semilla);
    Double rndInd = b + ( a - b ) * rnd.nextDouble();
    return rndInd;
   }
     public static int randomanint(int a, int b, int semilla){ // con a cota inferior y b cota superior (ENTEROS)
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
    public static void main(String[] args) {
        // TODO code application logic here
        int semilla=4524;
        int tpoblacion=10;
        int pcruza=10;
        int pmutaccion=10;
        int iteraciones=10;
        
                
        int tabo = randomabin(semilla);//tablero de 8
    double tabo2 = randomadec(0,10,semilla);
         System.out.println(tabo); 
        System.out.println(tabo2); 
    }
   
    
}
